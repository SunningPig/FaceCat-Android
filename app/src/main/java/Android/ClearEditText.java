package Android;

import android.animation.*;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import Product.UI.MyColor;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import topin.facecat.FaceCat.R;

/**
 * 可以清除文本的输入框
 */
public class ClearEditText extends AppCompatEditText {
    //动画时长
    private final int ANIMATOR_TIME = 200;
    //按钮左右间隔,单位DP
    private final int INTERVAL = 5;
    //清除按钮宽度,单位DP
    private final int WIDTH_OF_CLEAR = 23;
    //间隔记录
    private int Interval;
    //清除按钮宽度记录
    private int mWidth_clear;
    //右内边距
    private int mPaddingRight;
    //清除按钮出现动画
    private ValueAnimator mAnimator_visible;
    //消失动画
    private ValueAnimator mAnimator_gone;
    //是否显示的记录
    private boolean isVisible = false;

    //右边添加其他按钮时使用
    private int mRight = 0;

    /**
     * 构造函数
     * @param context 上下文
     */
    public ClearEditText(final Context context) {
        super(context);
        init(context);
    }

    /**
     * 构造函数
     * @param context 上下文
     * @param attrs 属性
     */
    public ClearEditText(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 构造函数
     * @param context 上下文
     * @param attrs 属性
     * @param defStyleAttr 样式属性
     */
    public ClearEditText(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化
     * @param context 上下文
     */
    private void init(Context context) {

        //setSingleLine();这个方法不推荐写在代码中，原因请看博客尾部更新
        Interval = dp2px(INTERVAL);
        mWidth_clear = dp2px(WIDTH_OF_CLEAR);
        mPaddingRight = Interval + mWidth_clear + Interval;
        mAnimator_gone = ValueAnimator.ofFloat(1f, 0f).setDuration(ANIMATOR_TIME);
        mAnimator_visible = ValueAnimator.ofInt(mWidth_clear + Interval, 0).setDuration(ANIMATOR_TIME);

    }

    /**
     * 适应大小
     * @param widthMeasureSpec 宽度
     * @param heightMeasureSpec 高度
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //设置内边距
        setPadding(getPaddingLeft(), getPaddingTop(), mPaddingRight + mRight, getPaddingBottom());

    }

    /**
     * 重绘方法
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));//抗锯齿
        if (mAnimator_visible.isRunning()) {
            int x = (int) mAnimator_visible.getAnimatedValue();
            drawClear(x, canvas);
            invalidate();
        } else if (isVisible) {
            drawClear(0, canvas);
        }

        if (mAnimator_gone.isRunning()) {
            float scale = (float) mAnimator_gone.getAnimatedValue();
            drawClearGone(scale, canvas);
            invalidate();
        }
    }

    /**
     * 绘制清除按钮出现的图案
     *
     * @param translationX 水平移动距离
     * @param canvas
     */
    protected void drawClear(int translationX, Canvas canvas) {
        int right = getWidth() + getScrollX() - Interval - mRight + translationX;
        int left = right - mWidth_clear;
        int top = (getHeight() - mWidth_clear) / 2;
        int bottom = top + mWidth_clear;
        RectF rect = new RectF(left, top, right, bottom);
        Paint paint = new Paint();
        if(MyColor.m_style == 1) {
            paint.setColor(Color.DKGRAY);
        }else{
            paint.setColor(Color.LTGRAY);
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(rect, paint);
        paint.setStyle(Paint.Style.STROKE);
        if(MyColor.m_style == 1) {
            paint.setColor(Color.WHITE);
        }else{
            paint.setColor(Color.BLACK);
        }
        paint.setStrokeWidth(2);
        int lx1 = (int)(rect.left + (rect.right - rect.left) / 4);
        int ly1 = (int)(rect.top + (rect.bottom - rect.top) / 4);
        int lx2 = (int)(rect.left + (rect.right - rect.left) * 3 / 4);
        int ly2 = (int)(rect.top + (rect.bottom - rect.top) * 3 / 4);
        canvas.drawLine(lx1, ly1, lx2, ly2, paint);
        ly1 = (int)(rect.top + (rect.bottom - rect.top) * 3 / 4);
        ly2 = (int)(rect.top + (rect.bottom - rect.top) / 4);
        canvas.drawLine(lx1, ly1, lx2, ly2, paint);
    }

    /**
     * 绘制清除按钮消失的图案
     *
     * @param scale  缩放比例
     * @param canvas
     */
    protected void drawClearGone(float scale, Canvas canvas) {
        int right = (int) (getWidth() + getScrollX() - Interval - mRight - mWidth_clear * (1f - scale) / 2f);
        int left = (int) (getWidth() + getScrollX() - Interval - mRight - mWidth_clear * (scale + (1f - scale) / 2f));
        int top = (int) ((getHeight() - mWidth_clear * scale) / 2);
        int bottom = (int) (top + mWidth_clear * scale);
        RectF rect = new RectF(left, top, right, bottom);
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(rect, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        int lx1 = (int)(rect.left + (rect.right - rect.left) / 4);
        int ly1 = (int)(rect.top + (rect.bottom - rect.top) / 4);
        int lx2 = (int)(rect.left + (rect.right - rect.left) * 3 / 4);
        int ly2 = (int)(rect.top + (rect.bottom - rect.top) * 3 / 4);
        canvas.drawLine(lx1, ly1, lx2, ly2, paint);
        ly1 = (int)(rect.top + (rect.bottom - rect.top) * 3 / 4);
        ly2 = (int)(rect.top + (rect.bottom - rect.top) / 4);
        canvas.drawLine(lx1, ly1, lx2, ly2, paint);
    }

    /**
     * 开始清除按钮的显示动画
     */
    private void startVisibleAnimator() {
        endAnaimator();
        mAnimator_visible.start();
        invalidate();
    }

    /**
     * 开始清除按钮的消失动画
     */
    private void startGoneAnimator() {
        endAnaimator();
        mAnimator_gone.start();
        invalidate();
    }

    /**
     * 结束所有动画
     */
    private void endAnaimator() {
        mAnimator_gone.end();
        mAnimator_visible.end();
    }

    /**
     * Edittext内容变化的监听
     */
    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);

        if (text.length() > 0) {
            if (!isVisible) {
                isVisible = true;
                startVisibleAnimator();
            }
        } else {
            if (isVisible) {
                isVisible = false;
                startGoneAnimator();
            }
        }
    }

    /**
     * 触控执行的监听
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {

            boolean touchable = (getWidth() - Interval - mRight - mWidth_clear < event.getX()) && (event.getX() < getWidth() - Interval - mRight);
            if (touchable) {
                setError(null);
                this.setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    /**
     * 给图标染上当前提示文本的颜色并且转出Bitmap
     *
     * @param resources
     * @param context
     * @return
     */
    public Bitmap createBitmap(int resources, Context context) {
        final Drawable drawable = ContextCompat.getDrawable(context, resources);
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrappedDrawable, getCurrentHintTextColor());
        return drawableToBitamp(wrappedDrawable);
    }

    /**
     * drawable转换成bitmap
     *
     * @param drawable
     * @return
     */
    private Bitmap drawableToBitamp(Drawable drawable) {
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 获取DPI
     * @param dipValue
     * @return
     */
    public int dp2px(float dipValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
