package champter1;

/**
 * Created by daolei.su on 2018/11/12
 */
public class thread2 implements Runnable {

    String name;
    String flag;
    server server;

    public thread2(String a, String flag, server server) {
        this.name = a;
        this.server = server;
    }



    @Override
    public void run() {

        for(int i = 0 ;i < 100;i++){
            try {
                server.print(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
