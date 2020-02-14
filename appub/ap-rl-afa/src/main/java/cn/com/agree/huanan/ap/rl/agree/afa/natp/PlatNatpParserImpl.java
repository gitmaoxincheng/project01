package cn.com.agree.huanan.ap.rl.agree.afa.natp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import cn.com.agree.afa.jcomponent.NatpCodec;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.impl.NatpParserImpl;

/**
 * @author luo.hp
 *
 */
@Component
public class PlatNatpParserImpl extends NatpParserImpl {

    /**
     * logger
     */
    public final static Logger logger = Logger.getLogger(PlatNatpParserImpl.class);

    /**
     * 默认编码
     */
    public final static String DEFAULT_ENCODING = "UTF-8";

    @Override
    public Map<String, Object> natpToMap(byte[] natpMsg) {
        // TODO 自动生成的方法存根
        return natpToMap(natpMsg, DEFAULT_ENCODING);
    }

    @Override
    public Map<String, Object> natpToMap(byte[] natpMsg, String encoding) {
        // TODO 自动生成的方法存根
        JavaDict recvDict = new JavaDict();
        recvDict.put("__RCVPCK__", natpMsg);
        TCResult result = NatpCodec.decode(recvDict, encoding);
        if (result.getStatus() != 1) {
            logger.error("Nap报文拼包错误");
            throw new PlatNatpException();
        }
        return dictToMap(recvDict);
    }

    @Override
    public byte[] mapToNatp(Map<String, Object> natpMap) {
        // TODO 自动生成的方法存根
        return mapToNatp(natpMap, DEFAULT_ENCODING);
    }

    @Override
    public byte[] mapToNatp(Map<String, Object> natpMap, String encoding) {
        // TODO 自动生成的方法存根
        String mcName = "__MC__";
        String tcName = "__TC__";
        String ncName = "__NC__";
        if (!natpMap.containsKey(mcName)) {
            natpMap.put(mcName, "");
        }
        if (!natpMap.containsKey(tcName)) {
            natpMap.put(tcName, "");
        }
        if (!natpMap.containsKey(ncName)) {
            natpMap.put(ncName, "");
        }
        JavaDict rspDict = mapToDict(natpMap);
        TCResult result = NatpCodec.encode(rspDict, encoding);
        if (result.getStatus() != 1) {
            logger.error("Nap报文拼包错误");
            throw new PlatNatpException();
        }

        return (byte[]) rspDict.get("__SNDPCK__");
    }

    private Map<String, Object> dictToMap(JavaDict dict) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Entry<Object, Object> entry : dict.entrySet()) {
            map.put((String) entry.getKey(), entry.getValue());
        }
        return map;
    }

    private JavaDict mapToDict(Map<?, ?> map) {
        JavaDict dict = new JavaDict();
        dict.putAll(map);
        return dict;
    }
}