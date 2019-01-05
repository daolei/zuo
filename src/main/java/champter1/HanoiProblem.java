package champter1;

/**
 * Created by daolei.su on 2018/12/31
 * 汉诺塔问题 递归处理 只需要三个步骤
 * 1. 将 n-1 个盘子 推入 缓存
 * 2. 将 最后一个盘子 推入 终点
 * 3. 把 在缓冲区中的n -1 个盘子也推入 终点
 * （注意临界点，就很好处理）时间复杂度为2^n -1
 */
public class HanoiProblem {
    public static void main(String[] args) {
        HanoiProblem hanoiProblem = new HanoiProblem();
        String [] arr= {"a", "b", "c"};
        hanoiProblem.move(3,arr[0],arr[1],arr[2]);
    }

    public void move(int num, String left, String mid, String right) {
        if (num < 1) {
            System.out.println("1");
        }
         process(num, left, mid, right);
    }

    public void mvAction( String left, String right) {
        System.out.println(String.format(" 从 %s 移动到 %s", left, right));
    }

    private void process(int num, String left, String mid, String right) {
        if (num == 1) {
            mvAction(left,right);
        }
        else {
            process(num-1,left, right,mid);
            process(1,left, mid,right);
            process(num-1,mid,left,right);
        }
    }
}
