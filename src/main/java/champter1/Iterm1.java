package champter1;

import java.util.Stack;

/**
 * Created by daolei.su on 2018/10/24
 */
public class Iterm1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        Iterm1 iterm1 = new Iterm1();
        for (int i =0;i<stack.size();i++){
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
        iterm1.getStackElements(stack);
        for (int i=0;i<stack.size();i++){
            System.out.print(stack.get(i) + " ");
        }

    }

    public Stack<Integer> getStackElements(Stack<Integer> stack){

        if (stack.empty()){
            return stack;
        }
        Integer tmp = stack.pop();

        getStackElements(stack).push(tmp);

        return stack;
    }
}
