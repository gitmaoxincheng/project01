package cn.com.agree.huanan.ap.tl.db.impl.std.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.impl.base.ProcElement;
import cn.com.agree.huanan.ap.tl.db.std.operator.Procedurer;
import cn.com.agree.huanan.ap.tl.db.impl.base.ProcParamTypeEnum;

/**
 * @author luo.hp
 * @category 存储过程
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProcedurerImpl implements Procedurer {
    @Autowired
    private DbConnection dbConn;

    private List<ProcElement> procElemList= new ArrayList<ProcElement>();
    
    private String procName;
    
    @Override
    public Procedurer procName(String procName) {
        // TODO 自动生成的方法存根
        this.procName = procName;
        return this;
    }

    @Override
    public Procedurer setInParam(String name, Object value) {
        // TODO 自动生成的方法存根
        procElemList.add(new ProcElement(ProcParamTypeEnum.IN_PARAM, name, value));
        return this;
    }

    @Override
    public Procedurer setOutParam(String name, Class<?> cls) {
        // TODO 自动生成的方法存根
        procElemList.add(new ProcElement(name, cls));
        return this;
    }

    @Override
    public Procedurer setInOutParam(String name, Object value) {
        // TODO 自动生成的方法存根
        procElemList.add(new ProcElement(ProcParamTypeEnum.IN_OUT_PARAM, name, value));
        return this;
    }

    @Override
    public Map<String, Object> call() {
        // TODO 自动生成的方法存根
        dbConn.call(procName, procElemList);
        return procElemList.stream()
                .filter(i->i.getParamType().compareTo(ProcParamTypeEnum.OUT_PARAM)== 0
                        || i.getParamType().compareTo(ProcParamTypeEnum.IN_OUT_PARAM) == 0)
                .collect(Collectors.toMap(ProcElement::getParamName, ProcElement::getParamValue));
    }

    
}
