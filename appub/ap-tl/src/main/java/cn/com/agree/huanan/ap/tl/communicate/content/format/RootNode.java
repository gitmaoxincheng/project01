/**
 * 
 */
package cn.com.agree.huanan.ap.tl.communicate.content.format;

import java.util.ArrayList;


/**
 * @author xqq
 * 根节点抽象类
 */
public abstract class RootNode extends Node {
	  public abstract ArrayList<Node> getNodeList();
	  public abstract <T extends Node> T addNode(Node node);
}
