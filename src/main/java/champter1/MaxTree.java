package champter1;

import java.util.Stack;

/**
 * Created by daolei.su on 2018/12/31
 * 给一个数组，得到maxTree，这个树不需要是一个平衡树
 * 以以下规则创建即可，对于数组中的任意一个节点，它左边和右边第一个比他大的值中较小的一个为其父节点，若两边都没有比它小的则，该节点为head节点（值最大的节点）
 * 如何快速找到两边最大的值，可以用一个stack找到O(n)的时间复杂度就可以全部找出来
 * 所以整体时间复杂度为O(n),思想和maxwindow差不多
 */
public class MaxTree {
    public static void main(String[] args) {
        MaxTree maxTree = new MaxTree();
        System.out.println(maxTree.getMaxTree(new int[]{3,4,5,1,2}));
    }
    public Node getMaxTree(int[] arr) {
        Node[] nodes = new Node[arr.length];
        Node[] leftMaxIndex = new Node[arr.length];
        Node[] rightMaxIndex = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();
        //从左到右
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().value < nodes[i].value) {
                stack.pop();
            }
            if (!stack.isEmpty())
                leftMaxIndex[i] = stack.peek();
            else
                leftMaxIndex[i] = null;
            stack.push(nodes[i]);
        }
        stack.clear();
        //从右向左
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().value < nodes[i].value) {
                stack.pop();
            }
            if (!stack.isEmpty())
                rightMaxIndex[i] = stack.peek();
            else
                rightMaxIndex[i] = null;

            stack.push(nodes[i]);
        }
        Node head = null;
        for (int i = 0; i < arr.length; i++) {
           if (leftMaxIndex[i] != null && rightMaxIndex[i] != null){
               if (leftMaxIndex[i].value > rightMaxIndex[i].value){
                   rightMaxIndex[i].left = nodes[i];
               }else {
                   leftMaxIndex[i].right = nodes[i];
               }
           }else if (rightMaxIndex[i] != null ){
               rightMaxIndex[i].left = nodes[i];
           }else if (leftMaxIndex[i] != null){
               leftMaxIndex[i].right = nodes[i];
           }else {
               head = nodes[i];
           }
        }
        return  head;
    }


}
