/**
 * 
 */
package cn.com.agree.huanan.ap.tl.communicate.content.format;

import lombok.Getter;
import lombok.Setter;


/**
 * @author xqq,hcp
 * 报文字段节点
 */
public class FieldNode extends MessageNode {
	private MsgField msgField;
	private String nodeName;
	@Setter
	@Getter
	/**
	 * 设定默认值
	 */
	private Object defaultValue;
	public FieldNode(String nodeName, MsgField msgField,Object defaultValue) {
		this.nodeName = nodeName;
		this.msgField = msgField;
		this.defaultValue = defaultValue;
	}

	public FieldNode(String nodeName, MsgField msgField) {
		this.nodeName = nodeName;
		this.msgField = msgField;
	}
	/* （非 Javadoc）
	 * @see cn.com.agree.huanan.ap.tl.communicate.content.format.Node#getNodeType()
	 */
	@Override
	public String getNodeType() {
		// TODO 自动生成的方法存根
		return "field";
	}

	/* （非 Javadoc）
	 * 返回字段节点名,可与字段名不同,用于映射上下文中的字段名
	 */
	@Override
	public String getNodeName() {
		// TODO 自动生成的方法存根
		return this.nodeName;
	}
	
	/**
	 * 返回本节点的报文字段对象
	 */
	@Override
	public MsgField getMesField() {
		// TODO 自动生成的方法存根
		return this.msgField;
	}
}
