package tc.bank.file.topconnect;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.file.service.TcService;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * @date 2019-10-21 14:46:6
 */
@ComponentGroup(level = "银行", groupName = "TC文件传输")
public class B_TcUtil {

	/**
	 * @category TC拉取文件
	 * @param pNodeCode 入参|主节点标识码|{@link java.lang.String}
	 * @param sNodeCode 入参|次节点标识码|{@link java.lang.String}
	 * @param pFileDirCode 入参|主节点文件目录标识码|{@link java.lang.String}
	 * @param sFileDirCode 入参|次节点文件目录标识码|{@link java.lang.String}
	 * @param srcFile 入参|源文件名称|{@link java.lang.String}
	 * @param desFile 入参|目标文件名称|{@link java.lang.String}
	 * @return 0 失败<br>1 成功<br>
	 */
	@InParams(param = { @Param(name = "pNodeCode", comment = "主节点标识码", type = java.lang.String.class),
			@Param(name = "sNodeCode", comment = "次节点标识码", type = java.lang.String.class),
			@Param(name = "pFileDirCode", comment = "主节点文件目录标识码", type = java.lang.String.class),
			@Param(name = "sFileDirCode", comment = "次节点文件目录标识码", type = java.lang.String.class),
			@Param(name = "srcFile", comment = "源文件名称", type = java.lang.String.class),
			@Param(name = "desFile", comment = "目标文件名称", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "TC拉取文件", style = "判断型", type = "同步组件", date = "2019-10-31 11:03:39")
	public static TCResult B_getFile(String pNodeCode, String sNodeCode, String pFileDirCode, String sFileDirCode, String srcFile, String desFile) {
		return TechComp.callWithBean(TcService.class, (tcService) -> {
			tcService.getFile(pNodeCode, sNodeCode, pFileDirCode, sFileDirCode, srcFile, desFile);
			return null;
		});
	}

	/**
	 * @category TC推送文件
	 * @param pNodeCode 入参|主节点名称|{@link java.lang.String}
	 * @param sNodeCode 入参|次节点名称|{@link java.lang.String}
	 * @param pFileDirCode 入参|主节点文件目录标识码|{@link java.lang.String}
	 * @param sFileDirCode 入参|次节点文件目录标识码|{@link java.lang.String}
	 * @param srcFile 入参|源文件名称|{@link java.lang.String}
	 * @param desFile 入参|目标文件名称|{@link java.lang.String}
	 * @return 0 失败<br>1 成功<br>
	 */
	@InParams(param = { @Param(name = "pNodeCode", comment = "主节点名称", type = java.lang.String.class),
			@Param(name = "sNodeCode", comment = "次节点名称", type = java.lang.String.class),
			@Param(name = "pFileDirCode", comment = "主节点文件目录标识码", type = java.lang.String.class),
			@Param(name = "sFileDirCode", comment = "次节点文件目录标识码", type = java.lang.String.class),
			@Param(name = "srcFile", comment = "源文件名称", type = java.lang.String.class),
			@Param(name = "desFile", comment = "目标文件名称", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "TC推送文件", style = "判断型", type = "同步组件", date = "2019-10-31 11:05:02")
	public static TCResult B_putFile(String pNodeCode, String sNodeCode, String pFileDirCode, String sFileDirCode, String srcFile, String desFile) {
		return TechComp.callWithBean(TcService.class, (tcService) -> {
			tcService.putFile(pNodeCode, sNodeCode, pFileDirCode, sFileDirCode, srcFile, desFile);
			return null;
		});
	}

	/**
	 * @category TC拉取多个文件
	 * @param pNodeCode 入参|主节点名称|{@link java.lang.String}
	 * @param sNodeCode 入参|次节点名称|{@link java.lang.String}
	 * @param pFileDirCode 入参|主节点文件目录标识码|{@link java.lang.String}
	 * @param sFileDirCode 入参|次节点文件目录标识码|{@link java.lang.String}
	 * @param fileMap 入参|文件名称集合|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>1 成功<br>
	 */
	@InParams(param = { @Param(name = "pNodeCode", comment = "主节点名称", type = java.lang.String.class),
			@Param(name = "sNodeCode", comment = "次节点名称", type = java.lang.String.class),
			@Param(name = "pFileDirCode", comment = "主节点文件目录标识码", type = java.lang.String.class),
			@Param(name = "sFileDirCode", comment = "次节点文件目录标识码", type = java.lang.String.class),
			@Param(name = "fileMap", comment = "文件名称集合", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "TC拉取多个文件", style = "判断型", type = "同步组件", comment = "其中fileMap的key为srcFile,value为desFile", date = "2019-10-31 11:07:04")
	public static TCResult B_getMultiFile(String pNodeCode, String sNodeCode, String pFileDirCode, String sFileDirCode, JavaDict fileMap) {
		return TechComp.callWithBean(TcService.class, (tcService) -> {
			tcService.getMultiFile(pNodeCode, sNodeCode, pFileDirCode, sFileDirCode, fileMap);
			return null;
		});
	}

	/**
	 * @category TC推送多个文件
	 * @param pNodeCode 入参|主节点标识码|{@link java.lang.String}
	 * @param sNodeCode 入参|次节点标识码|{@link java.lang.String}
	 * @param pFileDirCode 入参|主节点文件目录标识码|{@link java.lang.String}
	 * @param sFileDirCode 入参|次节点文件目录标识码|{@link java.lang.String}
	 * @param fileMap 入参|文件名称集合|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>1 成功<br>
	 */
	@InParams(param = { @Param(name = "pNodeCode", comment = "主节点标识码", type = java.lang.String.class),
			@Param(name = "sNodeCode", comment = "次节点标识码", type = java.lang.String.class),
			@Param(name = "pFileDirCode", comment = "主节点文件目录标识码", type = java.lang.String.class),
			@Param(name = "sFileDirCode", comment = "次节点文件目录标识码", type = java.lang.String.class),
			@Param(name = "fileMap", comment = "文件名称集合", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "TC推送多个文件", style = "判断型", type = "同步组件", comment = "其中fileMap的key为srcFile,value为desFile", date = "2019-10-31 11:07:56")
	public static TCResult B_putMultiFile(String pNodeCode, String sNodeCode, String pFileDirCode, String sFileDirCode, JavaDict fileMap) {
		return TechComp.callWithBean(TcService.class, (tcService) -> {
			tcService.putMultiFile(pNodeCode, sNodeCode, pFileDirCode, sFileDirCode, fileMap);
			return null;
		});
	}

}
