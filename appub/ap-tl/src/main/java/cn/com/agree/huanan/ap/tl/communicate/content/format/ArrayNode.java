/**
 * 
 */
package cn.com.agree.huanan.ap.tl.communicate.content.format;

import java.util.ArrayList;

/**
 * @author xqq
 * 循环节点报文根节点,其下可有多个节点,本节点不包含字段信息
 */
public class ArrayNode extends RootNode {
    private ArrayList<Node> nodeList = new ArrayList<>();
    private String nodeName = "";	//节点名称
	private boolean isRequied;		//是否必送
	private String mapKey;			//映射Key
	public ArrayNode(String nodeName,boolean isRequied) {
		this.isRequied = isRequied;
		this.nodeName = nodeName;
		this.mapKey = nodeName;
	}
	public ArrayNode(String nodeName) {
		this.isRequied = false;
		this.nodeName = nodeName;
		this.mapKey = nodeName;
	}
	public ArrayNode(String nodeName,boolean isRequied,String mapKey) {
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
		return "array";
	}

	@Override
	public String getNodeName() {
		return this.nodeName;
	}

	public boolean isRequied() {
		return isRequied;
	}

	@Override
	public ArrayNode addNode(Node node) {
		nodeList.add(node);
		return this;
	}

	public String getMapKey() {
		return mapKey;
	}
}
