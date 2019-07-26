import java.util.Stack;

/**题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *
 * 本题的特殊情况在于，栈可以同时压入和弹出
 *
 * 解题思路：如果入栈数组和出栈数组的当前元素匹配，则继续遍历。
 *              当不匹配，使用辅助栈，将压入数组中的元素放入辅助栈，和出栈数组的当前元素比较。
 *               如果所有元素已经入栈，还不能匹配，说明不符合条件。
 * @author LaZY(李志一)
 * @create 2019-07-26 10:57
 */
public class Test22 {
    public boolean  isPopOrder(int[] push, int[] pop){
        boolean isPossible = false;
        Stack<Integer> stack = new Stack();//辅助栈
        if(!check(push,pop)){//检查参数
            return isPossible;
        }
        int nextPush = 0; // 记录下一个要处理的入栈元素的位置
        int nextPop = 0; // 记录下一个要处理的出栈元素的位置
        while (nextPop < push.length ){//将入栈元素全部遍历
            while (stack.isEmpty() || stack.peek() != pop[nextPop]) {
                if(nextPush > push.length)break;//情况一：所有的入栈元素已进入辅助栈，还是不匹配。
                stack.push(push[nextPush++]);
            }
            //情况一：所有的入栈元素已进入辅助栈，还是不匹配。
            if(stack.peek() != push[nextPush])break;
            //情况二：元素已匹配，执行出栈操作。
            stack.pop();
            nextPop ++;
        }
        if (stack.isEmpty()) {
            isPossible = true;
        }
        return isPossible;
    }

    public boolean check(int[] push, int[] pop){
        boolean check = false;
        if(push != null && pop != null && push.length > 0 && pop.length > 0){
            return true;
        }
        return check;
    }
}
