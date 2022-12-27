/*
 * FaceCat图形通讯框架
 * 上海卷卷猫信息技术有限公司
 */

package Android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Paint.*;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Region.*;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;

import java.util.HashMap;

import Product.UI.*;
import facecat.topin.core.*;
import topin.facecat.FaceCat.MainActivity;

public class AndroidPaint extends FCPaint
{
    private Canvas m_canvas;

    private Bitmap m_cacheImage;

    private boolean m_doubleBufferd = true;

    public HashMap<String, Bitmap> m_images = new HashMap<String, Bitmap>();

    private boolean m_isClip;

    private boolean m_isPathStart;

    public MyColor m_myColor = new MyColor();

    protected int m_offsetX;

    protected int m_offsetY;

    protected float m_opacity = 1;

    public Paint m_paint;

    protected Path m_path;

    protected FCRect m_pRect;

    protected String m_resourcePath;

    protected int m_rotateAngle;

    protected double m_scaleFactorX = 1;

    protected double m_scaleFactorY = 1;

    public Canvas m_viewCanvas;

    protected FCRect m_wRect;


    public void addArc(FCRect rect, float startAngle, float sweepAngle)
    {
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        m_path.addArc(andriodRect, startAngle, sweepAngle);
        m_isPathStart = false;
    }


    public void addBezier(FCPoint[] points)
    {
        int pointsLength = points.length;
        if (pointsLength < 3)
        {
            return;
        }
        if (m_isPathStart)
        {
            m_path.moveTo(points[0].x + m_offsetX, points[0].y + m_offsetY);
            m_isPathStart = false;
        }
        for (int i = 1; i < pointsLength - 1; i = i + 2)
        {
            m_path.quadTo(points[i].x + m_offsetX, points[i].y + m_offsetY,
                    points[i + 1].x + m_offsetX, points[i + 1].y + m_offsetY);
        }
        m_isPathStart = false;
    }


    public void addCurve(FCPoint[] points)
    {
        //
    }

    public void addEllipse(FCRect rect)
    {
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        m_path.addOval(andriodRect, Path.Direction.CW);
        m_isPathStart = false;
    }

    public void addLine(int x1, int y1, int x2, int y2)
    {
        float lx1 = x1 + m_offsetX;
        float ly1 = y1 + m_offsetY;
        float lx2 = x2 + m_offsetX;
        float ly2 = y2 + m_offsetY;
        if (m_scaleFactorX != 1 || m_scaleFactorY != 1)
        {
            lx1 = (float) (m_scaleFactorX * lx1);
            ly1 = (float) (m_scaleFactorY * ly1);
            lx2 = (float) (m_scaleFactorX * lx2);
            ly2 = (float) (m_scaleFactorY * ly2);
        }
        if (m_isPathStart)
        {
            m_path.moveTo(lx1, ly1);
            m_isPathStart = false;
        }
        m_path.lineTo(lx2, ly2);
    }

    public void addPie(FCRect rect, float startAngle, float sweepAngle)
    {
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        m_path.addArc(andriodRect, startAngle, sweepAngle);
        m_isPathStart = false;
    }

    public void addRect(FCRect rect)
    {
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        m_path.addRect(andriodRect, Path.Direction.CW);
        m_isPathStart = false;
    }

    public void addSourceImage(String key, Bitmap image)
    {
        m_images.put(key, image);
    }

    public void addText(String text, FCFont font, FCRect rect, int width)
    {

    }

    protected void affectScaleFactor(RefObject<RectF> andriodRect)
    {
        if (m_scaleFactorX != -1 || m_scaleFactorY != -1)
        {
            andriodRect.argvalue.set((int) (andriodRect.argvalue.left * m_scaleFactorX),
                    (int) (andriodRect.argvalue.top * m_scaleFactorY),
                    (int) (andriodRect.argvalue.right * m_scaleFactorX),
                    (int) (andriodRect.argvalue.bottom * m_scaleFactorY));
        }
    }

