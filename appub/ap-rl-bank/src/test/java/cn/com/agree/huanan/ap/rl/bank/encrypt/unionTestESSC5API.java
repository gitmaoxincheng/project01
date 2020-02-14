package cn.com.agree.huanan.ap.rl.bank.encrypt;

import java.util.ArrayList;
import java.util.List;

import com.union.api.TUnionTransInfo;
import com.union.api.UnionEsscAPI;

public class unionTestESSC5API {
	public static void main(String[] args) throws Exception {
		List<String> ipList = null;
		List<Integer> portList = null;
		int timeOut ; 
		UnionEsscAPI esscApi  = null;
		TUnionTransInfo transInfo = null;
		//���Ӳ���
		ipList = new ArrayList<String>();
		portList = new ArrayList<Integer>();
		ipList.add(0, "10.10.10.200");//IP,�������ɷֱ�����б�
		portList.add(0, 27102);//�˿�
		ipList.add(1, "10.10.10.202");//IP,�ɶ��
		portList.add(1, 27102);//�˿�
		timeOut = 5;
		//Ӧ�ò��� 
		String appid = "10";  //Ӧ��ID
 		String sysid = "10";  //ϵͳID
		//��ʼ��
		esscApi = new UnionEsscAPI(ipList,portList, timeOut, sysid, appid,10);
		//
		String idOfAtm="99999998";
		
		try {
			//String PinByZPK;
/****** GenerateAtmTMK ********/
            System.out.println(".........GenerateAtmTMK......"); 
            transInfo = esscApi.GenerateAtmTMK(
            	idOfAtm   //�ն˺�
            );
            if (transInfo.getIsSuccess() == 1)
            {
                System.out.println("������Կ����:"+transInfo.getReturnBody().getKeyValue()); 
                System.out.println("����У��ֵ:"+transInfo.getReturnBody().getCheckValue()); 
            }	
            else
            {
                System.out.println("����GenerateAtmTMKʧ�ܣ�");  //������Ϣ
                System.out.println("������Ϣ��"+transInfo.getResponseRemark());  //������Ϣ
                System.out.println("�����룺"+transInfo.getResponseCode());   //������
                System.out.println("������־��"+transInfo.getLog());
            };
            /****** GenerateAtmTPK ********/
            System.out.println(".........GenerateAtmTPK......"); 
            transInfo = esscApi.GenerateAtmTPK(
            	idOfAtm   //�ն˺�
            );
            if (transInfo.getIsSuccess() == 1)
            {
                System.out.println("������Կ����:"+transInfo.getReturnBody().getKeyValue()); 
                System.out.println("����У��ֵ:"+transInfo.getReturnBody().getCheckValue()); 
            }	
            else
            {
                System.out.println("����GenerateAtmTPKʧ�ܣ�");  //������Ϣ
                System.out.println("������Ϣ��"+transInfo.getResponseRemark());  //������Ϣ
                System.out.println("�����룺"+transInfo.getResponseCode());   //������
                System.out.println("������־��"+transInfo.getLog());
            };
            /****** GenerateAtmTAK ********/
            System.out.println(".........GenerateAtmTAK......"); 
            transInfo = esscApi.GenerateAtmTAK(
            	idOfAtm   //�ն˺�
            );
            if (transInfo.getIsSuccess() == 1)
            {
                System.out.println("������Կ����:"+transInfo.getReturnBody().getKeyValue()); 
                System.out.println("����У��ֵ:"+transInfo.getReturnBody().getCheckValue()); 
            }	
            else
            {
                System.out.println("����GenerateAtmTAKʧ�ܣ�");  //������Ϣ
                System.out.println("������Ϣ��"+transInfo.getResponseRemark());  //������Ϣ
                System.out.println("�����룺"+transInfo.getResponseCode());   //������
                System.out.println("������־��"+transInfo.getLog());
            };
            //
            String data="dafkjfdkaljfdlkajfdlkajfdklajsfdlkajcz";
            String mac="";
            /****** GenerateAtmMAC ********/
            System.out.println(".........GenerateAtmMAC......"); 
            transInfo = esscApi.GenerateAtmMAC(
                idOfAtm,   //�ն˺�
                data      //����
            );
            if (transInfo.getIsSuccess() == 1)
            {
                System.out.println("����У��ֵ:"+transInfo.getReturnBody().getMac()); 
                mac = transInfo.getReturnBody().getMac();
            }	
            else
            {
                System.out.println("����GenerateAtmMACʧ�ܣ�");  //������Ϣ
                System.out.println("������Ϣ��"+transInfo.getResponseRemark());  //������Ϣ
                System.out.println("�����룺"+transInfo.getResponseCode());   //������
                System.out.println("������־��"+transInfo.getLog());
            };
            /****** VerifyAtmMAC ********/
            System.out.println(".........VerifyAtmMAC......"); 
            transInfo = esscApi.VerifyAtmMAC(
                idOfAtm,   //�ն˺�
                data,      //����
                mac       //У��ֵ
            );
            if (transInfo.getIsSuccess() == 1)
            {
                System.out.println("У��ֵһ��"); 
             }	
            else
            {
                
            	System.out.println("����VerifyAtmMACʧ�ܣ�");  //������Ϣ
                System.out.println("������Ϣ��"+transInfo.getResponseRemark());  //������Ϣ
                System.out.println("�����룺"+transInfo.getResponseCode());   //������
                System.out.println("������־��"+transInfo.getLog());
            };
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
