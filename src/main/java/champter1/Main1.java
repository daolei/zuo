package champter1;

/**
 * Created by daolei.su on 2018/11/12
 */
public class Main1 {
    public static void main(String[] args) {
        String flag = "1";
        server s = new server("1");
        Thread a = new Thread(new thread2("1", flag, s));
        Thread b = new Thread(new thread2("2", flag, s));
        a.setName("a");
        b.setName("b");
        a.start();b.start();

    }
}
