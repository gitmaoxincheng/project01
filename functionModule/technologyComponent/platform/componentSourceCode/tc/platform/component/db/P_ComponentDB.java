package tc.platform.component.db;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 数据库操作类
 * 
 * @date 2019-03-23 9:49:57
 */
@ComponentGroup(level = "平台", groupName = "数据库操作类")
public class P_ComponentDB {

	

    /**
     * @category 数据库回滚
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "数据库回滚", style = "判断型", type = "同步组件", comment = "数据库回滚", author = "lenovo", date = "2018-11-02 09:31:22")
    public static TCResult P_DataRollBack() {
        return TechComp.callWithBean(DbOperator.class, (dao) -> {
            dao.rollback();
            return new Object[] {};
        });
    }

    /**
     * @category 数据库提交
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "数据库提交", style = "判断型", type = "同步组件", comment = "数据库提交", author = "lenovo", date = "2018-11-02 09:31:55")
    public static TCResult P_DataCommit() {
        return TechComp.callWithBean(DbOperator.class, (dao) -> {
            dao.commit();
            return new Object[] {};
        });
    }	

}
