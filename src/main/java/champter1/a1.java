package champter1;

import java.io.*;

/**
 * Created by daolei.su on 2018/11/21
 */
public class a1 {
    public static void main(String[] args) throws IOException {
        System.out.println("101029207\t Accuen".split("\t")[1]);
 //       BufferedReader fs = new BufferedReader(new FileReader("/Users/sudaolei/IdeaProjects/java/etl/target/ual"));
        String line;
 //       System.out.println(recursionDecode("BS_3128M3"));
//        while((line = fs.readLine())!=null) {
//            System.out.println(line);
//            System.out.println(line = recursionDecode(line));
//            System.out.println(line.toLowerCase());
//        }
        String a ="-20181105-07-TONG";
        System.out.println(a.split("-")[1] + a.split("-")[2] );
    }

    public static String recursionDecode(String value) throws UnsupportedEncodingException {
        String tmp;
        boolean changed = false;
        while (!(tmp = java.net.URLDecoder.decode(value, "utf-8")).equals(value)) {
            value = tmp;
            changed = true;
        }
        return value;
    }
}
