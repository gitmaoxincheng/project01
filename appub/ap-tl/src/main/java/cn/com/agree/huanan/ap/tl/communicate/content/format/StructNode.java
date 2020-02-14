/**
 * 
 */
package cn.com.agree.huanan.ap.tl.communicate.content.format;

import java.util.ArrayList;

/**
 * @author xqq
 * 结构体报文根节点,其下可有多个节点,本节点不包含字段信息
 */
public class StructNode extends RootNode {
    private ArrayList<Node> nodeList = new ArrayList<>();
    private String nodeName = "";	//节点名称
    private boolean isRequied;		//是否必送
	private String mapKey;			//映射Key

	public StructNode(String nodeName) {
		this.isRequied = false;
		this.nodeName = nodeName;
		this.mapKey = nodeName;
	}

	public StructNode(String nodeName,boolean isRequired) {
		this.isRequied = isRequied;
		this.nodeName = nodeName;
		this.mapKey = nodeName;
	}

	public StructNode(String nodeName,boolean isRequired,String mapKey) {
		this.isRequied = isRequied;
		this.nodeName = nodeName;
		this.mapKey = mapKey;
	}
	@Override
	public ArrayList getNodeList() {
		return new ArrayList<Node>(nodeList);
	}

	@Override
	public String getNodeType() {
		return "struct";
	}

	@Override
	public String getNodeName() {
		return this.nodeName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StructNode addNode(Node node) {
		nodeList.add(node);
		return this;
	}

	public boolean isRequied() {
		return isRequied;
	}

	public String getMapKey() {
		return mapKey;
	}
}
