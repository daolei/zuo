package champter1;

import com.miaozhen.dmp.datasource.desensitization.IntDesensitizer;
import com.miaozhen.dmp.datasource.desensitization.LongDesensitizer;

/**
 * Created by daolei.su on 2018/11/6
 */
public class testDecode {

    public static void main(String[] args) {
        String a = "37554053";
        System.out.println(IntDesensitizer.getInstance().decode(Integer.parseInt(a)));
        String p ="2383715451";
        System.out.println(LongDesensitizer.getInstance().decode(Long.parseLong(p)));
    }
}
