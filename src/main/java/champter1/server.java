package champter1;

/**
 * Created by daolei.su on 2018/11/12
 */
public class server {
    public int i = 1;
    public String name;

    server(String name) {
        this.name = name;
    }

    public void print(String flag) throws InterruptedException {
        synchronized (String.class) {
            System.out.println( Thread.currentThread().getName()+ "::" + i);
            Thread.sleep(100);
            i++;
        }
    }
}
