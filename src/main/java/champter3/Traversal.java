package champter3;

import champter1.Node;

import java.util.Stack;

/**
 * Created by daolei.su on 2019/1/3
 * 前中后序打印二叉树
 * 非递归前中后序打印二叉树
 * 非递归前中序遍历只需要一个栈就可以
 * 非递归后续遍历需要两个栈就可以
 */
public class Traversal {
    public static void main(String[] args) {
        System.out.println("hehe");
        Node node0 = getTree();
        Traversal traversal = new Traversal();
        //先序遍历
        System.out.println("先序遍历");
        traversal.preTravesal(node0);
        //中序遍历
        System.out.println("中序遍历");
        traversal.midTravesal(node0);
        //后序遍历
        System.out.println("后序遍历");
        traversal.posTravesal(node0);
        //非递归先序遍历
        System.out.println("非递归先序遍历");
        traversal.preTravesalNoRecursion(node0);
        System.out.println("非递归中序遍历");
        traversal.midOrderUnRecursion(node0);
        System.out.println("非递归后续遍历");
        traversal.posOrderUnRecursion(node0);
    }

    //递归线序遍历
    public void preTravesal(Node head) {
        System.out.println(head.value);
        if (head.left != null)
            preTravesal(head.left);
        if (head.right != null)
            preTravesal(head.right);
    }

    //递归中序遍历
    public void midTravesal(Node head) {
        if (head.left != null) {
            midTravesal(head.left);
        }
        System.out.println(head.value);
        if (head.right != null) {
            midTravesal(head.right);
        }
    }

    //递归后续遍历
    public void posTravesal(Node head) {
        if (head.left != null) {
            posTravesal(head.left);
        }
        if (head.right != null) {
            posTravesal(head.right);
        }
        System.out.println(head.value);
    }

    //非递归先序遍历
    public void preTravesalNoRecursion(Node head) {
        Stack<Node> stack = new Stack<>();
        if (head == null) {
            System.out.println(-1);
        }
        Node tmp;
        stack.push(head);
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.println(tmp.value);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
    }

    //非递归中序遍历
    public void midOrderUnRecursion(Node head) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }

    //非递归后续遍历
    public void posOrderUnRecursion(Node head) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        Node tmp;
        while (!s1.isEmpty()) {
            tmp = s1.pop();
            if (tmp.left != null) {
                s1.push(tmp.left);
            }
            if (tmp.right != null) {
                s1.push(tmp.right);
            }
            s2.push(tmp);
        }
        while (!s2.isEmpty()){
            System.out.println(s2.pop().value);
        }
    }

    public static Node getTree(){
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return node0;
    }
}
