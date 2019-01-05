package champter1;

import java.util.LinkedList;

/**
 * Created by daolei.su on 2018/12/31
 * 利用一个双端队列来记录当前读取记录中的最大值的index
 * 双端队列的存放规则是：遇到一个节点，若这个节点比尾部的节点小才放入到该队列中，如果比尾节点大则将队列尾部节点推出，直到遇到比这个节点大的节点或者队列为空了他就是最大的
 * 这样放的原因是保证在双端队列的头节点始终存放着目前windows中最大值的index
 * 还需要时刻注意头节点是不是已经超出了window的大小，如果超出了则需要把头节点推出
 * 时间复杂度为O(N) 空间复杂度 O(N)
 */
public class MaxWindow {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int window = 3;
        int[] maxArr = getMaxWindow(arr, window);
        for (int i = 0; i < maxArr.length; i++) {
            System.out.println(maxArr[i]);
        }
    }

    private static int[] getMaxWindow(int[] arr, int window) {
        int[] maxArr = new int[arr.length - window + 1];
        LinkedList<Integer> qmax = new LinkedList<>();
        qmax.add(0);
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.getLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - window) {
                qmax.pollFirst();
            }
            //在第一次读到窗口的最后一个元素的时候开始记录最大值
            if (i >= window - 1)
                maxArr[index++] = arr[qmax.peekFirst()];
        }

        return maxArr;
    }
}
