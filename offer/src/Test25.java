import java.util.LinkedList;
import java.util.List;

/**题目：输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 使用前序遍历，记录节点值的和，使用一个链表进行辅助，如果不满足要求就删掉。
 * @author LaZY(李志一)
 * @create 2019-08-07 23:39
 */
public class Test25 {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public void findPath(BinaryTreeNode root , int expectedSum){
        if(root != null ){

            findPath(root,0,expectedSum,new LinkedList<Integer>());
        }
    }
    public static void findPath(BinaryTreeNode root, int curSum, int expectedSum, List<Integer> result) {
        if(root != null){
            curSum += root.value;
            result.add(root.value);
            if(curSum < expectedSum){
                findPath(root.left,curSum,expectedSum,result);
                findPath(root.right,curSum,expectedSum,result);
            }
            else if(curSum == expectedSum){
                if(root.right == null && root.left == null){
                    System.out.println(result);
                }
            }
        }
        result.remove(result.size() - 1);
    }
}
