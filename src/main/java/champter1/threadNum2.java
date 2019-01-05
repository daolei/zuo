package champter1;

/**
 * Created by daolei.su on 2018/11/13
 */
public class threadNum2 implements Runnable {

    public number num;

    public threadNum2(number num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (num) {
                if (num.getNum() % 2 != 0) {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num.setNum(num.getNum() + 1);
                System.out.println(Thread.currentThread().getName() + ":" + num.getNum());
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num.notify();
            }
        }
    }

}
