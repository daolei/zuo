package champter1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by daolei.su on 2018/11/23
 */
public class test1 {
    public static void main(String[] args) throws IOException {
        String line;
        BufferedReader bf = new BufferedReader(new FileReader("/Users/sudaolei/PycharmProjects/untitled2/UablackList.csv"));
        HashMap<String,String[]> uaBlackList = new HashMap<String, String[]>();
        while ((line = bf.readLine())!=null){
            //System.out.println(line);
            String[] items = line.split(",");


            if (items.length >= 1) {
                String[] valueTemp = new String[items.length - 1];
                String keyTemp = items[0].trim().toLowerCase();
                if (keyTemp.contains("google")){
                    System.out.println(line);
                }
                for (int i = 1; i < items.length; i++) {
                    valueTemp[i - 1] = items[i].trim().toLowerCase();
                }
                uaBlackList.put(keyTemp, valueTemp);
            }
        }

        //System.out.println(uaBlackList.get("python-urllib")[0]);
    }
}
