package champter1;

/**
 * Created by daolei.su on 2018/11/12
 */
public class Singleton {
    private static volatile Singleton object;

    private Singleton(){}


    public static Singleton getSingleton(){
        if (object == null){
            synchronized (Singleton.class){
                if (object == null){
                    object = new Singleton();
                }
            }
        }
        return object;
    }
}
