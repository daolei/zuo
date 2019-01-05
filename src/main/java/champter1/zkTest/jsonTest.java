package champter1.zkTest;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by daolei.su on 2018/11/30
 */
public class jsonTest {

    /**
     * 在使用该类转json时，发现默认情况下 json文件中可以少key，但是不能多key
     * @param args
     */

    public static void main(String[] args) {
        String a = "fdsaf";
        System.out.println(String.format("fdsfasf%s", "aa"));
        ObjectMapper mapper = new ObjectMapper();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("/Users/sudaolei/IdeaProjects/MRC/zuo/tmp/a.json"));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = bf.readLine()) != null) {
               content.append(line.trim());
            }
            a a1 = mapper.readValue(content.toString(), a.class);
            System.out.println(a1.getC());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
