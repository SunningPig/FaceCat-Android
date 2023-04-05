/*
 * FaceCat图形通讯框架
 * 上海卷卷猫信息技术有限公司
 */

package Product.UI;

import facecat.topin.core.*;
import facecat.topin.btn.*;
import facecat.topin.div.*;
import facecat.topin.scroll.*;

/**
 * 滚动按钮
 */
public class ScrollButtonM extends FCButton {
    /**
     创建透明按钮

     */
    public ScrollButtonM()
    {
        setBorderColor(FCColor.None);
    }

    /**
     重绘背景

     @param paint 绘图对象
     @param clipRect 裁剪区域
     */
    @Override
    public void onPaintBackground(FCPaint paint, FCRect clipRect)
    {
        FCView parent = getParent();
        if(parent != null)
        {
            FCScrollBar scrollBar = (FCScrollBar)((parent.getParent() instanceof  FCScrollBar) ? parent.getParent() :null);
            boolean show = false;
            if(scrollBar.getAddSpeed() != 0)
            {
                show = true;
            }
            FCDiv div = (FCDiv)((scrollBar.getParent() instanceof  FCDiv) ? scrollBar.getParent() :null);
            if(div.isDragScrolling())
            {
                show = true;
            }
            if(show)
            {
                int cornerRadis = 8;
                int width = getWidth(), height = getHeight();
                FCRect drawRect = new FCRect(0, 0, width, height);
                if (allowDrag() && this == m_native.getPushedView())
                {
                    paint.fillRoundRect(MyColor.USERCOLOR5, drawRect, cornerRadis);
                }
                else
                {
                    if (MyColor.m_style == 0 || MyColor.m_style == 1 || MyColor.m_style == 6)
                    {
                        paint.fillRoundRect(FCColor.Border, drawRect, cornerRadis);
                    }
                else
                    {
                        paint.fillRoundRect(MyColor.USERCOLOR74, drawRect, cornerRadis);
                    }
                }
            }
        }
    }
}
