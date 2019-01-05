package champter1;

import java.util.LinkedList;

/**
 * Created by daolei.su on 2018/12/31
 * 利用双端队列来实现该过程，在双端队列中，存着最大值的索引
 * 本题是利用了一个实时，就是如果在一个组合里面的最大值和最小值之差 符合条件则 他们的子数组都满足条件，如果最大最小值之差不满足条件则，所有包含他的数组都不符合条件
 */
public class subMax {
    public int getNum(int[] arr, int num) {
        int sum = 0;
        LinkedList<Integer> maxList = new LinkedList<>();
        LinkedList<Integer> minList = new LinkedList<>();

        int i = 0, j = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!maxList.isEmpty() && arr[maxList.peekLast()] < arr[j]) {
                    maxList.pollLast();
                }
                maxList.addLast(j);
                while (!minList.isEmpty() && arr[minList.peekLast()] > arr[j]) {
                    minList.peekLast();
                }
                minList.addLast(j);
                if (maxList.peekFirst() - minList.peekFirst() <= num) {
                    sum++;
                    j++;
                }
            }
            if (i == maxList.peekFirst()) {
                maxList.pollFirst();
            }
            if (i == minList.peekFirst()) {
                minList.pollFirst();
            }
            sum += j - i;
            i++;
        }
        return sum;
    }


}
