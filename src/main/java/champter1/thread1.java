package champter1;

/**
 * Created by daolei.su on 2018/11/12
 */
public class thread1 implements Runnable {
    int i;

    String a = null;

    public thread1(String a) {
        this.a = a;
    }

    public void run() {
        System.out.println(System.currentTimeMillis());
        for (int j = 0; i < 10; j++) {
            synchronized (this) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
