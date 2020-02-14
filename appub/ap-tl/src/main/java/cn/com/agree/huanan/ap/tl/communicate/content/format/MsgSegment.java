/**
 * 
 */
package cn.com.agree.huanan.ap.tl.communicate.content.format;

import java.util.ArrayList;

/**
 * @author xqq
 * 报文片段,由报文节点对象组成
 */
public class MsgSegment {
	private final ArrayList<Node> nodeList = new ArrayList<>();

	public MsgSegment() {
		// TODO 自动生成的构造函数存根
	}

	public void mergeSegment(MsgSegment message) {
		// TODO 自动生成的构造函数存根
		nodeList.addAll(message.getNodeList());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Node> getNodeList() {
		return (ArrayList<Node>) nodeList.clone();
	}

	public MsgSegment addStructNode(StructNode node) {
		nodeList.add(node);
		return this;
	}
  
	public MsgSegment addArrayNode(ArrayNode node){
		nodeList.add(node);
		return this;
	}
	
	public MsgSegment addFieldNode(FieldNode node){
		nodeList.add(node);
		return this;
	}
}
