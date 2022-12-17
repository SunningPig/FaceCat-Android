package Product.UI;

import org.w3c.dom.Node;

import facecat.topin.core.FCView;

public interface IOutReWrite {
    /// <summary>
    /// 创建视图
    /// </summary>
    /// <param name="type"></param>
    /// <returns></returns>
    FCView createView(UIXmlEx uiXmlEx, Node node);

    /// <summary>
    /// 是否有更多的解析
    /// </summary>
    /// <param name="view"></param>
    /// <param name="uiXmlEx"></param>
    /// <param name="node"></param>
    /// <returns></returns>
    boolean moreAnalysis(FCView view, UIXmlEx uiXmlEx, Node node);
}
