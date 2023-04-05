/*
 * FaceCat图形通讯框架
 * 上海卷卷猫信息技术有限公司
 */

package Android;

import android.content.DialogInterface;

import Product.UI.*;
import facecat.topin.chart.*;
import facecat.topin.div.*;
import facecat.topin.input.*;
import facecat.topin.core.*;
import facecat.topin.scroll.*;
import topin.facecat.FaceCat.MainActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 视图
 */
public class  FCUIVIew extends ViewGroup implements TextWatcher {
    /**
     * 构造函数
     * @param context 上下文
     */
    public FCUIVIew(Context context) {
        super(context);
        setWillNotDraw(false);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
    }

    /*
    * 是否允许滚动
     */
    private boolean m_allowScroll = true;

    /*
     * 是否自动布局
     */
    private boolean m_autoLayout = true;

    /*
     * 编辑中的文本框
     */
    private FCTextBox m_editingTextBox;

    /*
     * 第一次点击
     */
    private long m_firClick;

    /*
     * 对接设备
     */
    private AndroidHost m_host = null;

    /*
     * 纵向滚动值
     */
    private int m_scrollY;

    /*
     * 第二次点击
     */
    private long m_secClick;

    /*
     * 缩放比例
     */
    public double m_scaleFactor;

    /*
     * 历史输入框
     */
    public ClearEditText m_textBox;

    /*
     * 获取设置
     */
    public AndroidHost getHost() {
        return m_host;
    }

    private FCNative m_native = null;

    /*
     * 获取方法库
     */
    public FCNative getNative() {
        return m_native;
    }

    private AndroidPaint m_paint = null;

    /*
     * 获取绘图对象
     */
    public AndroidPaint getPaint() {
        return m_paint;
    }

    public double getRate() {
        return m_host.getScaleRate();
    }

    /*
     * 是否允许滚动
     */
    private boolean m_scrollEnabled = true;

    /*
     * 滚动视图
     */
    private ScrollView m_scrollView;

    /*
     * 点击次数
     */
    private int m_touchCount;

    /*
     * 设置是否允许滚动
     */
    public void setAllowScroll(boolean allowScroll) {
        m_allowScroll = allowScroll;
    }

    /*
     * 上次焦点的视图
     */
    public FCView m_lastFocusedView;

