/*
 * FaceCat图形通讯框架(非开源)
 * 著作权编号:2015SR229355+2020SR0266727
 * 上海卷卷猫信息技术有限公司
 */

package Product.UI;
import java.util.ArrayList;
import facecat.topin.core.*;
import facecat.topin.btn.*;


public class DateTimeButton extends FCButton
{
    public DateTimeButton()
    {

    }

    private String m_dateMode = "";

    public String getDateMode()
    {
        return m_dateMode;
    }

    public void setDateMode(String dateMode)
    {
        m_dateMode = dateMode;
    }

    public String getViewType(){
        return "SpinComboBox";
    }

    public void getAttribute(final String name, RefObject<String> value, RefObject<String> type){
        if(name.equals("datemode"))
        {
            type.argvalue = "text";
            value.argvalue = getDateMode();
        }
        else
        {
            super.getAttribute(name, value, type);
        }
    }

    public void setAttribute(final String name, final String value) {
        if (name.equals("datemode")) {
            setDateMode(value);
        }
        else {
            super.setAttribute(name, value);
        }
    }

    public ArrayList<String> getAttributeNames(){
        ArrayList<String> attributeNames = super.getAttributeNames();
        attributeNames.add("DateMode");
        return attributeNames;
    }

    public void onPaintBackground(FCPaint paint, FCRect clipRect)
    {
        String text = getText();
        int width = getWidth(), height = getHeight();
        int mw = width / 2, mh = height / 2;
        FCRect drawRect = new FCRect(0, 0, width, height);
        paint.fillRoundRect(getPaintingBackColor(), drawRect, 10);
        //绘制选中效果
        if (paint.supportTransparent())
        {
            FCNative inative = getNative();
        }
    }
}
