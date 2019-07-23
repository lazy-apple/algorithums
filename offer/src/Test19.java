/**请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @author LaZY(李志一)
 * @create 2019-07-23 16:11
 */
public class Test19 {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void mirror(BinaryTreeNode node) {
        if(node == null){
            return;
        }
        BinaryTreeNode t = node.left;
        node.left = node.right;
        node.right = t;

        mirror(node.left);
        mirror(node.right);
    }
}