    /**
     * 设置滚动视图
     * @param view 视图
     */
    public void setScrollView(ScrollView view) {
        m_scrollView = view;
        m_scrollView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (m_allowScroll && m_scrollEnabled) {
                    return false;
                } else {
                    try {
                        int action = event.getAction();
                        if (action == MotionEvent.ACTION_MOVE) {
                            float x = event.getX();
                            float y = event.getY() + m_scrollView.getScrollY();
                            m_host.setTouchPoint(new FCPoint(x, y));
                            FCTouchInfo touchInfo = new FCTouchInfo();
                            ((AndroidHost) m_host).getTouches(event, touchInfo);
                            touchInfo.m_clicks = m_lastClickCount;
                            m_native.onTouchMove(touchInfo);
                        } else {
                            if (action == MotionEvent.ACTION_UP) {
                                m_scrollEnabled = true;
                                float x = event.getX();
                                float y = event.getY() + m_scrollView.getScrollY();
                                m_host.setTouchPoint(new FCPoint(x, y));
                                FCTouchInfo touchInfo = new FCTouchInfo();
                                ((AndroidHost) m_host).getTouches(event, touchInfo);
                                touchInfo.m_clicks = m_lastClickCount;
                                m_native.onTouchEnd(touchInfo);
                            }
                        }
                    } catch (Exception ex) {

                    }
                    return true;
                }
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 文字改变
     * @param s 参数
     */
    @Override
    public void afterTextChanged(Editable s) {

    }

    /**
     * 文字改变前
     * @param s
     * @param start
     * @param count
     * @param after
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    /**
     * 处理键盘事件
     * @param event
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            hideTextBox(m_editingTextBox);
        }
        return super.dispatchKeyEvent(event);
    }

    /**
     * 删除资源
     */
    public void delete() {
        if (m_host != null) {
            m_host.m_threadState = 2;
        }
        if (m_native != null) {
            ((FCNative) m_native).delete();
        }
        m_native = null;
        m_paint = null;
        m_host = null;
        m_textBox = null;
        m_editingTextBox = null;
        m_scrollView = null;
    }

    /**
     * 隐藏本文框
     * @param textBox 文本框
     */
    public void hideTextBox(FCDiv textBox) {
        try {
            FCTextBox txt1 = (FCTextBox) ((textBox instanceof FCTextBox) ? textBox : null);
            if (txt1 != null) {
                if (m_textBox != null && m_textBox.getParent() != null && textBox != null) {
                    textBox.setFocused(false);
                    textBox.onLostFocus();
                    String text = m_textBox.getText().toString();
                    FCSpin spin = (FCSpin) ((textBox instanceof FCSpin) ? textBox : null);
                    if (spin != null) {
                        text = FCTran.getValueByDigit(FCTran.strToDouble(text), spin.getDigit());
                    }
                    textBox.setText(text);
                    int textLength = text.length();
                    if (textLength > 0) {
                        FCTextBox old1 = (FCTextBox) ((m_editingTextBox instanceof FCTextBox) ? m_editingTextBox : null);
                        if (old1 != null) {
                            old1.setSelectionLength(0);
                            old1.setSelectionStart(textLength + 1);
                        }
                    }
                    m_native.invalidate();
                    m_editingTextBox = null;
                    try {
                        m_textBox.clearFocus();
                        if (!m_allowScroll) {
                            m_scrollView.scrollTo(0, 0);
                        }
                        if (m_scrollView != null) {
                            m_scrollView.scrollTo(0, m_scrollY - 300);
                        }
                    } catch (Exception ex) {
                    }
                }
                m_editingTextBox = null;
                removeView(m_textBox);
                this.layout(0, 0, getWidth(),  getHeight());
            }
        } catch (Exception ex) {
        }
    }

    /*
    * 上次点击次数
     */
    public int m_lastClickCount;

    /*
    * 上次的坐标
     */
    public FCPoint m_lastPoint = new FCPoint();

    /**
     * 手指按下
     * */
    private void onActionDown(MotionEvent event) {
        try {
            this.requestFocus();
            if (m_native != null) {
                int touchCount = 1;
                float x = event.getX();
                float y = event.getY();
                int pointerCount = event.getPointerCount();
                if (pointerCount == 1) {
                    m_touchCount++;
                    if (m_touchCount == 1) {
                        m_firClick = System.currentTimeMillis();
                    } else if (m_touchCount == 2) {
                        m_secClick = System.currentTimeMillis();
                        if (m_secClick - m_firClick < 800 && Math.abs(x - m_lastPoint.x) < getWidth() / 50 && Math.abs(y - m_lastPoint.y) < getHeight() / 50) {
                            touchCount = 2;
                            m_touchCount = 0;
                            m_firClick = 0;
                            m_secClick = 0;
                        }else{
                            touchCount = 1;
                            m_touchCount = 1;
                            m_firClick = System.currentTimeMillis();
                        }
                    }else{
                        m_touchCount = 0;
                        touchCount = 1;
                    }
                }else{
                    m_touchCount = 0;
                    touchCount = 1;
                }

                if(touchCount == 0){
                    touchCount = 1;
                    m_touchCount = 0;
                }
                FCView oldFocusedControl = m_native.getFocusedView();
                m_host.setTouchPoint(new FCPoint(x, y));
                FCTouchInfo touchInfo = new FCTouchInfo();
                ((AndroidHost) m_host).getTouches(event, touchInfo);
                touchInfo.m_clicks = touchCount;
                m_native.onTouchBegin(touchInfo);
                //ArrayList<CTouch> cTouches = new ArrayList<>();
                //m_host.GetTouches(event, cTouches);
                //m_native.OnTouchBegin(cTouches);
                FCView newFocusedControl = m_native.getFocusedView();
                m_newFocusedView = newFocusedControl;
                boolean scrollEnabled = true;
                if (m_scrollView != null && newFocusedControl != null) {
                    if (newFocusedControl.allowDrag()) {
                        scrollEnabled = false;
                    } else {
                        FCChart chart = (FCChart) ((newFocusedControl instanceof FCChart) ? newFocusedControl : null);
                        boolean parentIsChart = false;
                        if (chart == null && newFocusedControl.getParent() != null) {
                            chart = (FCChart) (
                                    (newFocusedControl.getParent() instanceof FCChart) ? newFocusedControl.getParent() : null

                            );
                            parentIsChart = true;
                        }
                        if (chart != null) {
                            if (parentIsChart) {
                                scrollEnabled = false;
                            } else {
                                if (chart.isOperating() || chart.showCrossLine()) {
                                    scrollEnabled = false;
                                }
                            }
                        }
                        FCView previewsControl = m_host.findPreviewsControl(newFocusedControl);
                        if (previewsControl == null) {
                            previewsControl = newFocusedControl;
                        }
                        FCDiv div = (FCDiv) ((previewsControl instanceof FCDiv) ? previewsControl : null);
                        if (div != null && div.allowDragScroll()) {
                            if ((div.getVScrollBar() != null && div.getVScrollBar().isVisible()) || (div.getHScrollBar() != null && div.getHScrollBar().isVisible())) {
                                scrollEnabled = false;
                            }
                        }
                    }
                }
                m_scrollEnabled = scrollEnabled;
                if (true) {
                    FCPoint mousePoint = m_host.getTouchPoint();
                    FCDiv oldTextBox = null;
                    if (oldFocusedControl != null) {
                        oldTextBox = (FCTextBox) ((oldFocusedControl instanceof FCTextBox) ? oldFocusedControl : null);
                    }
                    boolean showTextBox = false;
                    if (newFocusedControl != null) {
                        if (m_editingTextBox != null) {
                            boolean canHide = true;
                            if (canHide) {
                                hideTextBox(m_editingTextBox);
                            } else {
                                showTextBox = true;
                            }
                        }
                        FCTextBox textBox = (FCTextBox) (
                                (newFocusedControl instanceof FCTextBox) ? newFocusedControl : null
                        );
                        if (textBox != null && textBox.isEnabled() && !textBox.isReadOnly()) {
                            m_editingTextBox = textBox;
                            //m_editingTextBox->SetFocused(false);
                            ShowTextBox(m_editingTextBox);
                            showTextBox = true;
                        }
                        final DateTimeButton dateTimeButton = (DateTimeButton) (
                                (
                                        newFocusedControl instanceof DateTimeButton
                                ) ? newFocusedControl : null
                        );
                        if (dateTimeButton != null && dateTimeButton.isEnabled()) {
                            if (dateTimeButton.getDateMode().toLowerCase().equals("time")) {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                                dialog.setTitle("请选择时间");
                                final TimePicker timePicker = new TimePicker(dialog.getContext());
                                timePicker.setIs24HourView(true);
                                String strDate = dateTimeButton.getText();
                                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                                Date tempDate = null;
                                try {
                                    tempDate = sdf.parse(strDate);
                                } catch (Exception e) {
                                }
                                if (tempDate != null) {
                                    timePicker.setCurrentHour(tempDate.getHours());
                                    timePicker.setCurrentMinute(tempDate.getMinutes());
                                }
                                timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                                    @Override
                                    //此方法不会在安卓23api以下触发
                                    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                                        dateTimeButton.setText(String.format("%02d:%02d", hourOfDay, minute));
                                        dateTimeButton.invalidate();
                                    }
                                });
                                dialog.setView(timePicker);
                                //解决安卓api23以下无法改变时间问题
                                if (android.os.Build.VERSION.SDK_INT <= 23) {
                                    dialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            Integer hourOfDay = timePicker.getCurrentHour();
                                            Integer minute = timePicker.getCurrentMinute();
                                            dateTimeButton.setText(String.format("%02d:%02d", hourOfDay, minute));
                                            dateTimeButton.invalidate();
                                        }

                                    });
                                    dialog.setPositiveButton("取消", null);
                                } else {
                                    dialog.setNegativeButton("确定", null);
                                }
                                dialog.show();
                            } else {
                                if (dateTimeButton.getDateMode().toLowerCase().equals("date")) {
                                    AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                                    dialog.setTitle("请选择日期");
                                    DatePicker datePicker = new DatePicker(dialog.getContext());
                                    dialog.setView(datePicker);
                                    Calendar now = Calendar.getInstance(Locale.CHINA);
                                    datePicker.init(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                                        @Override
                                        public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                                            dateTimeButton.setText(String.format("%04d-%02d-%02d", year, month + 1,
                                                    day));
                                            dateTimeButton.invalidate();
                                        }
                                    });
                                    dialog.setNegativeButton("确定", null);
                                    dialog.setPositiveButton("取消", null);
                                    dialog.show();
                                }
                            }
                        }
                    }
                    if (!showTextBox) {
                        hideTextBox(oldTextBox);
                    }
                }
                m_native.invalidate();
                //cTouches.clear();
            }
        } catch (Exception ex) {

        }
    }

    /*
    * 新的焦点视图
     */
    public FCView m_newFocusedView;

    /**
     * 手指按下 -> 手指移动
     */
    private void onActionMove(MotionEvent event) {
        try {
            float x = event.getX();
            float y = event.getY();
            m_host.setTouchPoint(new FCPoint(x, y));
            FCView newFocusedControl = m_native.getFocusedView();
            boolean scrollEnabled = true;
            if (m_scrollView != null && newFocusedControl != null) {
                if (newFocusedControl.allowDrag()) {
                    scrollEnabled = false;
                } else {
                    FCChart chart = null;
                    boolean parentIsChart = false;
                    if (newFocusedControl instanceof FCChart) {
                        chart = (FCChart) newFocusedControl;
                    } else {
                        FCView tempControl = newFocusedControl.getParent();
                        if (tempControl != null && tempControl instanceof FCView) {
                            chart = (FCChart) tempControl;
                            parentIsChart = true;
                        }
                    }
                    if (chart != null) {
                        if (parentIsChart) {
                            scrollEnabled = false;
                        } else {
                            if (chart.isOperating() || chart.showCrossLine()) {
                                scrollEnabled = false;
                            }
                        }
                    }
                    FCView previewsControl = m_host.findPreviewsControl(newFocusedControl);
                    if (previewsControl == null) {
                        previewsControl = newFocusedControl;
                    }
                    if (previewsControl instanceof FCDiv) {
                        FCDiv div = (FCDiv) previewsControl;
                        if (div.allowDragScroll()) {
                            FCVScrollBar scrollBarA = div.getVScrollBar();
                            FCHScrollBar hScrollBarA = div.getHScrollBar();
                            if ((scrollBarA != null && scrollBarA.isVisible()) || (hScrollBarA != null && hScrollBarA.isVisible())) {
                                scrollEnabled = false;
                            }
                        }
                    }
                }
            }
            m_scrollEnabled = scrollEnabled;
            FCTouchInfo touchInfo = new FCTouchInfo();
            ((AndroidHost) m_host).getTouches(event, touchInfo);
            touchInfo.m_clicks = m_lastClickCount;
            m_native.onTouchMove(touchInfo);
        } catch (Exception ex) {

        }
        //ArrayList<CTouch> cTouches = new ArrayList<>();
        //_host.GetTouches(event, cTouches);
        //m_native.OnTouchMove(cTouches);
        //cTouches.clear();
    }

    /**
     * 手指按下 -> 手指抬起
     * */
    private void onActionUp(MotionEvent event, boolean cancel) {
        try {
            float x = event.getX();
            float y = event.getY();
            m_host.setTouchPoint(new FCPoint(x, y));
            FCTouchInfo touchInfo = new FCTouchInfo();
            ((AndroidHost) m_host).getTouches(event, touchInfo);
            touchInfo.m_clicks = m_lastClickCount;
            if (cancel) {
                m_native.onTouchCancel(touchInfo);
            }else{
                m_native.onTouchEnd(touchInfo);
            }
            m_lastFocusedView = m_newFocusedView;
        } catch (Exception ex) {

        }
    }

    /**
     * 绘图方法
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        if (m_host != null) {
            m_host.onPaint(canvas);
        }
    }

    /**
    * 加载视图
     */
    public void onLoad() {
        m_host = new AndroidHost();
        m_native = new FCNative();
        m_paint = new AndroidPaint();
        m_native.setHost(m_host);
        m_native.setPaint(m_paint);
        m_host.setNative(m_native);
        m_host.setView(this);
        m_native.setSize(new FCSize(getWidth(), getHeight()));
    }

    private UIXmlEx m_loadUI;

    /*
     * 获取XML对象
     */
    public UIXmlEx getLoadUI() {
        return m_loadUI;
    }

    /*
     * 设置XML对象
     */
    public void setLoadUI(UIXmlEx value) {
        m_loadUI = value;
    }

    private boolean m_uiIsLoaded = false;

    /*
     * 获取缩放比例
     */
    public double getScaleFactor() {
        return m_scaleFactor;
    }

    /*
     * 设置缩放比例
     */
    public void setScaleFactor(double scaleFactor) {
        m_scaleFactor = scaleFactor;
        resetLayout();
    }

    /**
     * 重置布局
     */
    public void resetLayout() {
        if (m_native != null) {
            if (m_scaleFactor == 0) {
                if (m_autoLayout) {
                    m_scaleFactor = m_host.getScaleRate();
                } else {
                    m_scaleFactor = 1.0;
                }
            }
            double rate = m_scaleFactor;
            if (rate != 1) {
                m_native.setAllowScaleSize(true);
                m_native.setScaleSize(new FCSize((int) (getWidth() / rate), (int) (getHeight() / rate)));
                m_native.setSize(new FCSize(getWidth(), getHeight()));
                //m_native.onScaling(rate, rate);
                m_native.update();
            } else {
                m_native.setAllowScaleSize(false);
                m_native.setSize(new FCSize(getWidth(), getHeight()));
                m_native.update();
            }
            if (!m_uiIsLoaded) {
                if (m_loadUI != null) {
                    m_loadUI.setNative(getNative());
                    setAllowScroll(false);
                    //m_loadUI.getNative().setSize(m_native.getSize());
                    m_loadUI.loadXml(m_loadUI.m_xmlStr, null);
                }
                m_native.update();
                m_uiIsLoaded = true;
            }
            //m_native.invalidate();
        }
    }

    /**
     * 加载布局
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if(changed) {
            resetLayout();
        }
    }

    /**
     * 文本改变事件
     * @param s
     * @param start
     * @param before
     * @param count
     */
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String allTextInTextBox = s.toString();
        if (m_editingTextBox != null) {
            m_editingTextBox.setText(allTextInTextBox);
        }
    }

    /**
     * 触摸事件
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                onActionMove(event);
                return false;
            case MotionEvent.ACTION_DOWN:
                onActionDown(event);
                break;
            case MotionEvent.ACTION_UP:
                onActionUp(event, false);
                break;
            /*case MotionEvent.ACTION_POINTER_DOWN:
            {
                onActionDown(event);
            }*/
            //break;
            case MotionEvent.ACTION_CANCEL:
                FCView mouseDownControl = m_native.getPushedView();
                if (mouseDownControl != null) {
                    //mouseDownControl.onTouchCancel(null);
                }
                break;
        }
        return true;
    }

    /**
     * 窗体高度
     */
    private int m_WindowHeight = 0;

    ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = null;

    /**
     * 软键盘监听
     */
    public void addOnSoftKeyBoardVisibleListener() {
        if(onGlobalLayoutListener == null) {
            final View decorView = MainActivity.m_mainActivity.getWindow().getDecorView();
            onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    Rect r = new Rect();
                    //获取当前窗口实际的可见区域
                    decorView.getWindowVisibleDisplayFrame(r);
                    int height = r.height();
                    if (m_WindowHeight == 0) {
                        //一般情况下，这是原始的窗口高度
                        m_WindowHeight = height;
                    } else {
                        if (m_WindowHeight != height) {
                            //两次窗口高度相减，就是软键盘高度
                            int softKeyboardHeight = m_WindowHeight - height;
                            if(m_editingTextBox != null && m_textBox != null) {
                                if (m_textBox.getBottom() > getHeight() - softKeyboardHeight) {
                                    layout(0, -softKeyboardHeight, getWidth(), getHeight() - softKeyboardHeight);
                                }
                            }
                        }
                    }
                }
            };
            decorView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /**
     * 显示文本框
     * @param textBox 文本框
     */
    public void ShowTextBox(FCTextBox textBox) {
        try {
            addOnSoftKeyBoardVisibleListener();
            if (textBox == null) {
                return;
            }
            float scaleFactorX = 1, scaleFactorY = 1;
            if (m_native.allowScaleSize()) {
                FCSize scaleSize = m_native.getScaleSize();
                AndroidHost host = m_host;
                FCSize size = host.getClientSize();
                if (size.cx > 0 & size.cy > 0) {
                    scaleFactorX = (float) scaleSize.cx / size.cx;
                    scaleFactorY = (float) scaleSize.cy / size.cy;
                }
            }
            int subWidth = 0;
            ArrayList<FCView> subControls = textBox.getViews();
            int subControlsSize = subControls.size();
            for (int i = 0; i < subControlsSize; i++) {
                FCView control = subControls.get(i);
                if (control.isVisible()) {
                    subWidth += control.getWidth();
                }
            }
            int clientX = textBox.getNative().clientX(textBox) + textBox.getPadding().left - 1;
            FCSpin spin = (FCSpin) ((textBox instanceof FCSpin) ? textBox : null);
            if (spin != null && spin.getDownButton().isVisible()) {
                clientX += 36;
            }
            boolean inTop = false;
            int x = (int) ((clientX + 1)/ scaleFactorX);
            int clientY = textBox.getNative().clientY(textBox);
            int cx = (int) ((textBox.getWidth() - subWidth - textBox.getPadding().right - 2) / scaleFactorX);
            if(textBox.getPadding().right > 0){
                cx = (int) ((textBox.getWidth() - subWidth - textBox.getPadding().right) / scaleFactorX);
            }
            if(clientY > textBox.getNative().getSize().cy * 3 / 5){
                /*clientY = getNative().getSize().cy / 2 - 50;
                if(clientY < 30){
                    clientY = 30;
                }
                cx = (int)(textBox.getNative().getSize().cx / scaleFactorX) - 20;
                x = 10;
                inTop = true;*/
                inTop = true;
            }
            int y = (int) ((clientY + 2) / scaleFactorY);
            int cy = (int) ((textBox.getHeight() - 4) / scaleFactorY);
            boolean isNew = false;
            if (m_textBox == null) {
                m_textBox = new ClearEditText(getContext());
                m_textBox.setSingleLine();
                m_textBox.setGravity(Gravity.LEFT);
                isNew = true;
            }
            float fontSize = (float) (textBox.getFont().m_fontSize / ((scaleFactorX + scaleFactorY) / 2));
            String fontFamily = textBox.getFont().m_fontFamily;
            String newFont = "";
            if (fontFamily.equals("Default")) {
                String sysFont = MyColor.getSystemFont();
                if (sysFont.equals("System")) {
                    newFont = "Default";

                } else {
                    newFont = sysFont;
                }
            } else {
                newFont = fontFamily;
            }
            if(newFont.equals("Default")){
                m_textBox.setTypeface(Typeface.DEFAULT);
            }else{
                try {
                    Typeface tf = Typeface.createFromFile("/system/fonts/" + newFont + ".ttf");
                    if(tf != null){
                        m_textBox.setTypeface(tf);
                    }
                }catch (Exception ex){
                }
            }
            m_textBox.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize);
            AndroidPaint androidPaint = (AndroidPaint)m_paint;
            m_textBox.setBackgroundColor(androidPaint.getAndriodColor(textBox.getBackColor()));
            m_textBox.setTextColor(androidPaint.getAndriodColor(textBox.getTextColor()));
            if (m_textBox.getParent() == null) {
                addView(m_textBox);
            }
            boolean isPwd = false;
            String text = textBox.getText();
            if (isNew) {
                m_textBox.addTextChangedListener(this);
            }
            FCTextBox txt1 = (FCTextBox) ((textBox instanceof FCTextBox) ? textBox : null);

            if ((txt1 != null && txt1.getPasswordChar() != '\0')) {
                isPwd = true;
                m_textBox.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            } else {
                if (textBox instanceof FCSpin) {
                    m_textBox.setBackgroundColor(androidPaint.getAndriodColor(textBox.getBackColor()));
                    Double value = spin.getValue();
                    if (value == 0.0) {
                        text = "";
                    } else {
                        text = FCTran.doubleToStr(value);
                    }
                    m_textBox.setInputType(InputType.TYPE_CLASS_NUMBER);
                    m_textBox.setKeyListener(DigitsKeyListener.getInstance("1234567890.-"));
                } else {
                    m_textBox.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                }
            }
            RefObject<String> value = new RefObject<>(new String());
            String txt = text;
            m_textBox.setText(txt);
            //m_textBox.setTextSize(textBox.getFont().m_fontSize);
            m_textBox.setAllCaps(true);
            m_textBox.setClickable(true);
            m_textBox.setTextIsSelectable(true);
            int cornerRadis = textBox.getCornerRadius();
            m_textBox.layout(x + (int) (cornerRadis * scaleFactorX), y + (int) (cornerRadis * scaleFactorY), x + cx - (int) (cornerRadis * scaleFactorX), y + cy - (int) (cornerRadis * scaleFactorY));
            m_textBox.animate();
            m_textBox.setSelection(txt.length());
            //m_textBox.setGravity(Gravity.CENTER);
            final int oldScrolly = m_scrollY;
            if (m_scrollView != null) {
                m_scrollY = y - 200;
                m_scrollView.scrollTo(0, m_scrollY);
            }
            m_textBox.setFocusable(true);
            m_textBox.setCursorVisible(true);
            m_textBox.setFocusableInTouchMode(true);
            m_textBox.requestFocus();
            m_textBox.setPadding(0, 15, 0, 0);
            if (textBox instanceof FCSpin) {
                m_textBox.layout(x + 10, y + 5, x + cx - 10, y + cy - 5);
                m_textBox.setPadding(0, 5, 0, 0);
            }
            if (isPwd) {
                m_textBox.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            final InputMethodManager inputManager = (InputMethodManager) m_textBox.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.showSoftInput(m_textBox, 0);
            m_textBox.setOnFocusChangeListener(new OnFocusChangeListener() {
                public void onFocusChange(View view, boolean b) {
                    if (!b) {
                        inputManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        if (m_scrollView != null) {
                            m_scrollView.scrollTo(0, oldScrolly);
                        }
                    }
                }
            });
            //MainActivity.m_mainActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        } catch (Exception ex) {
        }
    }
}