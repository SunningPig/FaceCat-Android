package Android;

import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.os.Handler;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

import Product.UI.*;
import facecat.topin.core.*;
import facecat.topin.btn.*;
import facecat.topin.grid.*;
import facecat.topin.scroll.*;
import facecat.topin.div.*;
import facecat.topin.input.*;
import facecat.topin.tab.FCTabPage;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class AndroidHost extends FCHost implements Runnable
{
    public AndroidHost()
    {

    }

    private ArrayList<Rect> m_clipBounds = new ArrayList<>();

    public Handler m_handler;

    private FCPoint m_mousePoint = new FCPoint();

    private ArrayList<Integer> m_runningTimerIDs = new ArrayList<>();

    public int m_threadState = 0;

    private HashMap<Integer, AndroidTimer> m_timers = new HashMap<>();

    private boolean m_allowOperate = false;

    public final boolean allowOperate()
    {
        return m_allowOperate;
    }

    public final void setAllowOperate(boolean value)
    {
        m_allowOperate = value;
    }

    private boolean m_allowPartialPaint = true;

    public final boolean allowPartialpaint()
    {
        return m_allowPartialPaint;
    }

    public final void setAllowPartialPaint(boolean value)
    {
        m_allowPartialPaint = value;
    }

    private FCNative m_native = null;

    public final FCNative getNative()
    {
        return m_native;
    }

    public final void setNative(FCNative value)
    {
        m_native = value;
    }

    private View m_view = null;

    public final View getView()
    {
        return m_view;
    }

    public final void setView(View value)
    {
        m_view = value;
        m_handler = new Handler(getView().getContext().getMainLooper());
        Thread t = new Thread(this);
        t.start();
    }

    private boolean m_viewVisible = true;

    public final boolean isViewVisible()
    {
        return m_viewVisible;
    }

    public final void setViewVisible(boolean value)
    {
        m_viewVisible = value;
    }

    public FCView m_control;

    public Object m_args;

    public void beginInvoke(FCView control, Object args)
    {
        synchronized (this) {
            m_control = control;
            m_args = args;
            m_handler.post(new Runnable() {
                @Override
                public void run() {
                    m_control.onInvoke(m_args);
                }
            });
        }
    }

    private ClipboardManager m_clipboard;

    public final void copy(String text) {
        if(m_clipboard == null) {
            m_clipboard = (ClipboardManager) m_view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        }
        ClipData clipData = ClipData.newPlainText(null, text);
        m_clipboard.setPrimaryClip(clipData);
    }

    public final FCView createInternalView(FCView parent, String clsid)
    {
        FCSplitLayoutDiv splitLayoutDiv = (FCSplitLayoutDiv) ((parent instanceof FCSplitLayoutDiv) ? parent : null);
        if (splitLayoutDiv != null)
        {
            if (clsid.equals("splitter"))
            {
                FCButton splitter = new FCButton();
                splitter.setBackColor(MyColor.USERCOLOR6);
                splitter.setBorderColor(MyColor.USERCOLOR14);
                splitter.setSize(new FCSize(5, 5));
                return splitter;
            }
        }
        FCScrollBar scrollBar = (FCScrollBar) ((parent instanceof FCScrollBar) ? parent : null);
        if (scrollBar != null)
        {
            scrollBar.setBackColor(FCColor.None);
            scrollBar.setBorderColor(FCColor.None);
            scrollBar.setSize(new FCSize(8, 8));
            if (clsid.equals("addbutton"))
            {
                RibbonButton addButton = new RibbonButton();
                addButton.setSize(new FCSize(8, 8));
                if ((FCHScrollBar) ((scrollBar instanceof FCHScrollBar) ? scrollBar : null) != null)
                {
                    addButton.setWidth(0);
                    addButton.setArrowType(2);
                } else
                {
                    addButton.setHeight(0);
                    addButton.setArrowType(4);
                }
                return addButton;
            } else if (clsid.equals("backbutton"))
            {
                FCButton button = new FCButton();
                button.setBackColor(FCColor.None);
                button.setBorderColor(FCColor.None);
                return button;
            } else if (clsid.equals("scrollbutton"))
            {
                ScrollButtonM scrollButton = new ScrollButtonM();
                scrollButton.setAllowDrag(true);
                scrollButton.setBackColor(MyColor.USERCOLOR74);
                scrollButton.setBorderColor(FCColor.None);
                scrollButton.setCornerRadius(10);
                return scrollButton;
            } else if (clsid.equals("reducebutton"))
            {
                RibbonButton reduceButton = new RibbonButton();
                reduceButton.setSize(new FCSize(8, 8));
                if ((FCHScrollBar) ((scrollBar instanceof FCHScrollBar) ? scrollBar : null) != null)
                {
                    reduceButton.setWidth(0);
                    reduceButton.setArrowType(1);
                } else
                {
                    reduceButton.setHeight(0);
                    reduceButton.setArrowType(3);
                }
                return reduceButton;
            }
        }
        FCTabPage tabPage = (FCTabPage) ((parent instanceof FCTabPage) ? parent : null);
        if (tabPage != null)
        {
            if (clsid.equals("headerbutton"))
            {
                RibbonButton button = new RibbonButton();
                button.setAllowDrag(true);
                FCSize size = new FCSize(100, 30);
                button.setSize(size);
                return button;
            }
        }
        FCComboBox comboBox = (FCComboBox) ((parent instanceof FCComboBox) ? parent : null);
        if (comboBox != null)
        {
            if (clsid.equals("dropdownbutton"))
            {
                ArrowButtonM dropDownButton = new ArrowButtonM();
                dropDownButton.setArrowType(4);
                dropDownButton.setDisplayOffset(false);
                int width = comboBox.getWidth();
                int height = comboBox.getHeight();
                FCSize size = new FCSize(25, height);
                dropDownButton.setSize(size);
                FCPoint location = new FCPoint(width - 25, 0);
                dropDownButton.setLocation(location);
                return dropDownButton;
            } else if (clsid.equals("dropdownmenu"))
            {
                FCComboBoxMenu comboBoxMenu = new FCComboBoxMenu();
                comboBoxMenu.setComboBox(comboBox);
                comboBoxMenu.setPopup(true);
                FCSize size = new FCSize(100, 200);
                comboBoxMenu.setSize(size);
                return comboBoxMenu;
            }
        }
        FCSpin spin = (FCSpin) ((parent instanceof FCSpin) ? parent : null);
        if (spin != null)
        {
            if (clsid.equals("downbutton"))
            {
                FCButton downButton = new FCButton();
                downButton.setDisplayOffset(false);
                FCSize size = new FCSize(16, 16);
                downButton.setSize(size);
                return downButton;
            } else if (clsid.equals("upbutton"))
            {
                FCButton upButton = new FCButton();
                upButton.setDisplayOffset(false);
                FCSize size = new FCSize(16, 16);
                upButton.setSize(size);
                return upButton;
            }
        }
        FCDiv div = (FCDiv) ((parent instanceof FCDiv) ? parent : null);
        if (div != null)
        {
            if (clsid.equals("hscrollbar"))
            {
                FCHScrollBar hScrollBar = new FCHScrollBar();
                hScrollBar.setVisible(false);
                FCSize size = new FCSize(4, 4);
                hScrollBar.setSize(size);
                return hScrollBar;
            } else if (clsid.equals("vscrollbar"))
            {
                FCVScrollBar vScrollBar = new FCVScrollBar();
                vScrollBar.setVisible(false);
                FCSize size = new FCSize(4, 4);
                vScrollBar.setSize(size);
                return vScrollBar;
            }
        }
        FCGrid grid = (FCGrid) ((parent instanceof FCGrid) ? parent : null);
        if (grid != null)
        {
            if (clsid.equals("edittextbox"))
            {
                return new FCTextBox();
            }
        }
        return null;
    }

    public FCView findPreviewsControl(FCView control)
    {
        if (control.allowPreviewsEvent())
        {
            return control;
        } else
        {
            FCView parent = control.getParent();
            if (parent != null)
            {
                return findPreviewsControl(parent);
            } else
            {
                return null;
            }
        }
    }

    public static int dp2px(Context context, float dpValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5f);
    }

    public FCSize getClientSize()
    {
        FCSize size = new FCSize();
        if (m_view != null)
        {
            size = new FCSize(m_view.getWidth(), m_view.getHeight());
        }
        return size;
    }

    public final FCPoint getTouchPoint()
    {
        FCPoint mp = m_mousePoint.clone();
        if (m_native.allowScaleSize())
        {
            FCSize clientSize = getClientSize();
            if (clientSize.cx > 0 && clientSize.cy > 0)
            {
                FCSize scaleSize = m_native.getScaleSize();
                mp.x = mp.x * scaleSize.cx / clientSize.cx;
                mp.y = mp.y * scaleSize.cy / clientSize.cy;
            }
        }
        return mp;
    }

    public final int getIntersectRect(RefObject<FCRect> lpDestRect, RefObject<FCRect> lpSrc1Rect, RefObject<FCRect> lpSrc2Rect)
    {
        lpDestRect.argvalue.left = Math.max(lpSrc1Rect.argvalue.left, lpSrc2Rect.argvalue.left);
        lpDestRect.argvalue.right = Math.min(lpSrc1Rect.argvalue.right, lpSrc2Rect.argvalue.right);
        lpDestRect.argvalue.top = Math.max(lpSrc1Rect.argvalue.top, lpSrc2Rect.argvalue.top);
        lpDestRect.argvalue.bottom = Math.min(lpSrc1Rect.argvalue.bottom, lpSrc2Rect.argvalue.bottom);
        if (lpDestRect.argvalue.right > lpDestRect.argvalue.left && lpDestRect.argvalue.bottom > lpDestRect.argvalue.top)
        {
            return 1;
        } else
        {
            lpDestRect.argvalue.left = 0;
            lpDestRect.argvalue.right = 0;
            lpDestRect.argvalue.top = 0;
            lpDestRect.argvalue.bottom = 0;
            return 0;
        }
    }

    public double getScaleRate()
    {
        if (m_view != null)
        {
            WindowManager wm = (WindowManager) m_view.getContext()
                    .getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics outMetrics = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(outMetrics);
            int width = outMetrics.widthPixels;
            int height = outMetrics.heightPixels;
            double rate = (double) Math.min(width, height) / 430;
            return rate;
        } else
        {
            return 1;
        }
    }

    public final int getTouches(MotionEvent event, FCTouchInfo touchInfo)
    {
        int pointerCount = event.getPointerCount();
        for (int i = 0; i < pointerCount; i++)
        {
            FCPoint mp = new FCPoint(event.getX(i),
                    event.getY(i));
            if (m_native.allowScaleSize())
            {
                FCSize clientSize = getClientSize();
                if (clientSize.cx > 0 && clientSize.cy > 0)
                {
                    FCSize scaleSize = m_native.getScaleSize();
                    mp.x = mp.x * scaleSize.cx / clientSize.cx;
                    mp.y = mp.y * scaleSize.cy / clientSize.cy;
                }
            }
            if(i == 0)
            {
                touchInfo.m_firstPoint = mp;
                touchInfo.m_firstTouch = true;
            }else if(i == 1){
                touchInfo.m_secondPoint = mp;
                touchInfo.m_secondTouch = true;
            }
        }
        //ouchInfo.m_clicks = event.getPointerCount();
        return 1;
    }

    public final FCSize getSize()
    {
        if (m_native.allowScaleSize())
        {
            return m_native.getScaleSize();
        } else
        {
            return getClientSize();
        }
    }

    public final int getUnionRect(RefObject<FCRect> lpDestRect, RefObject<FCRect> lpSrc1Rect, RefObject<FCRect> lpSrc2Rect)
    {
        return 0;
    }

    public final int invokeThread(Object lpParam)
    {
        if (lpParam instanceof AndroidHost)
        {
            AndroidHost androidHost = (AndroidHost) lpParam;
            m_threadState = 1;
            while (m_threadState == 1)
            {
                onTimer();
                try
                {
                    Thread.sleep(10);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            m_threadState = 3;
        }
        return 0;
    }

    public boolean isKeyPress(char ch){
        return false;
    }

    public final void invalidate(FCRect rect)
    {
        if (m_allowPartialPaint)
        {
            FCSize displaySize = m_native.getSize();
            m_clipBounds.add(new Rect(rect.left >= 0 ? rect.left : 0, rect.top >= 0 ? rect.top : 0, rect.right <= displaySize.cx ? rect
                    .right : displaySize.cx, rect.bottom <= displaySize.cy ? rect.bottom : displaySize.cy));
            m_view.postInvalidate();
        } else
        {
            invalidate();
        }
    }

    public final void invalidate()
    {
        m_clipBounds.clear();
        m_clipBounds.add(new Rect(0, 0, m_native.getSize().cx, m_native.getSize().cy));
        m_view.invalidate();
    }

    public final void invoke(FCView control, Object args)
    {
        synchronized (this) {
            m_control = control;
            m_args = args;
            m_handler.post(new Runnable() {
                @Override
                public void run() {
                    m_control.onInvoke(m_args);
                }
            });
        }
    }

    public final void onPaint(Canvas canvas)
    {
        try {
            if (canvas == null) {
                return;
            }
            int width = canvas.getWidth(), height = canvas.getHeight();
            FCSize displaySize = m_native.getSize();
            int clipBoundsSize = m_clipBounds.size();
            FCRect clipRect = new FCRect();
            if (clipBoundsSize > 0) {
                for (int i = 0; i < clipBoundsSize; i++) {
                    Rect clipBounds = m_clipBounds.get(i);
                    if (i == 0) {
                        clipRect = new FCRect(clipBounds.left, clipBounds.top, clipBounds.right, clipBounds.bottom);
                    } else {
                        if (clipRect.left > clipBounds.left) {
                            clipRect.left = clipBounds.left;
                        }
                        if (clipRect.right < clipBounds.right) {
                            clipRect.right = clipBounds.right;
                        }
                        if (clipRect.top > clipBounds.top) {
                            clipRect.top = clipBounds.top;
                        }
                        if (clipRect.bottom < clipBounds.bottom) {
                            clipRect.bottom = clipBounds.bottom;
                        }
                    }
                }
            } else {
                clipRect = new FCRect(0, 0, displaySize.cx, displaySize.cy);
            }
            m_clipBounds.clear();
            double scaleFactorX = 1, scaleFactorY = 1;
            FCSize clientSize = getClientSize();
            if (m_native.allowScaleSize()) {
                if (clientSize.cx > 0 && clientSize.cy > 0) {
                    FCSize scaleSize = m_native.getScaleSize();
                    scaleFactorX = (double) (clientSize.cx) / scaleSize.cx;
                    scaleFactorY = (double) (clientSize.cy) / scaleSize.cy;
                }
            }
            FCPaint paint = m_native.getPaint();
            FCRect wRect = new FCRect(0, 0, clientSize.cx, clientSize.cy);
            paint.setScaleFactor(scaleFactorX, scaleFactorY);
            AndroidPaint androidPaint = (AndroidPaint) ((paint instanceof AndroidPaint) ? paint : null);
            androidPaint.setCanvas(canvas);
            paint.beginPaint(0, wRect, new FCRect(clipRect.left, clipRect.top, clipRect.right, clipRect.bottom));
            m_native.onPaint(clipRect);
            paint.endPaint();
        }catch (Exception ex){

        }
        //this.invalidate();
    }

    public final void onTimer()
    {
        if (m_viewVisible)
        {
            synchronized (m_timers)
            {
                try {
                    for (AndroidTimer timer : m_timers.values()) {
                        if (timer.m_tick % timer.m_interval == 0) {
                            m_runningTimerIDs.add(timer.m_timerID);
                        }
                        timer.m_tick++;
                    }
                }catch (Exception ex){

                }
            }
            if(m_runningTimerIDs.size() > 0) {
                m_handler.post(new Runnable() {
                    public void run() {
                        synchronized (m_timers) {
                            try {
                                int runningTimerIDsSize = m_runningTimerIDs.size();
                                for (int i = 0; i < runningTimerIDsSize; i++) {
                                    m_native.onTimer(m_runningTimerIDs.get(i));
                                }
                                m_runningTimerIDs.clear();
                            } catch (Exception ex) {

                            }
                        }
                    }
                });
            }
        }
    }

    public final String paste() {
        if(m_clipboard == null) {
            m_clipboard = (ClipboardManager) m_view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        }
        ClipData clipData = m_clipboard.getPrimaryClip();
        if (clipData != null && clipData.getItemCount() > 0) {
            CharSequence text = clipData.getItemAt(0).getText();
            return text.toString();
        }
        return "";
    }

    public void run()
    {
        invokeThread(this);
    }

    public final void setTouchPoint(FCPoint mp)
    {
        m_mousePoint = mp.clone();
    }

    public void showToolTip(String var1, FCPoint var2)
    {

    }

    public final void startTimer(int timerID, int interval)
    {
        interval = interval / 10;
        if(interval < 1){
            interval = 1;
        }
        synchronized (m_timers)
        {
            if (m_timers.containsKey(timerID))
            {
                AndroidTimer timer = m_timers.get(timerID);
                timer.m_interval = interval;
                timer.m_tick = 0;
            } else
            {
                AndroidTimer timer = new AndroidTimer();
                timer.m_interval = interval;
                timer.m_timerID = timerID;
                m_timers.put(timerID, timer);
            }
        }
    }

    public final void stopTimer(int timerID)
    {
        synchronized (m_timers)
        {
            if (m_timers.containsKey(timerID))
            {
                m_timers.remove(timerID);
            }
        }
    }

    public void delete(){
        
    }

    public FCCursors getCursor(){
        return FCCursors.Arrow;
    }

    public void setCursor(FCCursors var1){

    }
}