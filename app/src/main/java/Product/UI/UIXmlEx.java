/*
 * FaceCat图形通讯框架(非开源)
 * 著作权编号:2015SR229355+2020SR0266727
 * 上海卷卷猫信息技术有限公司
 */

package Product.UI;

import facecat.topin.btn.FCButton;
import facecat.topin.btn.FCCheckBox;
import facecat.topin.chart.FCChart;
import facecat.topin.core.*;
import facecat.topin.div.FCLayoutDiv;
import facecat.topin.div.FCSplitLayoutDiv;
import facecat.topin.div.FCTableLayoutDiv;
import facecat.topin.input.FCSpin;
import facecat.topin.input.FCTextBox;
import facecat.topin.xml.*;

import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.HashMap;

public class UIXmlEx extends FCUIXml {
	public String m_xmlStr;

	public HashMap<String, String> m_remoteScripts = new HashMap<String, String>();

	public ArrayList<FCView> m_newViews = new ArrayList<FCView>();

	private static boolean m_isClickRunning;

	public static boolean isClickRunning() {
		return m_isClickRunning;
	}

	public static void setIsClickRunning(boolean value) {
		m_isClickRunning = value;
	}

	public void loadXml(String xml, FCView view) {
		super.loadXml(xml, view);
	}

	/**
	 * 创建控件
	 *
	 * @param node 节点
	 * @param type 类型
	 * @return 控件
	 */
	@Override
	public FCView createView(Node node, String type) {
		FCNative inative = getNative();
		int typeLen = type.length();
		switch (typeLen){
			case 4:
			case 5:{
				if (type.equals("input") || type.equals("text")) {
					HashMap<String, String> attributes = getAttributes(node);
					if (attributes.containsKey("type")) {
						String inputType = attributes.get("type");
						if (inputType.equals("button")) {
							return new FCButton();
						} else if (inputType.equals("checkbox")) {
							return new CheckBoxT();
						} else if (inputType.equals("checkbox2")) {
							return new FCCheckBox();
						} else if (inputType.equals("datetime")) {
							return new FCTextBox();
						} else if (inputType.equals("radio")) {
							return new RadioButtonM();
						} else if (inputType.equals("range")) {
							return new FCSpin();
						} else if (inputType.equals("text")) {
							return new FCTextBox();
						} else if (inputType.equals("usercontrol")) {
							return createCustomView(node);
						}
						attributes.clear();
					}
				}
				break;
			}
		}
		if(typeLen > 9) {
			if (type.equals("ribbonbutton")) {
				return new RibbonButton();
			} else if (type.equals("ribbonbutton2")) {
				return new RibbonButton2();
			}
		}
		return super.createView(node, type);
	}

	/**
	 * 加载数据
	 */
	public void loadData() {
	}

	public static HashMap<String, IOutReWrite> m_outReWrites = new HashMap<String, IOutReWrite>();

	/**
	 * 读取XML
	 *
	 * @param node   XML节点
	 * @param parent 父控件
	 */
	public FCView readNode(Node node, FCView parent) {
		try {
			String name = node.getNodeName().toLowerCase();
			if (name.equals("remotescript")) {
				HashMap<String, String> attributesR = getAttributes(node);
				m_remoteScripts.put(attributesR.get("name"), node.getFirstChild().getNodeValue());
				return null;
			}
			String cid = "";
			HashMap<String, String> attributes = getAttributes(node);
			if (attributes.containsKey("cid")) {
				cid = attributes.get("cid");
			}
			IOutReWrite outReWrite = null;
			if (m_outReWrites.containsKey(name)) {
				outReWrite = m_outReWrites.get(name);
			} else if (m_outReWrites.containsKey(cid)) {
				outReWrite = m_outReWrites.get(cid);
			}
			FCView view = null;
			if (outReWrite != null) {
				view = outReWrite.createView(this, node);
				if (view == null) {
					view = createView(node, name);
				}
			} else {
				view = createView(node, name);
			}
			m_newViews.add(view);
			if (view != null) {
				view.setNative(getNative());
				if (parent != null) {
					parent.addView(view);
				} else {
					getNative().addView(view);
				}
				boolean mAnalysis = false;
				if (outReWrite != null) {
					if (outReWrite.moreAnalysis(view, this, node)) {
						mAnalysis = true;
					}
				}
				if (!mAnalysis) {
					// 前设置属性
					setAttributesBefore(node, view);
					FCSplitLayoutDiv splitLayoutDiv = (FCSplitLayoutDiv) ((view instanceof FCSplitLayoutDiv) ? view : null);
					FCTableLayoutDiv tableLayoutDiv = (FCTableLayoutDiv) ((view instanceof FCTableLayoutDiv) ? view : null);
					FCChart chart = (FCChart) ((view instanceof FCChart) ? view : null);
					if (splitLayoutDiv != null) {
						createSplitLayoutSubAttribute(node, splitLayoutDiv);
					} else if (chart != null) {
						createChartSubAttribute(node, chart);
					} else if (tableLayoutDiv != null) {
						createTableLayoutSubAttribute(node, tableLayoutDiv);
					} else {
						// 加载子节点
						readChildNodes(node, view);
					}
					// 后设置属性
					setAttributesAfter(node, view);
					view.update();
					onAddView(view, node);
				}
			} else {
				// 创建子属性
				createSubAttribute(node, parent);
			}
			return view;
		} catch (Exception ex) {
			return null;
		}
	}

	/// <summary>
	/// 后退
	/// </summary>
	/// <returns></returns>
	public boolean goBack() {
		return false;
	}

	/// <summary>
	/// 前进
	/// </summary>
	/// <returns></returns>
	public boolean goForward() {
		return false;
	}

	/// <summary>
	/// 是否可以后退
	/// </summary>
	/// <returns></returns>
	public boolean canGoBack()
	{
		return false;
	}

	/// <summary>
	/// 是否可以前进
	/// </summary>
	/// <returns></returns>
	public boolean canGoForward()
	{
		return false;
	}
}