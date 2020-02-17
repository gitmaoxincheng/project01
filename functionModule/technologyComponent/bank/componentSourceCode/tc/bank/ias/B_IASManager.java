package tc.bank.ias;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.rl.bank.ias.service.IasService;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 影像平台查询、上传
 * 
 * @author cts
 * @date 2019-10-19 11:56:19
 */
@ComponentGroup(level = "银行", groupName = "影像平台")
public class B_IASManager {

	private static Logger logger = Logger.getLogger(B_IASManager.class);

	/**
	 * @category 上传到影像平台
	 * @param urlList
	 *            入参|文件路径|{@link Object}
	 * @param brno
	 *            入参|机构号|{@link java.lang.String}
	 * @param BUSI_START_DATE
	 *            入参|业务开始时间|{@link java.lang.String}
	 * @param BUSI_SERIAL_NO
	 *            入参|业务流水号|{@link java.lang.String}
	 * @param modeType
	 *            入参|模型类型|{@link java.lang.String}
	 * @since contentId 出参|批次号|{@link java.lang.String}
	 * @since tradeDate 出参|上传日期|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "urlList", comment = "文件路径", type = Object.class),
			@Param(name = "brno", comment = "机构号", type = java.lang.String.class),
			@Param(name = "BUSI_START_DATE", comment = "业务开始时间", type = java.lang.String.class),
			@Param(name = "BUSI_SERIAL_NO", comment = "业务流水号", type = java.lang.String.class),
			@Param(name = "modeType", comment = "模型类型", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "contentId", comment = "批次号", type = java.lang.String.class),
			@Param(name = "tradeDate", comment = "上传日期", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "上传到影像平台", style = "判断型", type = "同步组件", comment = "上传到影像平台", date = "2019-11-08 04:30:12")
	public static TCResult B_uploadToIas(Object urlList, String brno, String BUSI_START_DATE, String BUSI_SERIAL_NO,
			String modeType) {
		return TechComp.callWithBean(IasService.class, (iasService) -> {

			JavaDict param = new JavaDict();
			param.put("BrNo", brno);
			param.put("BUSI_START_DATE", BUSI_START_DATE);
			param.put("BUSI_SERIAL_NO", BUSI_SERIAL_NO);
			JavaList imageUrl = (JavaList) urlList;
			// 影像平台上传
			String contentID = iasService.upload(imageUrl, param, modeType);

			return new Object[] { contentID, BUSI_START_DATE };
		});
	}

	/**
	 * @category 影像平台查询
	 * @param request
	 *            入参|请求参数|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since response 出参|输出结果|{@link Object}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "request", comment = "请求参数", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "response", comment = "输出结果", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "影像平台查询", style = "判断型", type = "同步组件", comment = "影像平台查询", date = "2019-10-25 02:33:29")
	public static TCResult B_queryIas(JavaDict request) {
		return TechComp.callWithBean(IasService.class, (iasService) -> {

			JavaDict appBody = request.getDictItem("APPBody");

			String tradedate = appBody.getStringItem("tradedate");
			String contentid = appBody.getStringItem("contentid");
			String modelCodeString = appBody.getStringItem("modetype");
			String downflag = appBody.getStringItem("downflag");
			List<Map<String, String>> resList = iasService.query(tradedate, contentid, modelCodeString);
			JavaDict resDict = new JavaDict();
			resDict.put("file_list", resList);
			resDict.put("num", resList.size());
			resDict.put("filepath", "");
			// 影像下载
			if ("0".equals(downflag)) {
				resDict.put("filepath", (String) iasService.queryIasParam().get("downloadpath"));
				iasService.download(resList);
			}

			return new Object[] { resDict };
		});
	}

	/**
	 * @category 影像平台更新
	 * @param modeType
	 *            入参|模型类型|{@link java.lang.String}
	 * @param tradeDate
	 *            入参|上传日期|{@link java.lang.String}
	 * @param contentId
	 *            入参|影像批次号|{@link java.lang.String}
	 * @param serialno
	 *            入参|流水号|{@link java.lang.String}
	 * @param trandate
	 *            入参|交易日期|{@link java.lang.String}
	 * @param file_list
	 *            入参|影像文件列表|{@link java.util.ArrayList}
	 * @param request
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since contentid 出参|影像id|{@link java.lang.String}
	 * @since tradedate 出参|影像上传日期|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "modeType", comment = "模型类型", type = java.lang.String.class),
			@Param(name = "tradeDate", comment = "上传日期", type = java.lang.String.class),
			@Param(name = "contentId", comment = "影像批次号", type = java.lang.String.class),
			@Param(name = "serialno", comment = "流水号", type = java.lang.String.class),
			@Param(name = "trandate", comment = "交易日期", type = java.lang.String.class),
			@Param(name = "file_list", comment = "影像文件列表", type = java.util.ArrayList.class),
			@Param(name = "request", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "contentid", comment = "影像id", type = java.lang.String.class),
			@Param(name = "tradedate", comment = "影像上传日期", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "影像平台更新", style = "判断型", type = "同步组件", comment = "影像平台更新", date = "2019-11-12 03:40:02")
	public static TCResult B_IasUpdate(String modeType, String tradeDate, String contentId, String serialno,
			String trandate, ArrayList file_list, JavaDict request) {
		return TechComp.callWithBean(IasService.class, (iasService) -> {

			JavaDict csisHeader = request.getDictItem("CsisHeader");
			JavaDict appBody = request.getDictItem("APPBody");
			String brNo = csisHeader.getStringItem("BrNo");
			String optflag = appBody.getStringItem("optflag");
			iasService.update(tradeDate, contentId, modeType, trandate, serialno, brNo, optflag, file_list);
			return new Object[] { contentId, tradeDate };
		});
	}

	/**
	 * @category 影像高级查询
	 * @param serialno
	 *            入参|流水号|{@link java.lang.String}
	 * @param modetype
	 *            入参|影像模型|{@link java.lang.String}
	 * @param tradedate
	 *            入参|影像上传日期|{@link java.lang.String}
	 * @since contendId 出参|批次号|{@link java.lang.String}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = { @Param(name = "serialno", comment = "流水号", type = java.lang.String.class),
			@Param(name = "modetype", comment = "影像模型", type = java.lang.String.class),
			@Param(name = "tradedate", comment = "影像上传日期", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "contendId", comment = "批次号", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "影像高级查询", style = "判断型", type = "同步组件", comment = "影像高级查询", date = "2020-01-06 02:22:42")
	public static TCResult B_heightQuery(String serialno, String modetype, String tradedate) {
		return TechComp.callWithBean(IasService.class, (iasService) -> {
			String contendId = iasService.heightQueryExample(modetype, serialno , tradedate);
			return new Object[] { contendId };
		});
	}

}
