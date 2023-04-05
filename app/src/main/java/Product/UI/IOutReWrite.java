package Product.UI;

import org.w3c.dom.Node;

import facecat.topin.core.FCView;

/**
 * 扩展解析
 */
public interface IOutReWrite {
    /**
     * 创建视图
     *
     * @param uiXmlEx XML对象
     * @param node 节点
     * @return 视图
     */
    FCView createView(UIXmlEx uiXmlEx, Node node);

    /**
     *  是否有更多的解析
     * @param view 视图
     * @param uiXmlEx XML对象
     * @param node 节点
     * @return 是否更多解析
     */
    boolean moreAnalysis(FCView view, UIXmlEx uiXmlEx, Node node);
}
