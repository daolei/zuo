package champter1;

import java.io.UnsupportedEncodingException;

/**
 * Created by daolei.su on 2018/11/27
 */
public class Util {
    public static String recursionDecode(String value) throws UnsupportedEncodingException {
        String tmp;
        while (!(tmp = java.net.URLDecoder.decode(value, "utf-8")).equals(value)) {
            value = tmp;
        }
        return value ;
    }
}
