package cn.com.agree.huanan.ap.tl.util;

/**
 * @author HCP
 * 2019/8/4
 */
public class RegxTest {
    public static void main(String[] args) {
        String str = "2017*11-27 11:03:26";
        Long longStr =new Long(str.replaceAll("[^\\d]+", ""));
        System.out.println("字符串=========：" + longStr);

        String str2 = "/Response/Ctrl////";
        String[] strArray = str2.split("/");
        System.out.println(strArray.length);
        for (int i=0;i<strArray.length;i++)
            System.out.println(strArray[i]);
    }
}
