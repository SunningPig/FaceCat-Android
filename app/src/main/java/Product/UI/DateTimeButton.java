/*
 * FaceCat图形通讯框架
 * 上海卷卷猫信息技术有限公司
 */

package Product.UI;
import java.util.ArrayList;
import facecat.topin.core.*;
import facecat.topin.btn.*;

/**
 * 日期按钮
 */
public class DateTimeButton extends FCButton
{
    /**
     * 构造函数
     */
    public DateTimeButton()
    {

    }

    private String m_dateMode = "";

    /**
     * 获取日期模式
     */
    public String getDateMode()
    {
        return m_dateMode;
    }

    /**
     * 设置日期模式
     */
    public void setDateMode(String dateMode)
    {
        m_dateMode = dateMode;
    }

    /**
     * 获取类型
     * @return
     */
    public String getViewType(){
        return "SpinComboBox";
    }

    /**
     * 获取属性
     * @param name 名称
     * @param value 值
     * @param type 类型
     */
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

    /**
     * 设置属性
     * @param name 名称
     * @param value 值
     */
    public void setAttribute(final String name, final String value) {
        if (name.equals("datemode")) {
            setDateMode(value);
        }
        else {
            super.setAttribute(name, value);
        }
    }

    /**
     * 获取所有属性
     * @return 属性列表
     */
    public ArrayList<String> getAttributeNames(){
        ArrayList<String> attributeNames = super.getAttributeNames();
        attributeNames.add("DateMode");
        return attributeNames;
    }

    /**
     * 重绘背景
     * @param paint 绘图对象
     * @param clipRect 裁剪区域
     */
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
