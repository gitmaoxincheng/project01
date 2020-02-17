package tc.bank.base.service;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlDev;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfo;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlSvcAuth;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.service.ChlDevService;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.service.ChlInfoService;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.service.ChlSvcAuthService;
import cn.com.agree.huanan.ap.al.csiopr.service.po.TranMapp;
import cn.com.agree.huanan.ap.al.csiopr.service.service.TranMapService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.exception.IllegalReqFormatException;
import cn.com.agree.huanan.ap.rl.bank.service.exception.ChannelIPIllegalException;
import cn.com.agree.huanan.ap.rl.bank.service.exception.ChannelReqIllegalException;
import cn.com.agree.huanan.ap.rl.bank.service.exception.ServiceNotAuthException;
import cn.com.agree.huanan.ap.rl.bank.service.exception.ServiceNotFoundException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import cn.com.agree.huanan.ap.tl.util.StrUtil;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 渠道服务器权限操作 HCP
 * 
 * @date 2019-07-04 19:53:16
 */
@ComponentGroup(level = "银行", groupName = "渠道服务")
public class B_SvcAuth {
	public static final Logger logger = Logger.getLogger(B_SvcAuth.class);

	/**
	 * @category 渠道服务权限校验
	 * @param req
	 *            入参|入参字典|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param opt
	 *            入参|操作|{@link java.lang.String}
	 * @since svcInfo
	 *        出参|服务信息|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "req", comment = "入参字典", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "opt", comment = "操作", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "svcInfo", comment = "服务信息", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "渠道服务权限校验", style = "判断型", type = "同步组件", date = "2019-07-05 01:10:00")
	public static TCResult B_B_certifyChlAuth(JavaDict req, String opt) {

		return TechComp.call(() -> {
			// 注意：如果不做I校验，这里应该要有队REQ拆包完后的内容进行处理
			JavaDict header = req.getDictItem(CommConstant.HEADER);
			// 拆分对外服务码和场景码
			if(header==null) {
				throw new IllegalReqFormatException("请求Header不能为空");
			}
			if(header.getStringItem(CommConstant.ACTION)==null) {
				throw new IllegalReqFormatException("请求Action不能为空");
			}
			String[] action = header.getStringItem(CommConstant.ACTION).replaceAll(CommConstant.NAMESPACE, "") //XXX可优化
					.split("/");
			// 获取拆包中的对外服务码和场景码
			if (action.length < 2 || StrUtil.isEmpty(action[0]) || StrUtil.isEmpty(action[1])) {
				throw new IllegalReqFormatException("请求Action格式不正确");
			}
			logger.info("渠道接入权限认证开始");
			logger.info("请求服务码:" + action[0] + ", 场景码:" + action[1]);
			String ext_svc = action[0];
			String ext_scn = action[1];
			JavaDict csisHeader = req.getDictItem(CommConstant.CSIS_HEADER);
			String srcCalCod = csisHeader.getStringItem(CommConstant.SRCCALCOD, "");
			String srcSysId = csisHeader.getStringItem(CommConstant.SRCSYSID, "");
			String sysId = header.getStringItem(CommConstant.ADDRESS);
			logger.info("请求系统:%s，源系统标识:%s，源系统编码：%s", sysId,srcSysId,srcCalCod);
			JavaDict appHeader = req.getDictItem(CommConstant.APP_HEADER, new JavaDict());
			ChlInfoService chlInfoService = SpringUtil.getBean(ChlInfoService.class);
			ChlSvcAuthService svcAuthService = SpringUtil.getBean(ChlSvcAuthService.class);
			TranMapService tranMapService = SpringUtil.getBean(TranMapService.class);
			ChlDevService chlDevService = SpringUtil.getBean(ChlDevService.class);

			// 校验渠道接入权限
			ChlInfo chlInfo = chlInfoService.getChlInfo(sysId); // 查询渠道权限信息
			if (chlInfo != null  && "2".equals(chlInfo.getStatus())) {
				if (!"0".equals(chlInfo.getChkFlag())) {
					ChlDev chlDev = null;
					// 校验渠道ip接入权限
					if ("1".equals(chlInfo.getChkFlag())) {
						logger.info("IP地址校验");
						chlDev = chlDevService.getChlDevByIp(sysId,csisHeader.getStringItem(CommConstant.SRCIP1),"0"); //0启用，1停用
						if (chlDev == null){
							throw new ChannelIPIllegalException(sysId+":"+srcCalCod+":"+csisHeader.getStringItem(CommConstant.SRCIP1));// 渠道ip没有接入权限
						}
					}else if ("2".equals(chlInfo.getChkFlag())) { 	// 校验渠道设备号接入权限
						logger.info("设备编号校验");
						chlDev = chlDevService.getChlDevByIp(sysId,appHeader.getStringItem(CommConstant.DEVNO),"0"); //0启用，1停用
						if (chlDev == null){
							throw new ChannelIPIllegalException(sysId+":"+srcCalCod+":"+appHeader.getStringItem(CommConstant.DEVNO));// 渠道ip没有接入权限 XXXX
						}
					}
				}
				// 校验渠道服务权限
				ChlSvcAuth svrAuth = svcAuthService.getChlSvcAuth(sysId,ext_svc,ext_scn);// status 0-启用 1-停用
				if (svrAuth == null || "1".equals(svrAuth.getStatus())) {
					logger.debug(srcCalCod+ ":" + sysId,ext_svc+"."+ext_scn);
					throw new ServiceNotAuthException( srcCalCod+ ":" + sysId,ext_svc+"."+ext_scn);// 渠道服务没有接入权限 TODO
				}
			} else {
				throw new ChannelReqIllegalException(sysId); // 渠道没有接入权限，渠道请求非法
			}

			// 交易映射
			TranMapp tranMapBean = tranMapService.querTranMap(ext_svc, ext_scn);
//			JavaDict res = CommService.txMapping(ext_svc, ext_scn); // TODO 服务表的那些PlatformCode是要改回来的
			if (null == tranMapBean) {
				logger.error(String.format("没有相关的交易映射记录,对外服务码：%s,对外场景码:%s", ext_svc, ext_scn));
				throw new ServiceNotFoundException("服务码：" + ext_svc + ",场景码：" + ext_scn);
			}			
			logger.info("服务映射结果:%s",tranMapBean);
			// 构建映射容器
			JavaDict rspDict = new JavaDict();
			rspDict.setItem(CommConstant.REQCALCOD,chlInfo.getChnlCode());
			rspDict.setItem(CommConstant.SVCCODE, tranMapBean.getSvcCode());
			rspDict.setItem(CommConstant.SCNCODE, tranMapBean.getScnCode());
			rspDict.setItem(CommConstant.EXSVC, tranMapBean.getSvcOutCode());
			rspDict.setItem(CommConstant.EXSCN, tranMapBean.getScnOutCode());
			rspDict.setItem(CommConstant.REGFLG, tranMapBean.getRegFlag());
			rspDict.setItem(CommConstant.SVCTYPE, tranMapBean.getType());
			rspDict.setItem(CommConstant.TimeOut, tranMapBean.getTimeOut());
			logger.info("渠道接入权限认证通过");
			return new Object[] {rspDict};
		});
	}

}
