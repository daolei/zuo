package champter4;

/**
 * Created by daolei.su on 2019/1/1
 * 斐波那契数列
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        System.out.println(fibonacciSequence.getFibo(5));
    }

    public int getFibo(int num) {
        if (num < 1) {
            return 0;
        }
        if (num == 1 || num == 2) {
            return 1;
        }

        return getFibo(num - 1) + getFibo(num - 2);
    }
}