    public void beginPaint(int hDC, FCRect wRect, FCRect pRect)
    {
        int width = wRect.right - wRect.left;
        int height = wRect.bottom - wRect.top;
        m_wRect = wRect.clone();
        m_pRect = pRect.clone();
        m_paint = new Paint();
        if (m_doubleBufferd)
        {
            if (m_cacheImage == null || m_cacheImage.getWidth() != width || m_cacheImage.getHeight() != height)
            {
                if (width > height)
                {
                    height *= 2;
                }
                if (m_cacheImage != null)
                {
                    m_cacheImage.recycle();
                }
                m_cacheImage = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            }
            Paint cachePaint = new Paint();
            cachePaint.setAntiAlias(true);
            m_viewCanvas.drawBitmap(m_cacheImage, 0, 0, cachePaint);
            m_canvas = new Canvas(m_cacheImage);
            m_viewCanvas.save();
        } else
        {
            m_canvas = m_viewCanvas;
        }
        m_canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));
        m_isClip = false;
        m_opacity = 1;
        m_resourcePath = null;
    }

    public void beginPath()
    {
        m_path = new Path();
        m_isPathStart = true;
    }

    public void clearCaches()
    {
        HashMap<String, Bitmap> hashMap = new HashMap<String, Bitmap>();
        for (String key : hashMap.keySet())
        {
            Bitmap value = hashMap.get(key);
            value.recycle();
        }
        m_images.clear();
    }

    public void clipPath()
    {
        m_canvas.clipPath(m_path);
    }

    public void closeFigure()
    {
        m_path.close();
    }

    public void closePath()
    {
        m_path.reset();
        m_path = null;
        m_isPathStart = false;
    }

    public void delete()
    {
        clearCaches();
        if (m_cacheImage != null)
        {
            m_cacheImage.recycle();
            m_cacheImage = null;
        }
    }

    public void drawArc(long dwPenColor, float width, int style, FCRect rect, float startAngle, float sweepAngle)
    {
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        setDrawPaint(dwPenColor, width, style);
        m_paint.setAntiAlias(true);
        m_canvas.drawArc(andriodRect, startAngle, sweepAngle, false, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void drawBezier(long dwPenColor, float width, int style, FCPoint[] points)
    {
        if (dwPenColor == FCColor.None) return;
        Path path = new Path();
        int cpt = points.length;
        if (cpt < 3)
        {
            return;
        }
        path.moveTo(points[0].x + m_offsetX, points[0].y + m_offsetY);
        for (int i = 1; i < points.length - 1; i = i + 2)
        {
            path.quadTo(points[i].x + m_offsetX, points[i].y + m_offsetY,
                    points[i + 1].x + m_offsetX, points[i + 1].y + m_offsetY);
        }
        setDrawPaint(dwPenColor, width, style);
        m_paint.setAntiAlias(true);
        m_canvas.drawPath(path, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void drawCurve(long dwPenColor, float width, int style, FCPoint[] points)
    {

    }

    public void drawEllipse(long dwPenColor, float width, int style, FCRect rect)
    {
        if (dwPenColor == FCColor.None) return;
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        setDrawPaint(dwPenColor, width, style);
        m_paint.setAntiAlias(true);
        m_canvas.drawOval(andriodRect, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void drawEllipse(long dwPenColor, float width, int style, int left, int top, int right, int bottom)
    {
        FCRect rect = new FCRect(left, top, right, bottom);
        drawEllipse(dwPenColor, width, style, rect);
    }

    public static int m_angle = 0;

    public void drawImage(String imagePath, FCRect rect)
    {
        String imageKey = imagePath;
        Bitmap drawImage = null;
        int rw = rect.right - rect.left;
        if (rw < 1) rw = 1;
        int rh = rect.bottom - rect.top;
        if (rh < 1) rh = 1;
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        if (m_images.containsKey(imageKey))
        {
            drawImage = m_images.get(imageKey);
        }else{
            if(FCFile.isFileExist(imageKey.replace(".png", "").replace(".jpg", "").replace(".jpeg", ""))){
                drawImage = BitmapFactory.decodeFile(imageKey.replace(".png", "").replace(".jpg", "").replace(".jpeg", ""));
                if(drawImage != null) {
                    addSourceImage(imageKey, drawImage);
                }
            }
        }
        if (drawImage != null)
        {
            RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
            affectScaleFactor(refAndriodRect);
            andriodRect = refAndriodRect.argvalue;
            m_paint.setAntiAlias(true);
            setFillPaint(FCColor.rgb(255, 255, 255));
            m_canvas.drawBitmap(drawImage, new Rect(0, 0, drawImage.getWidth(), drawImage.getHeight()), andriodRect, m_paint);
            m_paint.setAntiAlias(false);
        }
    }

    public void drawLine(long dwPenColor, float width, int style, int x1, int y1, int x2, int y2)
    {
        if (dwPenColor == FCColor.None) return;
        float lx1 = x1 + m_offsetX;
        float ly1 = y1 + m_offsetY;
        float lx2 = x2 + m_offsetX;
        float ly2 = y2 + m_offsetY;
        if (m_scaleFactorX != 1 || m_scaleFactorY != 1)
        {
            lx1 = (float) (m_scaleFactorX * lx1);
            ly1 = (float) (m_scaleFactorY * ly1);
            lx2 = (float) (m_scaleFactorX * lx2);
            ly2 = (float) (m_scaleFactorY * ly2);
        }
        setDrawPaint(dwPenColor, width, style);
        m_paint.setAntiAlias(true);
        m_canvas.drawLine(lx1, ly1, lx2, ly2, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void drawLine(long dwPenColor, float width, int style, FCPoint x, FCPoint y)
    {
        drawLine(dwPenColor, width, style, x.x, x.y, y.x, y.y);
    }

    public void drawPath(long dwPenColor, float width, int style)
    {
        if (dwPenColor == FCColor.None) return;
        setDrawPaint(dwPenColor, width, style);
        m_paint.setAntiAlias(true);
        m_canvas.drawPath(m_path, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void drawPie(long dwPenColor, float width, int style, FCRect rect, float startAngle, float sweepAngle)
    {
        if (dwPenColor == FCColor.None) return;
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        setDrawPaint(dwPenColor, width, style);
        m_paint.setAntiAlias(true);
        m_canvas.drawArc(andriodRect, startAngle, sweepAngle, true, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void drawPolygon(long dwPenColor, float width, int style, FCPoint[] points)
    {
        if (dwPenColor == FCColor.None) return;
        Path path = new Path();
        int fx = 0, fy = 0;
        int cpt = points.length;
        for (int i = 0; i < cpt; i++)
        {
            int x = points[i].x + m_offsetX;
            int y = points[i].y + m_offsetY;
            if (m_scaleFactorX != 1 || m_scaleFactorY != 1)
            {
                x = (int) (m_scaleFactorX * x);
                y = (int) (m_scaleFactorY * y);
            }
            if (i == 0)
            {
                fx = x;
                fy = y;
                path.moveTo(x, y);
            } else
            {
                path.lineTo(x, y);
            }
        }
        path.close();
        setDrawPaint(dwPenColor, width, style);
        m_paint.setAntiAlias(true);
        m_canvas.drawPath(path, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void drawPolyline(long dwPenColor, float width, int style, FCPoint[] points)
    {
        if (dwPenColor == FCColor.None) return;
        Path path = new Path();
        int fx = 0, fy = 0;
        int cpt = points.length;
        for (int i = 0; i < cpt; i++)
        {
            int x = points[i].x + m_offsetX;
            int y = points[i].y + m_offsetY;
            if (m_scaleFactorX != 1 || m_scaleFactorY != 1)
            {
                x = (int) (m_scaleFactorX * x);
                y = (int) (m_scaleFactorY * y);
            }
            if (i == 0)
            {
                fx = x;
                fy = y;
                path.moveTo(x, y);
            } else
            {
                path.lineTo(x, y);
            }
        }
        setDrawPaint(dwPenColor, width, style);
        m_paint.setAntiAlias(true);
        m_canvas.drawPath(path, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void drawRect(long dwPenColor, float width, int style, FCRect rect)
    {
        drawRect(dwPenColor, width, style, rect.left, rect.top, rect.right, rect.bottom);
    }

    public void drawRect(long dwPenColor, float width, int style, int left, int top, int right, int bottom)
    {
        if (dwPenColor == FCColor.None) return;
        RectF andriodRect = new RectF(left + m_offsetX, top + m_offsetY, right + m_offsetX, bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        setDrawPaint(dwPenColor, width, style);
        m_paint.setAntiAlias(false);
        m_canvas.drawRect(andriodRect, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void drawRoundRect(long dwPenColor, float width, int style, FCRect rect, int cornerRadius)
    {
        if (cornerRadius == 0)
        {
            drawRect(dwPenColor, width, style, rect);
        } else
        {
            if (dwPenColor == FCColor.None) return;
            RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
            RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
            affectScaleFactor(refAndriodRect);
            Path path = new Path();
            path.addRoundRect(andriodRect, cornerRadius, cornerRadius, Path.Direction.CW);
            path.close();
            setDrawPaint(dwPenColor, width, style);
            m_paint.setAntiAlias(true);
            m_canvas.drawPath(path, m_paint);
            m_paint.setAntiAlias(false);
        }
    }

    public void drawText(String text, long dwPenColor, FCFont font, FCRect rect, int width)
    {
        if (dwPenColor == FCColor.None || text == null) return;
        if (m_scaleFactorX != 1 || m_scaleFactorY != 1)
        {
            RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
            RefObject<RectF> refAndriodRect = new RefObject<>(andriodRect);
            affectScaleFactor(refAndriodRect);
            float fontSize = (float) (font.m_fontSize * (m_scaleFactorX + m_scaleFactorY) / 2);
            String fontFamily = font.m_fontFamily;
            String newFont = "";
            if (fontFamily.equals("Default")) {
                String sysFont = MyColor.getSystemFont();
                if (sysFont.equals("System")) {
                    newFont = "Default";

                } else {
                    newFont = sysFont;
                }
            } else {
                newFont = font.m_fontFamily;
            }
            if(!newFont.equals(m_lastFont)){
                if(newFont.equals("Default")){
                    m_paint.setTypeface(Typeface.DEFAULT);
                }else{
                    try {
                        if(m_typeFaces.containsKey(newFont)){
                            Typeface tf = m_typeFaces.get(newFont);
                            if(tf != m_paint.getTypeface()) {
                                m_paint.setTypeface(m_typeFaces.get(newFont));
                            }
                        }else{
                            Typeface tf = Typeface.createFromFile("/system/fonts/" + newFont + ".ttf");
                            if(tf != null){
                                m_paint.setTypeface(tf);
                                m_typeFaces.put(newFont, tf);
                            }
                        }
                    }catch (Exception ex){

                    }
                }
                m_lastFont = newFont;
            }
            m_paint.setTextSize(fontSize);
            m_paint.setFakeBoldText(font.m_bold);
            m_paint.setTextSkewX(font.m_italic ? -0.5f : 0);
            m_paint.setUnderlineText(font.m_underline);
            FontMetrics fm = m_paint.getFontMetrics();
            setFillPaint(dwPenColor);
            m_paint.setAntiAlias(true);
            float baseLineY = (andriodRect.bottom + andriodRect.top - fm.bottom - fm.top) / 2;
            if(font.m_angle != 0){
                m_canvas.save();
                m_canvas.translate(andriodRect.left + andriodRect.right - andriodRect.left, andriodRect.top + (andriodRect.bottom - andriodRect.top) / 2);
                m_canvas.rotate(font.m_angle);
                m_canvas.drawText(text, -(andriodRect.right - andriodRect.left) / 2, -(andriodRect.bottom - andriodRect.top) / 2, m_paint);
                m_canvas.restore();
            }else {
                m_canvas.drawText(text, andriodRect.left, baseLineY, m_paint);
            }
            m_paint.setAntiAlias(false);
        } else
        {
            String fontFamily = font.m_fontFamily;
            String newFont = "";
            if (fontFamily.equals("Default")) {
                String sysFont = MyColor.getSystemFont();
                if (sysFont.equals("System")) {
                    newFont = "Default";

                } else {
                    newFont = sysFont;
                }
            } else {
                newFont = font.m_fontFamily;
            }
            if(!newFont.equals(m_lastFont)){
                if(newFont.equals("Default")){
                    m_paint.setTypeface(Typeface.DEFAULT);
                }else{
                    try {
                        if(m_typeFaces.containsKey(newFont)){
                            Typeface tf = m_typeFaces.get(newFont);
                            if(tf != m_paint.getTypeface()) {
                                m_paint.setTypeface(m_typeFaces.get(newFont));
                            }
                        }else{
                            Typeface tf = Typeface.createFromFile("/system/fonts/" + newFont + ".ttf");
                            if(tf != null){
                                m_paint.setTypeface(tf);
                                m_typeFaces.put(newFont, tf);
                            }
                        }
                    }catch (Exception ex){

                    }
                }
                m_lastFont = newFont;
            }
            m_paint.setTextSize(font.m_fontSize);
            m_paint.setFakeBoldText(font.m_bold);
            m_paint.setTextSkewX(font.m_italic ? -0.5f : 0);
            m_paint.setUnderlineText(font.m_underline);
            RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
            FontMetrics fm = m_paint.getFontMetrics();
            setFillPaint(dwPenColor);
            m_paint.setAntiAlias(true);
//            m_canvas.drawText(text, andriodRect.left, andriodRect.top  + (fm.descent - fm.ascent), m_paint);
            float baseLineY = (andriodRect.bottom + andriodRect.top - fm.bottom - fm.top) / 2;
            if(font.m_angle != 0){
                m_canvas.save();
                m_canvas.translate(andriodRect.left + andriodRect.right - andriodRect.left, andriodRect.top + (andriodRect.bottom - andriodRect.top) / 2);
                m_canvas.rotate(font.m_angle);
                m_canvas.drawText(text, -(andriodRect.right - andriodRect.left) / 2, -(andriodRect.bottom - andriodRect.top) / 2, m_paint);
                m_canvas.restore();
            }else {
                m_canvas.drawText(text, andriodRect.left, baseLineY, m_paint);
            }
            m_paint.setAntiAlias(false);
        }
    }


    public void drawText(String text, long dwPenColor, FCFont font, FCRectF rect, int width)
    {
        if (dwPenColor == FCColor.None || text == null) return;
        if (m_scaleFactorX != 1 || m_scaleFactorY != 1)
        {
            RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
            RefObject<RectF> refAndriodRect = new RefObject<>(andriodRect);
            affectScaleFactor(refAndriodRect);
            float fontSize = (float) (font.m_fontSize * (m_scaleFactorX + m_scaleFactorY) / 2);
            String fontFamily = font.m_fontFamily;
            String newFont = "";
            if (fontFamily.equals("Default")) {
                String sysFont = MyColor.getSystemFont();
                if (sysFont.equals("System")) {
                    newFont = "Default";

                } else {
                    newFont = sysFont;
                }
            } else {
                newFont = font.m_fontFamily;
            }
            if(!newFont.equals(m_lastFont)){
                if(newFont.equals("Default")){
                    m_paint.setTypeface(Typeface.DEFAULT);
                }else{
                    try {
                        if(m_typeFaces.containsKey(newFont)){
                            Typeface tf = m_typeFaces.get(newFont);
                            if(tf != m_paint.getTypeface()) {
                                m_paint.setTypeface(m_typeFaces.get(newFont));
                            }
                        }else{
                            Typeface tf = Typeface.createFromFile("/system/fonts/" + newFont + ".ttf");
                            if(tf != null){
                                m_paint.setTypeface(tf);
                                m_typeFaces.put(newFont, tf);
                            }
                        }
                    }catch (Exception ex){

                    }
                }
                m_lastFont = newFont;
            }
            m_paint.setTextSize(fontSize);
            m_paint.setFakeBoldText(font.m_bold);
            m_paint.setTextSkewX(font.m_italic ? -0.5f : 0);
            m_paint.setUnderlineText(font.m_underline);
            FontMetrics fm = m_paint.getFontMetrics();
            setFillPaint(dwPenColor);
            m_paint.setAntiAlias(true);
            float baseLineY = (andriodRect.bottom + andriodRect.top - fm.bottom - fm.top) / 2;
            if(font.m_angle != 0){
                m_canvas.save();
                m_canvas.translate(andriodRect.left + (andriodRect.right - andriodRect.left) / 2, andriodRect.top + (andriodRect.bottom - andriodRect.top) / 2);
                m_canvas.rotate(font.m_angle);
                m_canvas.drawText(text, -(andriodRect.right - andriodRect.left) / 2, -(andriodRect.bottom - andriodRect.top) / 2, m_paint);
                m_canvas.restore();
            }else {
                m_canvas.drawText(text, andriodRect.left, baseLineY, m_paint);
            }
            m_paint.setAntiAlias(false);
        } else
        {
            String fontFamily = font.m_fontFamily;
            String newFont = "";
            if (fontFamily.equals("Default")) {
                String sysFont = MyColor.getSystemFont();
                if (sysFont.equals("System")) {
                    newFont = "Default";

                } else {
                    newFont = sysFont;
                }
            } else {
                newFont = font.m_fontFamily;
            }
            if(!newFont.equals(m_lastFont)){
                if(newFont.equals("Default")){
                    m_paint.setTypeface(Typeface.DEFAULT);
                }else{
                    try {
                        if(m_typeFaces.containsKey(newFont)){
                            Typeface tf = m_typeFaces.get(newFont);
                            if(tf != m_paint.getTypeface()) {
                                m_paint.setTypeface(m_typeFaces.get(newFont));
                            }
                        }else{
                            Typeface tf = Typeface.createFromFile("/system/fonts/" + newFont + ".ttf");
                            if(tf != null){
                                m_paint.setTypeface(tf);
                                m_typeFaces.put(newFont, tf);
                            }
                        }
                    }catch (Exception ex){

                    }
                }
                m_lastFont = newFont;
            }
            m_paint.setTextSize(font.m_fontSize);
            m_paint.setFakeBoldText(font.m_bold);
            m_paint.setTextSkewX(font.m_italic ? -0.5f : 0);
            m_paint.setUnderlineText(font.m_underline);
            RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
            FontMetrics fm = m_paint.getFontMetrics();
            setFillPaint(dwPenColor);
            m_paint.setAntiAlias(true);
//            m_canvas.drawText(text, andriodRect.left, andriodRect.top  + (fm.descent - fm.ascent), m_paint);
            float baseLineY = (andriodRect.bottom + andriodRect.top - fm.bottom - fm.top) / 2;
            if(font.m_angle != 0){
                m_canvas.save();
                m_canvas.translate(andriodRect.left + (andriodRect.right - andriodRect.left) / 2, andriodRect.top + (andriodRect.bottom - andriodRect.top) / 2);
                m_canvas.rotate(font.m_angle);
                m_canvas.drawText(text, -(andriodRect.right - andriodRect.left) / 2, -(andriodRect.bottom - andriodRect.top) / 2, m_paint);
                m_canvas.restore();
            }else {
                m_canvas.drawText(text, andriodRect.left, baseLineY, m_paint);
            }
            m_paint.setAntiAlias(false);
        }
    }

    public void drawTextAutoEllipsis(String text, long dwPenColor, FCFont font, FCRect rect)
    {
        drawText(text, dwPenColor, font, rect, -1);
    }

    public void endPaint()
    {
        m_paint.setPathEffect(null);
        RectF andriodRect = new RectF(m_pRect.left, m_pRect.top, m_pRect.right, m_pRect.bottom);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        if (m_doubleBufferd)
        {
            m_viewCanvas.restore();
        }
        if (m_isClip)
        {
            if (m_doubleBufferd)
            {
                m_canvas.restore();
            } else
            {
                m_viewCanvas.restore();
            }
        }
        m_isClip = false;
        m_offsetX = 0;
        m_offsetY = 0;
        m_resourcePath = "";
    }

    public void excludeClipPath()
    {
        m_canvas.clipPath(m_path, Op.XOR);
    }

    public void fillEllipse(long dwPenColor, FCRect rect)
    {
        if (dwPenColor == FCColor.None) return;
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        setFillPaint(dwPenColor);
        m_paint.setAntiAlias(true);
        m_canvas.drawOval(andriodRect, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void fillEllipse(long dwPenColor, int left, int top, int right, int bottom)
    {
        FCRect newRect = new FCRect(left, top, right, bottom);
        fillEllipse(dwPenColor, newRect);
    }

    public void fillGradientEllipse(long dwFirst, long dwSecond, FCRect rect, int angle)
    {
        if (dwFirst == FCColor.None) return;
        if (dwSecond == FCColor.None) return;
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        LinearGradient shade = new LinearGradient(andriodRect.left, andriodRect.top, andriodRect.left, andriodRect.bottom,
                getAndriodColor(dwFirst), getAndriodColor(dwSecond), Shader.TileMode.REPEAT);
        m_paint.setShader(shade);
        setFillPaint(dwFirst);
        m_paint.setAntiAlias(true);
        m_canvas.drawOval(andriodRect, m_paint);
        m_paint.setAntiAlias(false);
        m_paint.setShader(null);
    }

    public void fillGradientPath(long dwFirst, long dwSecond, FCRect rect, int angle)
    {
        if (dwFirst == FCColor.None) return;
        if (dwSecond == FCColor.None) return;
        Path path = new Path();
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        LinearGradient shade = new LinearGradient(andriodRect.left, andriodRect.top, andriodRect.left, andriodRect.bottom,
                getAndriodColor(dwFirst), getAndriodColor(dwSecond), Shader.TileMode.REPEAT);
        m_paint.setShader(shade);
        path.addRect(andriodRect, Path.Direction.CW);
        setFillPaint(dwFirst);
        m_paint.setAntiAlias(true);
        m_canvas.drawPath(path, m_paint);
        m_paint.setAntiAlias(false);
        m_paint.setShader(null);
    }

    public void fillGradientPolygon(long dwFirst, long dwSecond, FCPoint[] points, int angle)
    {
        if (dwFirst == FCColor.None) return;
        if (dwSecond == FCColor.None) return;
        Path path = new Path();
        int minX = 0, minY = 0;
        int maxX = 0, maxY = 0;
        int fx = 0, fy = 0;
        int cpt = points.length;
        for (int i = 0; i < cpt; i++)
        {
            int x = points[i].x + m_offsetX;
            int y = points[i].y + m_offsetY;
            if (m_scaleFactorX != 1 || m_scaleFactorY != 1)
            {
                x = (int) (m_scaleFactorX * x);
                y = (int) (m_scaleFactorY * y);
            }
            if (i == 0)
            {
                fx = x;
                fy = y;
                maxX = x;
                maxY = y;
                path.moveTo(x, y);
            } else
            {
                path.lineTo(x, y);
            }
            if (minX > x)
            {
                minX = x;
            }
            if (minY > y)
            {
                minY = y;
            }
            if (maxX < x)
            {
                maxX = x;
            }
            if (maxY < y)
            {
                maxY = y;
            }
        }
        path.close();
        LinearGradient shade = new LinearGradient(minX, minY, minX, maxY, getAndriodColor(dwFirst),
                getAndriodColor(dwSecond), Shader.TileMode.REPEAT);
        m_paint.setShader(shade);
        setFillPaint(dwFirst);
        m_paint.setAntiAlias(true);
        m_canvas.drawPath(path, m_paint);
        m_paint.setAntiAlias(false);
        m_paint.setShader(null);
    }

    public void fillGradientRect(long dwFirst, long dwSecond, FCRect rect, int cornerRadius, int angle)
    {
        if (dwFirst == FCColor.None) return;
        if (dwSecond == FCColor.None) return;
        Path path = new Path();
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        LinearGradient shade = new LinearGradient(andriodRect.left, andriodRect.top, andriodRect.left, andriodRect.bottom,
                getAndriodColor(dwFirst), getAndriodColor(dwSecond), Shader.TileMode.REPEAT);
        m_paint.setShader(shade);
        if (cornerRadius > 0)
        {
            path.addRoundRect(andriodRect, cornerRadius, cornerRadius, Path.Direction.CW);
        } else
        {
            path.addRect(andriodRect, Path.Direction.CW);
        }
        setFillPaint(dwFirst);
        m_paint.setAntiAlias(true);
        m_canvas.drawPath(path, m_paint);
        m_paint.setAntiAlias(false);
        path.close();
        m_paint.setShader(null);
    }

    public void fillPath(long dwPenColor)
    {
        if (dwPenColor == FCColor.None) return;
        setFillPaint(dwPenColor);
        m_paint.setAntiAlias(true);
        m_canvas.drawPath(m_path, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void fillPie(long dwPenColor, FCRect rect, float startAngle, float sweepAngle)
    {
        if (dwPenColor == FCColor.None) return;
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        setFillPaint(dwPenColor);
        m_paint.setAntiAlias(true);
        m_canvas.drawArc(andriodRect, startAngle, sweepAngle, true, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void fillPolygon(long dwPenColor, FCPoint[] points)
    {
        if (dwPenColor == FCColor.None) return;
        Path path = new Path();
        int fx = 0, fy = 0;
        int cpt = points.length;
        for (int i = 0; i < cpt; i++)
        {
            int x = points[i].x + m_offsetX;
            int y = points[i].y + m_offsetY;
            if (m_scaleFactorX != 1 || m_scaleFactorY != 1)
            {
                x = (int) (m_scaleFactorX * x);
                y = (int) (m_scaleFactorY * y);
            }
            if (i == 0)
            {
                fx = x;
                fy = y;
                path.moveTo(x, y);
            } else
            {
                path.lineTo(x, y);
            }
        }
        path.close();
        setFillPaint(dwPenColor);
        m_paint.setAntiAlias(true);
        m_canvas.drawPath(path, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void fillRect(long dwPenColor, FCRect rect)
    {
        if (dwPenColor == FCColor.None) return;
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        setFillPaint(dwPenColor);
        m_paint.setAntiAlias(false);
        m_canvas.drawRect(andriodRect, m_paint);
        m_paint.setAntiAlias(false);
    }

    public void fillRect(long dwPenColor, int left, int top, int right, int bottom)
    {
        FCRect newRect = new FCRect(left, top, right, bottom);
        fillRect(dwPenColor, newRect);
    }

    public void fillRoundRect(long dwPenColor, FCRect rect, int cornerRadius)
    {
        if (cornerRadius == 0)
        {
            fillRect(dwPenColor, rect);
        } else
        {
            if (dwPenColor == FCColor.None) return;
            RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
            RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
            affectScaleFactor(refAndriodRect);
            andriodRect = refAndriodRect.argvalue;
            Path path = new Path();
            path.addRoundRect(andriodRect, cornerRadius, cornerRadius, Path.Direction.CW);
            path.close();
            setFillPaint(dwPenColor);
            m_paint.setAntiAlias(true);
            m_canvas.drawPath(path, m_paint);
            m_paint.setAntiAlias(false);
        }
    }

    public long getColor(long dwPenColor)
    {
        return m_myColor.getUserColor(dwPenColor);
    }

    public int m_lastStyle = -1;

    public int getAndriodColor(long dwPenColor)
    {
        if(m_opacity == 1 && m_myColor.m_gdiColors.containsKey(dwPenColor) && m_lastStyle == MyColor.m_style){
            return m_myColor.m_gdiColors.get(dwPenColor);
        }
        m_lastStyle = MyColor.m_style;
        long dwPenColor2 = getPaintColor(dwPenColor);
        int a = 0, r = 0, g = 0, b = 0;
        RefObject<Integer> refA = new RefObject<Integer>(a);
        RefObject<Integer> refR = new RefObject<Integer>(r);
        RefObject<Integer> refG = new RefObject<Integer>(g);
        RefObject<Integer> refB = new RefObject<Integer>(b);
        FCColor.toRgba(this, dwPenColor2, refR, refG, refB, refA);
        a = refA.argvalue;
        r = refR.argvalue;
        g = refG.argvalue;
        b = refB.argvalue;
        if (m_opacity < 1)
        {
            return Color.argb((int) (a * m_opacity), r, g, b);
        } else
        {
            int color = Color.argb(a, r, g, b);
            m_myColor.m_gdiColors.put(dwPenColor, color);
            return color;
        }
    }

    public long getPaintColor(long dwPenColor)
    {
        dwPenColor =  getColor(dwPenColor);
        if(MyColor.getReverseColor() == 1){
            int r = 0, g = 0, b = 0, a = 0;
            RefObject<Integer> refR = new RefObject<Integer>(r);
            RefObject<Integer> refG = new RefObject<Integer>(g);
            RefObject<Integer> refB = new RefObject<Integer>(b);
            RefObject<Integer> refA = new RefObject<Integer>(a);
            FCColor.toRgba(null, dwPenColor, refR, refG, refB, refA);
            dwPenColor = FCColor.rgba(255 - refR.argvalue, 255 - refG.argvalue, 255 - refB.argvalue, refA.argvalue);
        }
        return dwPenColor;
    }

    /**
     * 获取偏移
     *
     * @return 偏移坐标
     */
    public FCPoint getOffset()
    {
        return new FCPoint(m_offsetX, m_offsetY);
    }

    public void getScaleFactor(RefObject<Double> scaleFactorX, RefObject<Double> scaleFactorY){
        scaleFactorX.argvalue = m_scaleFactorX;
        scaleFactorY.argvalue = m_scaleFactorY;
    }

    /**
     * 旋转角度
     *
     * @param op    圆心坐标
     * @param mp    点的坐标
     * @param angle 角度
     * @return 结果坐标
     */
    public FCPoint rotate(FCPoint op, FCPoint mp, int angle)
    {
        float PI = 3.14159265f;
        FCPoint pt = new FCPoint();
        pt.x = (int) ((mp.x - op.x) * Math.cos(angle * PI / 180) - (mp.y - op.y) * Math.sin(angle * PI / 180) + op.x);
        pt.y = (int) ((mp.x - op.x) * Math.sin(angle * PI / 180) + (mp.y - op.y) * Math.cos(angle * PI / 180) + op.y);
        return pt;
    }

    public void saveImage(String key, Bitmap value)
    {
        m_images.put(key, value);
    }
    /**
     * 设置画布
     *
     * @param canvas 画布
     */
    public void setCanvas(Canvas canvas)
    {
        m_viewCanvas = canvas;
    }

    /**
     * 设置裁剪区域
     *
     * @param rect 矩形区域
     */
    public void setClip(FCRect rect)
    {
        if (m_isClip)
        {
            m_canvas.restore();
        }
        RectF andriodRect = new RectF(rect.left + m_offsetX, rect.top + m_offsetY, rect.right + m_offsetX, rect.bottom + m_offsetY);
        RefObject<RectF> refAndriodRect = new RefObject<RectF>(andriodRect);
        affectScaleFactor(refAndriodRect);
        andriodRect = refAndriodRect.argvalue;
        m_canvas.save();
        m_isClip = true;
        m_canvas.clipRect(andriodRect);
        m_paint.setTypeface(Typeface.DEFAULT);
        m_lastFont = "Default";
    }

    /**
     * 设置画笔
     *
     * @param dwPenColor 颜色
     * @param width      宽度
     * @param style      样式
     */
    protected void setDrawPaint(long dwPenColor, float width, int style)
    {
        long aColor = getAndriodColor(dwPenColor);

        m_paint.setColor(getAndriodColor(dwPenColor));
        if (m_scaleFactorX != 1 || m_scaleFactorY != 1) {
            m_paint.setStrokeWidth((float)(width * Math.min(m_scaleFactorX, m_scaleFactorY)));
        }else {
            m_paint.setStrokeWidth(width);
        }
        m_paint.setStyle(Style.STROKE);
        if (style == 0)
        {
            m_paint.setPathEffect(null);
        } else if (style == 1)
        {
            m_paint.setPathEffect(new DashPathEffect(new float[]{10, 10}, 0));
        } else if (style == 2)
        {
            m_paint.setPathEffect(new DashPathEffect(new float[]{2, 4}, 0));
        }
    }

    /**
     * 设置填充画笔
     *
     * @param dwPenColor
     */
    protected void setFillPaint(long dwPenColor)
    {
        m_paint.setColor(getAndriodColor(dwPenColor));
        m_paint.setStyle(Style.FILL);
    }

    public void setLineCap(int startLineCap, int endLineCap)
    {
        if (endLineCap == 0)
        {
            m_paint.setStrokeCap(Paint.Cap.SQUARE);
        } else if (endLineCap == 1)
        {
            m_paint.setStrokeCap(Paint.Cap.ROUND);
        } else
        {
            m_paint.setStrokeCap(Paint.Cap.BUTT);
        }
    }

    public void setOffset(FCPoint mp)
    {
        m_offsetX = mp.x;
        m_offsetY = mp.y;
    }

    public void setOpacity(float opacity)
    {
        m_opacity = opacity;
    }

    public void setResourcePath(String resourcePath)
    {
        m_resourcePath = resourcePath;
    }

    /**
     * 设置旋转角度
     *
     * @param rotateAngle 旋转角度
     */
    public void setRotateAngle(int rotateAngle)
    {
        m_rotateAngle = rotateAngle;
    }

    /**
     * 设置缩放因子
     *
     * @param scaleFactorX 横向因子
     * @param scaleFactorY 纵向因子
     */
    public void setScaleFactor(double scaleFactorX, double scaleFactorY) {
        m_scaleFactorX = scaleFactorX;
        m_scaleFactorY = scaleFactorY;
    }

    /**
     * 设置是否支持透明�?
     * * @return 是否支持
     */
    public boolean supportTransparent()
    {
        return true;
    }

    /**
     * 获取文字大小
     *
     * @param text 文字
     * @param font 字体
     * @return 字体大小
     */
    public FCSize textSize(String text, FCFont font, int width)
    {
        if (text != null)
        {
            String fontFamily = font.m_fontFamily;
            String newFont = "";
            if (fontFamily.equals("Default")) {
                String sysFont = MyColor.getSystemFont();
                if (sysFont.equals("System")) {
                    newFont = "Default";

                } else {
                    newFont = sysFont;
                }
            } else {
                newFont = font.m_fontFamily;
            }
            if(!newFont.equals(m_lastFont)){
                if(newFont.equals("Default")){
                    m_paint.setTypeface(Typeface.DEFAULT);
                }else{
                    try {
                        if(m_typeFaces.containsKey(newFont)){
                            Typeface tf = m_typeFaces.get(newFont);
                            if(tf != m_paint.getTypeface()) {
                                m_paint.setTypeface(m_typeFaces.get(newFont));
                            }
                        }else{
                            Typeface tf = Typeface.createFromFile("/system/fonts/" + newFont + ".ttf");
                            if(tf != null){
                                m_paint.setTypeface(tf);
                                m_typeFaces.put(newFont, tf);
                            }
                        }
                    }catch (Exception ex){

                    }
                }
                m_lastFont = newFont;
            }
            m_paint.setTextSize(font.m_fontSize);
            m_paint.setFakeBoldText(font.m_bold);
            m_paint.setTextSkewX(font.m_italic ? -0.5f : 0);
            m_paint.setUnderlineText(font.m_underline);
            FontMetrics fm = m_paint.getFontMetrics();
            return new FCSize((int) m_paint.measureText(text), (int) (fm.descent - fm.ascent));
        } else
        {
            return new FCSize();
        }
    }

    /**
     * 获取文字大小
     *
     * @param text 文字
     * @param font 字体
     * @return 字体大小
     */
    public FCSizeF textSizeF(String text, FCFont font, int width)
    {
        if (text != null)
        {
            String fontFamily = font.m_fontFamily;
            String newFont = "";
            if (fontFamily.equals("Default")) {
                String sysFont = MyColor.getSystemFont();
                if (sysFont.equals("System")) {
                    newFont = "Default";

                } else {
                    newFont = sysFont;
                }
            } else {
                newFont = font.m_fontFamily;
            }
            if(!newFont.equals(m_lastFont)){
                if(newFont.equals("Default")){
                    m_paint.setTypeface(Typeface.DEFAULT);
                }else{
                    try {
                        if(m_typeFaces.containsKey(newFont)){
                            Typeface tf = m_typeFaces.get(newFont);
                            if(tf != m_paint.getTypeface()) {
                                m_paint.setTypeface(m_typeFaces.get(newFont));
                            }
                        }else{
                            Typeface tf = Typeface.createFromFile("/system/fonts/" + newFont + ".ttf");
                            if(tf != null){
                                m_paint.setTypeface(tf);
                                m_typeFaces.put(newFont, tf);
                            }
                        }
                    }catch (Exception ex){

                    }
                }
                m_lastFont = newFont;
            }
            m_paint.setTextSize(font.m_fontSize);
            m_paint.setFakeBoldText(font.m_bold);
            m_paint.setTextSkewX(font.m_italic ? -0.5f : 0);
            m_paint.setUnderlineText(font.m_underline);
            FontMetrics fm = m_paint.getFontMetrics();
            return new FCSizeF(m_paint.measureText(text), fm.descent - fm.ascent);
        } else
        {
            return new FCSizeF(0, 0);
        }
    }

    public String m_lastFont = "Default";

    public HashMap<String, Typeface> m_typeFaces = new HashMap<String, Typeface>();
}
