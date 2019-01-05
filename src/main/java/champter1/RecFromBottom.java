package champter1;

import java.util.Stack;

/**
 * Created by daolei.su on 2018/12/31
 * 该算法，是用栈来记录，每个节点的可以向左右延伸的矩形面积
 * 存放规则，若元素比栈顶元素大，则可以直接放入栈中，如果小于等于栈顶元素，则将栈中元素依次弹出，直到栈为空 或者栈顶元素小于改元素
 * 在弹出的过程中，要记录弹出元素的作用延伸的距离，向右延伸到j-1 向左延伸到k + 1，所以之间的距离为 (j-1) - (k+1) + 1 即 j-k -1 当栈为空是默认应该存个-1
 * 当遍历完所有节点后，最终栈中的数据也要统计这时的j就是arr的length
 */
public class RecFromBottom {
    public int maxRecSize(int[][] map) {
        int[][] height = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? height[i][j] : height[i - 1][j] + 1;
                }
            }
        }
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, getMax(height[i]));
        }
        return max;
    }

    private int getMax(int[] arr) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            //相等的时候多算一遍，不影响最终结果，其实也可以不用算的
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                max = Math.max(max, arr[stack.pop()] * (i - (stack.isEmpty() ? -1 : stack.peek()) - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            max = Math.max(max, arr[stack.pop()] * (arr.length - 1 - (stack.isEmpty() ? -1 : stack.peek()) - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 3, 6};
        System.out.println(new RecFromBottom().getMax(arr));
    }

}
