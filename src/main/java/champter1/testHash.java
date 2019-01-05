package champter1;

/**
 * Created by daolei.su on 2018/11/2
 */
public class testHash {
    public static void main(String[] args) {
        Integer a = new Integer(10000000);
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        System.out.println(n1 == n2);

        System.out.println(a.hashCode());
    }
}
