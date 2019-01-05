package champter1;

/**
 * Created by daolei.su on 2018/11/12
 */
public class main {
    public static void main(String[] args) {
        String a = new String("a");
       new Thread(new thread1(a)).start();
       new Thread(new thread1(a)).start();


       Singleton.getSingleton();
    }

}
