/*
 * FaceCat图形通讯框架
 * 上海卷卷猫信息技术有限公司
 */

package Product.Script;
import facecat.topin.chart.*;
import facecat.topin.xml.*;
import facecat.topin.core.*;

/** 脚本信息
*
 */
public class FaceCatScript implements FCUIScript
{
    /*
    创建脚本
     */
    public FaceCatScript(FCUIXml xml)
    {
        m_xml = xml;
    }

    /**
     析构方法

     */
    protected void finalize() throws Throwable
    {
        delete();
    }

    FCScript m_script;

    private boolean m_isDeleted = false;

    /**
     获取是否被销毁

     */
    public final boolean isDeleted()
    {
        return m_isDeleted;
    }

    private FCUIXml m_xml;

    /*
    获取或设置XML对象
     */
    public FCUIXml getXml()
    {
        return m_xml;
    }
    public void setXml(FCUIXml value)
    {
        m_xml = value;
    }

    /**
    调用方法
     */
    public String callFunction(String function)
    {
        if(m_script != null) {
            if (m_script != null)
            {
                int cindex = function.indexOf('(');
                String upperName = function.substring(0, cindex).toUpperCase();
                if (m_script.m_tempFunctions.containsKey(upperName))
                {
                    double value = m_script.callFunction(function);
                    if (m_script.m_resultVar != null)
                    {
                        CVar resultVar = m_script.m_resultVar;
                        if (resultVar != null && resultVar.m_type == 1)
                        {
                            if (resultVar.m_str.length() > 0 && resultVar.m_str.indexOf("'") == 0) {
                                return resultVar.m_str.substring(1, resultVar.m_str.length() - 1);
                            } else {
                                return resultVar.m_str;
                            }
                        }
                    }
                    return FCTran.doubleToStr(value);
                }
            }
        }
        return "";
    }

    /**
     销毁方法
     */
    public void delete()
    {
        if (!m_isDeleted)
        {
            if (m_script != null)
            {
                m_script.delete();
            }
            m_isDeleted = true;
        }
    }

    /**
    获取属性
     */
    public String getAttribute(String name, String propertyName)
    {
        if (m_xml != null)
        {
            FCView control = m_xml.findView(name);
            if (control != null)
            {
                String value = null, type = null;
                RefObject<String> refValue = new RefObject<String>(value);
                RefObject<String> refType = new RefObject<String>(type);
                control.getAttribute(propertyName, refValue, refType);
                value = refValue.argvalue;
                type = refType.argvalue;
                return value;
            }
        }
        return null;
    }

    /**
    获取调用者
     */
    public String getSender()
    {
        if (m_xml != null)
        {
            FCUIEvent uiEvent = m_xml.getEvent();
            if (uiEvent != null)
            {
                return uiEvent.getSender();
            }
        }
        return null;
    }

    /**
    设置属性
     */
    public void setAttribute(String name, String propertyName, String propertyValue)
    {
        if (m_xml != null)
        {
            FCView control = m_xml.findView(name);
            if (control != null)
            {
                control.setAttribute(propertyName, propertyValue);
            }
        }
    }

    /**
    设置脚本
     */
    public void setText(String text)
    {

    }
}
