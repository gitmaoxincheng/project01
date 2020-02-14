package cn.com.agree.huanan.ap.al.csitrd.rcpt.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.al.csitrd.constant.IdType;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.dao.TradeBillImageInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.dao.TradeBillInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.dao.TradeBillSubInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.exception.InsertTradeBillFailException;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.exception.NoBillJsonDataException;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.exception.NoBillMakeException;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.exception.NoHandSignImageException;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.exception.UpdateTradeBillFailException;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillImageInfo;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillInfo;
import cn.com.agree.huanan.ap.rl.bank.base.dao.DictDao;
import cn.com.agree.huanan.ap.rl.bank.base.dao.SysParaDao;
import cn.com.agree.huanan.ap.rl.bank.base.po.Syspara;
import cn.com.agree.huanan.ap.rl.bank.file.service.TcService;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;



/**
 * 单据表服务层
 * @author WB
 *
 */
@Service
public class TradeBillInfoService {
	@Autowired
	private TradeBillInfoDao tradeBillDao;
	@Autowired
	private TradeBillSubInfoDao tradeBillSubDao;
	@Autowired
	private TradeBillImageInfoDao tradeBillImageDao;
	@Autowired
	private DictDao dictDao;
	@Autowired
	private SysParaDao sysParaDao;
	@Autowired
	DbOperator dbo;
	@Autowired
	TcService tcService;
	private final int oneLineSizePri=26-2;//对私模板首页出现最多的行数
	private final int oneLineSizePub=24-2;//对公模板首页出现最多的行数
	private  final int lineSize=44-2;//空白页出现最多的行数
	private  final String textSize="11";//文本数据字体大小(px)
	@Autowired
	Logger logger;
	//插入数据
		public void addTradeBillInfo(TradeBillInfo tradeBillInfo) {	
			logger.info("登记单据表开始");
			 int count=tradeBillDao.insertTradeBillInfo(tradeBillInfo);
			 if (count == 1) {
					dbo.commit();
					logger.info("登记到单据表开始结束");
				} else {
					dbo.rollback();
					logger.info("登记到单据表失败...事务回滚");
					throw new InsertTradeBillFailException("登记到单据登记表失败");
				}
		}
		//更新数据
		public void updateTradeBillInfo(Map<String,Object> map ) {
			logger.info("更新对单据表开始");		
			int count =tradeBillDao.updateTradeBillInfo(map);		
			if(count == 0) {
				dbo.rollback();
				logger.info("更新单据表失败!");
				throw new UpdateTradeBillFailException("更新到单据登记表失败");
			}
			dbo.commit();		
			logger.info("更新单据表结束");
		}
		public TradeBillInfo queryMainTradeBillInfoByBill(String bill) {
			return tradeBillDao.queryMainTradeBillInfoByBill(bill);
		}
		//1001合成无纸化数据合成需要的数据
		public Map<String,Object> getNoPaperMakeData(String bill) throws SQLException, IOException{
			//放总数据的map
			Map<String,Object> appBody = new HashMap<String,Object>();
			//获取所有交易类型
			int temp=0;
			//记录业务的顺序
			String[] orderArr=null;
			//获取单据数据
			TradeBillInfo billInfo=tradeBillDao.queryMainTradeBillInfoByBill(bill);
			Map<String,StringBuilder> billTypesM=new HashMap<>();
			//如果是原子服务
			Map<String,Object> name=dictDao.selectDict("rcpt");
			//获取单据字表数据
			StringBuilder sb=new StringBuilder();
			sb.append("[");
			List<Map<String, Object>> billSubs=tradeBillSubDao.queryTradeBillSubInfos(bill);
			if(billSubs!=null&&!billSubs.isEmpty()) {
				orderArr=new String[billSubs.size()];
				for(Map<String, Object>  billSub:billSubs) {
					//List billTypes=new ArrayList<>();
					//记录业务的顺序
					StringBuilder sbTemp=new StringBuilder();
					orderArr[temp]=(String) billSub.get("tranType");
					temp++;
					if(temp<10) {
						sbTemp.append("第"+temp+"笔：         "+"子流水号： "+(String) billSub.get("serialNo")+""+"       业务名称："+name.get((String) billSub.get("tranType"))+"\r\n");
					}else {
						sbTemp.append("第"+temp+"笔：       "+"子流水号： "+(String) billSub.get("serialNo")+""+"       业务名称："+name.get((String) billSub.get("tranType"))+"\r\n");
					}
					//billTypes.add(billSub.getTranType());
					billTypesM.put((String) billSub.get("tranType"), sbTemp);
					if("".equals((String) billSub.get("ielecData"))) {
						throw new NoBillJsonDataException("");
					}
					String tempString=(String) billSub.get("ielecData");
					sb.append(tempString.substring(1,tempString.length()-1));
					sb.append(",");
				}	
			}else {
				//如果交易全部失败,抛出无单据生成异常
				throw new NoBillMakeException("");
			}
			String billSubsData=sb.delete(sb.length()-1, sb.length()).append("]").toString();
			logger.info("单据子表的数据为："+billSubsData);
			//对公对私判断
			boolean toPrivate=true;
			//图片是否为二页
			boolean isDouble=false;
			//单据首页默认私有文字排版
			String yPositon="420";
			//获取单据图片数据
			List<Map<String,Object>> billImages=tradeBillImageDao.selectBillImageInfosDate(bill);
			//billJson的拼装
			String billData="";
			String billPublicData=billInfo.getIelecData().replaceAll("\r|\\s|\n", "");
			logger.info("单据主表的json字符数组为："+billPublicData);
			Map<String,Object> billMap=JSON.parseObject(billPublicData);
			//将单据子表数据数据转化为list
			List<Map<String,Object>> textJ=(List<Map<String, Object>>) JSONArray.parse(billSubsData);
			//清空sb的内容
			sb.delete(0, sb.length());
			//提前进行图片数据的拼装
			//图片数据的取出
			List<Map<String,Object>> imageL = new ArrayList<Map<String,Object>>();
			Map<String,Object> imageM = new HashMap<String,Object>();
			if(billImages!=null) {
				//获取渠道代码
				String chnlcode=billInfo.getScrCalCod();
				String date=(String) billImages.get(0).get("upddate");
				//如果不是当天的图片，重新上传图片到无纸化
				if(!date.equals(DateTimeUtil.getSysDate()))
					tcFile("TC_P_NODE_01","TC_S_NODE_003","TC_FILE_DIR_005", billImages, chnlcode);
				for(Map<String,Object> map:billImages) {
					if(!"05".equals(map.get("imagetype"))) {
						sb.append(map.get("imagepath"));
						sb.append(",");	
					}
				}
				if(sb.length()!=0) {	
					sb.substring(sb.length()-1);
					String billImageData=sb.toString();
					String [] billImageArr=billImageData.split(",");
					if(billImageArr.length>6)
						isDouble=true;
					appBody.put("PicAmount", billImageArr.length);
					int width=200;
					int height=200;
					int xExtra=50;
					int yExtra=30;
					int x1=50;
					int x2=x1+width+xExtra;
					int y3=520;
					int y2=y3-height-yExtra;
					int y1=y2-height-yExtra;
					int one=0;
					int two=0;
					int three=0;
					String y;
					for (int j = 0; j < billImageArr.length; j++) {
						Map<String,Object> img = new HashMap<String,Object>();
						img.put("ImagePath", billImageArr[j]);
						img.put("Keyword", "");
						img.put("locationStyle", "");
						img.put("TemplateIndex", 1);
						img.put("type", "2");
						img.put("offsetX", "");
						img.put("offsetY", "");
						img.put("ImageWidth", "200");
						img.put("ImageHeight", "200");
						img.put("PageNo", "1");
						//重置次数
						if(j>6){
							img.put("TemplateIndex", 2);
						}else if(j==6){
							one=0;
							two=0;
							three=0;
							img.put("TemplateIndex", 2);
						}
						if((j & 1) == 0){
							one++;
							if(one==1){
								y=new String(String.valueOf(y3));				
							}else if(one==2){
								y=new String(String.valueOf(y2));
							}else{
								y=new String(String.valueOf(y1));
							}
							System.out.println(y);
							img.put("LY", y);
							img.put("LX", x1);
						}else{
							two++;
							if(two==1){
								y=new String(String.valueOf(y3));				
							}else if(two==2){
								y=new String(String.valueOf(y2));
							}else{
								y=new String(String.valueOf(y1));
							}
							System.out.println(y);
							img.put("LY", y);
							img.put("LX", x2);
						}
						imageL.add(img);
					}
				}
			}		
			imageM.put("Image", imageL);
			//ImageList.add(imageM);
			appBody.put("ImageList", imageM);
			//清空sb的内容
			sb.delete(0, sb.length());
			//拼装动态数据
			List<Map<String,Object>> fieldL = new ArrayList<Map<String,Object>>();
			Map<String,Object> fieldM = new HashMap<String,Object>();
			String fieldValue;
			if(billMap.containsKey("agentname"))
				toPrivate=false;
			//前置流水单据号的赋值,取报文里面的billno字段
			appBody.put("ChannelSerialNo", billMap.get("billno"));
			//公共数据的拼装
			for(Map.Entry<String, Object> entry:billMap.entrySet()) {
				String key=entry.getKey();
				fieldValue=(String)entry.getValue();
				if("idtype".equals(key))
					fieldValue=IdType.map(fieldValue);
				//过滤文本域空字段
				if(fieldValue!=null && !"".equals(fieldValue)) {
					//文本域方式
					Map<String,Object> field = new HashMap<String,Object>();
					field.put("FieldId", key);
					field.put("FieldValue", fieldValue);	
					field.put("FieldType", "text");
					field.put("TemplateIndex", "0");
					fieldL.add(field);
				}
			}
			//具体交易内容的拼装
			for(Map<String,Object> map:textJ) {
				String type=(String) map.get("type");
				if(billTypesM.containsKey(type)){
					//动态信息
					sb.append(map.get("key")+":"+map.get("val")+"\r\n");
					//根据类型进行业务内容文字归类
					logger.info(sb.toString());
					billTypesM.put(type, billTypesM.get(type).append(sb.toString()));
					sb.delete(0, sb.length());
				}
			}
			int oneLineSize;
			if(toPrivate) {
				oneLineSize=oneLineSizePri;
			}else {
				oneLineSize=oneLineSizePub;
				yPositon="380";
			}
			//默认为一页
			int wordPage=1;
			//文本数据方式
			List<Map<String,Object>> textL= new ArrayList<Map<String,Object>>();
			Map<String,Object> textM = new HashMap<String,Object>();
			//更新字表的map
			Map map=new HashMap<String, Object>();
			map.put("bill",bill);
			//进行动态数据的连接
			if(orderArr!=null){
				for(int i=0;i<orderArr.length;i++) {
					sb.append(billTypesM.get(orderArr[i]).toString());
					//进行单据字表的更新
					String remarks=billTypesM.get(orderArr[i]).toString();
					map.put("tranType", orderArr[i]);
					map.put("remarks",remarks.substring(remarks.indexOf("\n")+1));
					tradeBillSubDao.updateTradeBillSubInfo(map);
				}
				String originDynamic=sb.toString();
				sb.delete(0, sb.length());
				logger.info("动态数据的原始拼装结果为："+originDynamic);
				//进行页数的判断
				int repeat=findRepeatTimes(originDynamic, "\n");
				logger.info("repeat的值为："+repeat);
				//第一页业务数据的情况(图片放在首页)
				int truePosition;
				if(repeat<oneLineSize) { 
					truePosition=repeat;
				}else {
					truePosition=oneLineSize;	
					//多页的情况,结果为0就是1,结果加1就对了再算上第一页的数据
					wordPage=(repeat-oneLineSize)/lineSize+2;
				}
				logger.info("wordPaged的值为："+wordPage);
				int start=0;
				int end;
				for(int i=0;i<wordPage;i++) {
					if(i==0) {
						end=getRepeatPositon(originDynamic, '\n', truePosition);
					}else if(i==wordPage-1) {
						//如果是最后一页的情况下
						end=originDynamic.length()-1;
					}else {		
						end=getRepeatPositon(originDynamic, '\n', oneLineSize+lineSize*i);
					}
					Map<String,Object> text1 = new HashMap<String,Object>();
					text1.put("textValue", originDynamic.substring(start,end)+"\n\r\n共办理业务"+temp+"笔；第"+(i+1)+"页，共"+wordPage+"页");
					logger.info(text1.get("TextValue")+"");
					start=end+1;
					text1.put("textFontSize",textSize);
					text1.put("textColor","000000");
					text1.put("spacingHeight","14");
					text1.put("type","2");
					text1.put("pageNo","1");
					text1.put("lx","90" );
					if(i==0)
						text1.put("ly",yPositon);
					else
						text1.put("ly","670");
					if(isDouble) 
					    text1.put("templateIndex",(i+3)+"");
					else
						text1.put("templateIndex",(i+2)+"");
					textL.add(text1);
				}
			}
			textM.put("text", textL);
			appBody.put("textList", textM);
			fieldM.put("Field", fieldL);
			appBody.put("FieldList", fieldM);
			appBody.put("SavePdfMethod","0");
			//模板号添加
			String sceneImage="";
			String privateTemp="";
			String blankTemp="";
			String publicTemp="";
			List<Syspara> paras=sysParaDao.queryByItem("000017");
			for(Syspara para:paras) {
				if(para.getParaCode().equals("01"))
					sceneImage = para.getParaValue1();
				else if(para.getParaCode().equals("02"))
					blankTemp = para.getParaValue1();
				else if(para.getParaCode().equals("03"))
					privateTemp= para.getParaValue1();
				else 
					publicTemp= para.getParaValue1();
			}
			if(isDouble)
				sb.append(sceneImage+","+sceneImage+",");
			else
				sb.append(sceneImage+",");
			//对公对私模板选择
			if(toPrivate) {	
				sb.append(privateTemp+",");
			}else {
				sb.append(publicTemp+",");
			}
			if(wordPage>1){
				for(int i=0;i<wordPage-1;i++) {
					sb.append(blankTemp+",");
				}
			}
			String TemplateCode=sb.toString().substring(0,sb.length()-1);
			appBody.put("TemplateCode", TemplateCode);
			return appBody;
		}
		//1002合成无纸化电子签名需要的数据
		public Map<String,Object> getNoPaperSignData(String bill) throws SQLException, IOException{
			//放总数据的map
			Map<String,Object> appBody = new HashMap<String,Object>();
			List<Map<String,Object>> proofFileL = new ArrayList<Map<String,Object>>();
			Map<String,Object> proofFileM = new HashMap<String,Object>();
			List<Map<String,Object>> proofSealStrategyL = new ArrayList<Map<String,Object>>();
			Map<String,Object> proofSealStrategyM = new HashMap<String,Object>();
			List<Map<String,Object>> sealL = new ArrayList<Map<String,Object>>();
			Map<String,Object> sealM = new HashMap<String,Object>();
			List<Map<String,Object>> locationL = new ArrayList<Map<String,Object>>();
			Map<String,Object> location = new HashMap<String,Object>();
			//获取手写签名图片
			TradeBillImageInfo billImage=tradeBillImageDao.queryTradeBillImageInfoByType(bill, "05");
			//场景证据文件信息,如果不存在，抛出手写签名不存在异常
			if(billImage!=null) {
				Map<String,Object> proofFile= new HashMap<String,Object>();
				proofFile.put("FilePath", billImage.getImagePath());
				proofFile.put("Type", "0");
				proofFileL.add(proofFile);
				proofFileM.put("ProofFile", proofFileL);
				appBody.put("ProofFileList",proofFileM);
				//场景签章策略文件
				Map<String,Object> proofSealStrategy = new HashMap<String,Object>();
				proofSealStrategy.put("HandwritingImage",billImage.getImagePath());
	            //获取证件类型和证件号
				//获取单据数据
				TradeBillInfo billInfo=tradeBillDao.queryMainTradeBillInfoByBill(bill);
				String IdentificationNo="";
				String IdentificationType="";
				if(billInfo!=null) {
					String billData=billInfo.getIelecData().replaceAll("\r|\\s|\n", "");
					logger.info("单据表的json字符数组为："+billData);
					//将单据数据转化为map
					Map<String,Object> billMap=JSON.parseObject(billData);
					//拼装动态数据
					IdentificationType=(String) billMap.get("idtype");
					IdentificationNo=(String) billMap.get("idcode");
					List<Map<String,Object>> fieldL = new ArrayList<Map<String,Object>>();
					Map<String,Object> fieldM = new HashMap<String,Object>();
				}
				proofSealStrategy.put("IdentificationType",IdentificationType);
				proofSealStrategy.put("IdentificationNo",IdentificationNo);
				location.put("Keyword", "客户签名");
				locationL.add(location);
				proofSealStrategy.put("LocationList",locationL);
				proofSealStrategyL.add(proofSealStrategy);
				proofSealStrategyM.put("ProofSeal", proofSealStrategyL);
				appBody.put("ProofSealStrategy", proofSealStrategyM);
			}else
				throw new NoHandSignImageException("");
			//普通签章策略文件
			Map<String,Object> seal = new HashMap<String,Object>();
			seal.put("SealCode", "9900");
			seal.put("SealPassword", "cfca1234");
			seal.put("businessCode", "");
			seal.put("businessCodeStyle", "");
			locationL = new ArrayList<Map<String,Object>>();
			location=new HashMap<String, Object>();
			location.put("Keyword", "电子印章");
			locationL.add(location);
			seal.put("LocationList",locationL);
			sealL.add(seal);
			sealM.put("Seal", sealL);
			appBody.put("SealStrategy", sealM);
			appBody.put("PdfFile", bill);
			appBody.put("ChannelSerialNo", bill);
			appBody.put("OperatorTy", "0");
			return appBody;
		}
		//单据补扫描数据
		public Map<String,Object> getRcptMissPictureData(List list){
			//放总数据的map
			Map<String,Object> appBody = new HashMap<String,Object>();
			List<Map<String,Object>> imageL = new ArrayList<Map<String,Object>>();
			Map<String,Object> imageM = new HashMap<String,Object>();
			//图片处理（别人代码)	
			appBody.put("PicAmount", list.size());
			for (int j = 0; j < list.size(); j++) {
				Map<String,Object> img = new HashMap<String,Object>();
				img.put("ImagePath", ((Map)list.get(j)).get("imagepath"));
				img.put("Keyword", "");
				img.put("locationStyle", "");
				img.put("TemplateIndex", String.valueOf(j+1));
				img.put("type", "2");
				img.put("offsetX", "");
				img.put("offsetY", "");
				img.put("ImageWidth", "500");
				img.put("ImageHeight", "500");
				img.put("PageNo", "1");
				img.put("LX", "45");
				img.put("LY", "250");
				imageL.add(img);
				}
			imageM.put("Image", imageL);
			appBody.put("ImageList", imageM);
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<list.size();i++) {
				sb.append("sceneImage,");
			}
			String TemplateCode=sb.toString().substring(0,sb.length()-1);
			appBody.put("TemplateCode", TemplateCode);
			appBody.put("SavePdfMethod","1");
			List<Map<String,Object>> textL= new ArrayList<Map<String,Object>>();
			Map<String,Object> textM = new HashMap<String,Object>();
			Map<String,Object> fieldM = new HashMap<String,Object>();
			textM.put("text", textL);
			appBody.put("textList", textM);
			fieldM.put("Field", textL);
			appBody.put("FieldList", fieldM);
			return appBody;
		}
		/**
		 * 计算某个字符在字符串重复出现的位置
		 * @param s 字符串
		 * @param c 字符
		 * @return 次数
		 */
		public int findRepeatTimes(String s,String c){
			Pattern p=Pattern.compile(c);
			Matcher m=p.matcher(s);
			int count=0;
			while(m.find())
				count++;
			return count;
		}
		/**
		 * 计算某个字符在字符串中第一次出现的位置
		 * @param s 字符串
		 * @param c 字符
		 * @param times  第几次
		 * @return 
		 */
		public int getRepeatPositon(String s,char c,int times){
			char[] array=s.toCharArray();
			for(int i=0;i<array.length;i++){
				if(array[i]==c&&--times==0)
					return i;
			}
			return -1;
		}
		
		/**
		 * 根据条件查询单据数据
		 * @param map
		 * @return
		 * @throws IOException 
		 * @throws SQLException 
		 */
		public Map<String, Object> getTradeBillInfoList(Map<String, String> map) throws SQLException, IOException{
			//参数校验
			if(StringUtils.isEmpty(map.get("begdate"))) {
				throw new ApIllegalParamException("begdate");
			}
			if(StringUtils.isEmpty(map.get("endate"))) {
				throw new ApIllegalParamException("endate");
			}
			if(Integer.valueOf(map.get("pageflag")) < 1) {
				logger.error("每页查询记录数不可小于1");
				throw new ApIllegalParamException("pageflag");
			}
			if(Integer.valueOf(map.get("maxnum")) < 1) {
				logger.error("每页最多记录数");
				throw new ApIllegalParamException("maxnum");
			}
			//查询单据主表数据
			HashMap<String, Object> billMap = tradeBillDao.selectTradeBillInfo(map);
			List<HashMap<String, Object>> billList = (List<HashMap<String, Object>>) billMap.get("bill_list");	//获取主表数据信息列表
			for (HashMap<String, Object> billInfoMap : billList) {	//获取单据号，根据单据号查询子表和图片表
				String bill = (String) billInfoMap.get("bill");
				//查询单据子表数据
				List<Map<String, Object>> billSubList = tradeBillSubDao.selectBillSubInfo(bill);
				//查询单据图片表数据
				List<Map<String, Object>> billImageList = tradeBillImageDao.selectBillImageInfo(bill);
				billInfoMap.put("subbill_list", billSubList);
				billInfoMap.put("imagelist", billImageList);
				String status=(String) billInfoMap.get("status");
				//对主单据状态结果做映射 数据库的定义 01	无单据 02	数据准备 03	合成成功 04	合成失败 05	签章成功 06	签章失败
				//文档状态 01-成功 02-失败  03-无单据
				if(status.equals("05")) {
					billInfoMap.put("billstatus","01");
				}else if(status.equals("01")){
					billInfoMap.put("billstatus","03");
				}else {
					billInfoMap.put("billstatus","02");
				}
				billInfoMap.remove("status");
				String tranname="";
				if(billSubList!=null && !billSubList.isEmpty()) {
					tranname=(String) billSubList.get(0).get("subtranname");
				}
				billInfoMap.put("tranname", tranname);
			}
			return 	billMap;
		}
		public Map<String, Object> getTradeBillInfoDetail(String bill) throws SQLException, IOException{
			HashMap<String, Object> billMap =new HashMap<String,Object>();
				TradeBillInfo billInfo=tradeBillDao.queryMainTradeBillInfoByBill(bill);
				if(billInfo!=null) {
					String BillJson=billInfo.getIelecData();
					if(!BillJson.equals("")) {
						Map<String,Object> textJ=JSON.parseObject(BillJson);	
						billMap.put("bill",textJ);
					}else {
						billMap.put("bill","");
					}
				}else {
					billMap.put("bill","");
				}
			//查询单据子表数据
			List<Map<String, Object>> billSubList = tradeBillSubDao.selectBillSubInfoDetail(bill);
			//查询单据图片表数据
			List<Map<String, Object>> billImageList = tradeBillImageDao.selectBillImageInfo(bill);
			billMap.put("subbill_list", billSubList);
			billMap.put("imagelist", billImageList);
			return 	billMap;
		}
		/**
		 * 
		 * @param pNodeCode 主节点标识码
		 * @param sNodeCode 次节点标识码
		 * @param sFileDirCode 次节点文件目录标识码
		 * @param file 文件
		 */
		//非当日单据图片传送到无纸化
		public void tcFile(String pNodeCode, String sNodeCode,String sFileDirCode,List<Map<String,Object>> file,String chnlcode) {
			JavaDict fileMap=new JavaDict();
			//主节点文件目录标识码
			String pFileDirCode="";
			for (int i = 0; i < file.size(); i++) {
				String imagePath = (String) ((Map) file.get(i)).get("imagepath");
				String imageType = (String) ((Map) file.get(i)).get("imagetype");
				String value;
				String date = DateTimeUtil.getSysDate();
				if (imageType.equals("05")) {
					value = chnlcode + "/tempproof/" + date + "/" + imagePath;
				} else {
					value = chnlcode + "/temppicture/" + date + "/" + imagePath;
				}
				fileMap.put(imagePath, value);
			}
			String tcNode;
			if (chnlcode.equals("STM")) {
				pFileDirCode = "TC_FILE_DIR_001";
			} else {
				pFileDirCode = "TC_FILE_DIR_002";
			}
			for (Object srcFile : fileMap.keySet()) {
				tcService.putFile(pNodeCode, sNodeCode, pFileDirCode, sFileDirCode, (String) srcFile, (String) fileMap.get(srcFile));
			}
		}
}
