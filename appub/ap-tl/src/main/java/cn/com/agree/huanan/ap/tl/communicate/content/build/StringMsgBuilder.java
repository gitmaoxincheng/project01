package cn.com.agree.huanan.ap.tl.communicate.content.build;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.validator.VaildateFailureException;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author xqq hcp
 * 报文拼接入口类
 */
public class StringMsgBuilder implements MsgBuilder<Map<String, Object>, String> {

    public static final Logger logger = Logger.getLogger(StringMsgBuilder.class);

    @Override
    public Map<String, Object> init(Map dataMap, ArrayList<MsgFormat> formatList, boolean isCheck) {
        Map<String, Object> msgcontentMap = formatList.stream().collect(() ->
                        new LinkedHashMap<String, Object>(),
                (msgMap, f) -> {
                    this.setFieldValue(f.listNode(), dataMap, msgMap, isCheck);
                },
                (map1, map2) -> {
                }
        );
        return msgcontentMap;
    }

    @Override
    public String check(String fieldValue, FieldNode filedNode) {
        return null;
    }


    /**
     * 根据format中配置的节点信息,组合请求报文容器
     * @param nodes 节点列表
     * @param req 节点值容器
     * @param msgMap 报文容器
     */
    private void setFieldValue(ArrayList<Node> nodes, Map req, LinkedHashMap<String, Object> msgMap, boolean isCheck) {
        ArrayDeque<Node> deque = new ArrayDeque<>(nodes);
        while (!deque.isEmpty()) {
            Node currentNode = deque.poll();
            if ("array".equals(currentNode.getNodeType())) {
                ArrayNode arrayNode = (ArrayNode) currentNode;
                String arrayNodeName = arrayNode.getNodeName();
                if (null != req.get(arrayNodeName)) {                //包含Key
                    Object arrayObject = req.get(arrayNodeName);
                    if (!(arrayObject instanceof List)) {                //不为List
                    	if (arrayObject instanceof Map) {
                            ArrayList<Object> msgArrayfielddList = new ArrayList<Object>();
                            LinkedHashMap<String, Object> arrayMap = new LinkedHashMap<String, Object>();
                            msgArrayfielddList.add(arrayMap);
                            msgMap.put(arrayNode.getMapKey(), msgArrayfielddList);    //填充空List
                            
                            Map<String, Object> mapOject = (Map<String, Object>) arrayObject; //递归Map
                            ArrayList<Node> subNodeList = arrayNode.getNodeList();
                            setFieldValue(subNodeList, mapOject, arrayMap, isCheck);
						}
                    } else {
                        ArrayList<Node> subNodeList = arrayNode.getNodeList();
                        ArrayList<Map> arrayFieldValueList = (ArrayList<Map>) arrayObject;
                        if (!msgMap.containsKey(arrayNodeName)) {        //还没Key的时候添加Key-Value (本层数据结构内)
                            //压入循环节点
                            ArrayList<LinkedHashMap<String, Object>> msgArrayfielddList = new ArrayList<LinkedHashMap<String, Object>>();
                            msgMap.put(arrayNode.getMapKey(), msgArrayfielddList);
                            //递归拆解循环字段
                            arrayFieldValueList.stream().forEach(eachValMap -> {
                                LinkedHashMap<String, Object> arrayMap = new LinkedHashMap<String, Object>();
                                msgArrayfielddList.add(arrayMap);
                                setFieldValue(subNodeList, eachValMap, arrayMap, isCheck);
                            });
                        }
                    }
                } else if (isCheck && arrayNode.isRequied()) {
                    throw new VaildateFailureException(new String[]{arrayNodeName, "该字段必输,映射Key:" + arrayNode.getMapKey() + "不存在"});
                }
            } else if ("struct".equals(currentNode.getNodeType())) {
                StructNode structNode = (StructNode) currentNode;
                String structNodeName = structNode.getNodeName();
                if (null != req.get(structNodeName)) {
                    Object structObject = req.get(structNodeName);
                    if (!(structObject instanceof Map)) {
                        //报文为空值
                        LinkedHashMap<String, Object> msgStructFieldMap = new LinkedHashMap<>();
                        msgMap.put(structNode.getMapKey(), msgStructFieldMap);
                    } else {
                        ArrayList<Node> subNodeList = structNode.getNodeList();
                        Map structFieldValueMap = (Map) structObject;

                        if (!msgMap.containsKey(structNode.getMapKey())) {
                            //压入报文集合
                            LinkedHashMap<String, Object> msgStructFieldMap = new LinkedHashMap<>();
                            msgMap.put(structNode.getMapKey(), msgStructFieldMap);
                            //递归拆解字段
                            setFieldValue(subNodeList, structFieldValueMap, msgStructFieldMap, isCheck);
                        } else {
                            LinkedHashMap<String, Object> subMap = (LinkedHashMap<String, Object>) msgMap.get(structNode.getMapKey());
                            setFieldValue(subNodeList, structFieldValueMap, subMap, isCheck);
                        }
                    }
                } else if (isCheck && structNode.isRequied()) {
                    throw new VaildateFailureException(new String[]{structNodeName, "该字段必输,映射Key:" + structNode.getMapKey() + "不存在"});
                }
            } else if ("field".equals(currentNode.getNodeType())) {
                //报文字段赋值
                FieldNode fieldNode = (FieldNode) currentNode;
                String nodeName = fieldNode.getNodeName();
                if (null != req.get(nodeName)) {
                    String fieldValue = req.get(nodeName).toString();
                    //替换null字符串 或者是jsonNull
                    if ("null".equals(fieldValue)) {
                        fieldValue = "";
                    }
                    //执行字段检查
                    if (isCheck && fieldNode.getMesField().isRequired()) {
                        StandardFieldCheck.check(fieldValue, fieldNode);
                    }
                    msgMap.put(fieldNode.getMesField().getItemKey(), req.get(nodeName));
                } else if (isCheck && fieldNode.getMesField().isRequired()) {
                    throw new VaildateFailureException(new String[]{nodeName, "该字段必输,映射Key:" + fieldNode.getMesField().getItemKey() + "不存在"});
                } else {
	                if (fieldNode.getDefaultValue() != null) {
	                    msgMap.put(fieldNode.getMesField().getItemKey(), fieldNode.getDefaultValue());
	                }
//                  Object defaultValue = fieldNode.getDefaultValue();
//                    if (defaultValue != null) {
//                        msgMap.put(fieldNode.getMesField().getItemKey(), defaultValue);
//                    } else {
//                        msgMap.put(fieldNode.getMesField().getItemKey(), ""); // XXX 待考虑
//                    }
                }
            }
        }
    }
    
/*    @Override
	public String build(MessageParser parser, String encoding) {
    	if(parser==null){
    		logger.info("MessageParser为空");
    	}
    	logger.debug("解析器实现类："+parser.getClass().getName());
		return (String) parser.pack(msgcontentMap, encoding);
	}*/
}
