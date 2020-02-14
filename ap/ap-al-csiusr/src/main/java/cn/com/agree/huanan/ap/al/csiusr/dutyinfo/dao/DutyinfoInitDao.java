package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao;

import java.util.List;

import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po.DutyInfoInit;


public interface DutyinfoInitDao {


    
    /**
     * 查询岗位类别模板列表
     * @param bankFlag
     * @return
     */
    public List<DutyInfoInit> queryList(String bankFlag);
  
}
