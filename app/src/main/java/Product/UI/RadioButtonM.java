package Product.UI;

import java.util.ArrayList;

import facecat.topin.btn.FCRadioButton;
import facecat.topin.core.FCColor;
import facecat.topin.core.FCFont;
import facecat.topin.core.FCHorizontalAlign;
import facecat.topin.core.FCPaint;
import facecat.topin.core.FCRect;
import facecat.topin.core.FCSize;
import facecat.topin.core.FCView;
import facecat.topin.core.RefObject;

public class RadioButtonM extends FCRadioButton {
    public RadioButtonM()
    {
        setButtonSize(new FCSize(25, 25));
    }

    private String m_image;

    /**
     * 获取或者设置图片
     * @return
     */
    public String getImage(){return m_image;};

    public void setImage(String image){
        m_image = image;
    }

    @Override
    public void getAttribute(String name, RefObject<String> value, RefObject<String> type)
    {
        FCView controlA = new FCView();
        if(name.equals("image")){
            type.argvalue = "String";
            value.argvalue = getImage();
        }else {
            super.getAttribute(name, value, type);
        }
    }

    @Override
    public void setAttribute(String name, String value)
    {
        if (name.equals("image"))
        {
            setImage(value);
        }
        else {
            super.setAttribute(name, value);
        }
    }

    @Override
    public ArrayList<String> getAttributeNames()
    {
        ArrayList<String> propertyNames = super.getAttributeNames();
        propertyNames.add("Image");
        return propertyNames;
    }

    @Override
    public void onPaintCheckButton(FCPaint paint, FCRect clipRect)
    {

    }

    @Override
    public void onPaintForeground(FCPaint paint, FCRect clipRect)
    {
        boolean isChecked = isChecked();
        String text = getText();
        FCFont font = getFont();
        long backColor = FCColor.rgb(204, 204, 204);
        int width = getWidth(), height = getHeight();
        FCRect buttonRect = new FCRect(5, (height - m_buttonSize.cy) / 2, 5 + m_buttonSize.cx, (height + m_buttonSize.cy) / 2);
        if (m_buttonAlign == FCHorizontalAlign.Center)
        {
            buttonRect.left = (width - m_buttonSize.cx) / 2;
            buttonRect.right = (width + m_buttonSize.cx) / 2;
        }
        else if (m_buttonAlign == FCHorizontalAlign.Right)
        {
            buttonRect.left = width - m_buttonSize.cx - 5;
            buttonRect.right = width - 5;
        }
        paint.fillRoundRect(backColor, buttonRect, 10);
        if (isChecked)
        {
            long checkedColor = FCColor.rgb(215, 85, 22);
            FCSize buttonSize = new FCSize(16, 16);
            FCRect innerRect = new FCRect(buttonRect.left + buttonSize.cx / 4, buttonRect.top + buttonSize.cy / 4,
                    buttonRect.right - buttonSize.cx / 4, buttonRect.bottom - buttonSize.cy / 4);
            paint.fillRoundRect(checkedColor, innerRect, 10);
        }
        int startX = buttonRect.right + 2;
        int length = 30;
        if(m_image != null && m_image.length() > 0)
        {
            FCRect imageRect = new FCRect(startX, 0, startX + length, height);
            paint.drawImage(m_image, imageRect);
            startX = startX + length + 2;
        }
        FCSize size = paint.textSize(text, font, -1);
        FCRect textRect = new FCRect(startX, height / 2 - size.cy / 2 - 3, startX + size.cx, height / 2 + size.cy / 2 - 3);
        paint.drawText(text, getTextColor(), font, textRect, -1);
    }
}
