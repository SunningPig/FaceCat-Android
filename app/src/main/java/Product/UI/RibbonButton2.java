package Product.UI;

import facecat.topin.btn.FCButton;
import facecat.topin.core.*;

public class RibbonButton2 extends FCButton {
    public RibbonButton2(){
        setBorderColor(FCColor.None);
        setTextColor(MyColor.USERCOLOR84);
        FCFont font = new FCFont("Default", 12, false, false, false);
        setFont(font);
        setBackColor(MyColor.USERCOLOR83);
        setCornerRadius(4);
    }

    public void onPaint(FCPaint paint, FCRect clipRect){
        int width = getWidth(), height = getHeight();
        FCRect drawRect = new FCRect(1, 1, width - 1, height - 1);
        FCFont tFont = getFont();
        FCSize tSize = paint.textSize(getText(), tFont);
        FCRect tRect = new FCRect((width - tSize.cx) / 2, (height - tSize.cy) / 2, (width + tSize.cx) / 2, (height + tSize.cy) / 2);
        if (this == m_native.getPushedView())
        {
            paint.fillRoundRect(MyColor.USERCOLOR82, drawRect, getCornerRadius());
        }
        else if (this == m_native.getHoveredView())
        {
            paint.fillRoundRect(MyColor.USERCOLOR81, drawRect, getCornerRadius());
        }
        else
        {
            if(MyColor.m_style == 0 || MyColor.m_style == 1 || MyColor.m_style == 6){
                paint.fillRoundRect(getPaintingBackColor(), drawRect, getCornerRadius());
            }else{
                paint.fillRoundRect(MyColor.USERCOLOR79, drawRect, getCornerRadius());
            }
        }
        paint.drawText(getText(), getPaintingTextColor(), tFont, tRect);
    }
}
