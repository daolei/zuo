package champter1;

import java.io.*;
import java.util.HashMap;

/**
 * Created by daolei.su on 2018/10/31
 */
public class test {
    public static void main(String[] args) throws IOException {
        String a="pitaMozilla%2f5.0%20(Macintosh%3b%20Intel%20Mac%20OS%20X%2010_14_0)%20AppleWebKit%2f537.36%20(KHTML%2c%20like%20Gecko)%20Chrome%2f69.0.3497.100%20Safari%2f537.36spital";
        a="ibotMozilla%2f5.0%20(Macintosh%3b%20Intel%20Mac%20OS%20X%2010_14_0)%20AppleWebKit%2f537.36%20(KHTML%2c%20like%20Gecko)%20Chrome%2f69.0.3497.100%20Safari%2f537.36ibotta";
        a="curlingsMozilla%2f5.0%20(Macintosh%3b%20Intel%20Mac%20OS%20X%2010_14_0)%20AppleWebKit%2f537.36%20(KHTML%2c%20like%20Gecko)%20Chrome%2f69.0.3497.100%20Safari%2f537.36";
        System.out.println(a);
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/sudaolei/IdeaProjects/MRC/mrcetl/uaBlackList.csv")));
        HashMap<String,String[]> uaBlackList = new HashMap<String, String[]>();
        String line;
        while ((line =  bf.readLine()) !=null){
            String[] items = line.split(",");
            if (items.length >= 1) {
                String[] valueTemp = new String[items.length-1];
                String keyTemp = items[0].trim();
                for (int i = 1;i < items.length;i++){
                    valueTemp[i-1] = items[i].trim().toLowerCase();
                }
                uaBlackList.put(keyTemp, valueTemp);
            }
        }
        System.out.println(uaBlackList.get("pita")[0]);
        checkUa(a,uaBlackList);
      //  System.out.println(uaBlackList);
    }

    public static void checkUa(String ua, HashMap<String, String[]> uaBlackList)  {
        if (ua == null) {
            return;
        }
        try {
            ua = recursionDecode(ua).toLowerCase();
            for (String blackUa : uaBlackList.keySet()) {
                if(blackUa.equals("pita")){
                    System.out.println("hehe");
                }
                if (ua.contains(blackUa)) {
                    String[] uaWhiteList = uaBlackList.get(blackUa);
                    for (int i = 0; i < uaWhiteList.length; i++) {
                        if (ua.contains(uaWhiteList[i])) {
                            return;
                        }
                    }
                    System.out.println("error");

                }
            }
        } catch (UnsupportedEncodingException e) {
            return;
        } catch (IllegalArgumentException e) {
            //SysOutLogger.error(String.format("url decode error, key: %s, value: %s", "ua", ua));
            return;
        }

    //    System.out.println();

    }

    public static String recursionDecode(String value) throws UnsupportedEncodingException {
        String CODESET = "utf-8";
        String tmp;
        boolean changed = false;
        while (!(tmp = java.net.URLDecoder.decode(value, CODESET)).equals(value)) {
            value = tmp;
            changed = true;
        }
        return changed ? value : null;
    }
}
