package champter1;

import com.miaozhen.admonitor.common.exception.BusinessException;
import com.miaozhen.admonitor.common.log.parser.KvPair;
import com.miaozhen.admonitor.common.utils.SysOutLogger;

import java.io.*;
import java.util.HashMap;

/**
 * Created by daolei.su on 2018/11/27
 */
public class testUa {
    private void checkUa(String ua, HashMap<String, String[]> uaBlackList) throws BusinessException {
        if (ua == null) {
            return;
        }
        try {
            ua = Util.recursionDecode(ua).toLowerCase();

            boolean ifSpider = false;

            //遍历黑名单列表
            for (String blackUa : uaBlackList.keySet()) {
                //如果包含该黑名单关键字，则遍历相关的白名单，当包含白名单时，直接终止遍历白名单，一旦没有相应的白名单，则直接判断为该日志为黑名单
                boolean ifContainsWhite = false;
                if (ua.contains(blackUa)) {
                    for (String white : uaBlackList.get(blackUa)) {
                        if (ua.contains(white)) {
                            ifContainsWhite = true;
                            break;
                        }
                    }
                    if (!ifContainsWhite) {
                        System.out.println(blackUa);
                        ifSpider = true;
                        break;
                    }
                }
            }
            if (ifSpider) {
                throw new BusinessException("spider log, e: " + ua);
            }

        } catch (UnsupportedEncodingException e) {
            return;
        } catch (IllegalArgumentException e) {
            SysOutLogger.error(String.format("url decode error, key: %s, value: %s", "ua", ua));
            return;
        }

    }

    public static void main(String[] args) throws IOException, BusinessException {
        BufferedReader bf = new BufferedReader(new FileReader("/Users/sudaolei/PycharmProjects/untitled2/IAB_UablackList.csv"));
        HashMap<String, String[]> IABuaBlackList = new HashMap<>();
        String line;
        while ((line = bf.readLine()) != null) {
            String[] items = line.split(",");
            if (items.length >= 1) {
                String[] valueTemp = new String[items.length - 1];
                String keyTemp = items[0].trim().toLowerCase();
                for (int i = 1; i < items.length; i++) {
                    valueTemp[i - 1] = items[i].trim().toLowerCase();
                }
                IABuaBlackList.put(keyTemp, valueTemp);
            }
        }
        testUa t = new testUa();
        t.checkUa("mozilla/5.0 (unknown; linux x86_64) applewebkit/538.1 (khtml, like gecko) casperjs/1.1.3 phantomjs/2.1.1 safari/538.1",IABuaBlackList);
    }
}
