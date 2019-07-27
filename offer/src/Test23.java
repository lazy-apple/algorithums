import java.util.LinkedList;
import java.util.Queue;

/**从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。
 * @author LaZY(李志一)
 * @create 2019-07-27 9:58
 */
public class Test23 {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    public static void printFromToBottom(BinaryTreeNode root) {
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode current = null;
        //将当前节点放入队列
        //弹出首元素，打印
        //放入其左右孩子

        ((LinkedList<BinaryTreeNode>) queue).add(root);

        while(!queue.isEmpty()){
            current = queue.remove();
            System.out.println(current.value + " ");
            if(current.left!= null){
                ((LinkedList<BinaryTreeNode>) queue).add(current.left);
            }
            if(current.right!= null){
                ((LinkedList<BinaryTreeNode>) queue).add(current.right);
            }
        }
    }
    public static void main(String[] args) {

        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 8;
        root.left = new BinaryTreeNode();
        root.left.value = 6;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 5;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 10;
        root.right.left = new BinaryTreeNode();
        root.right.left.value = 9;
        root.right.right = new BinaryTreeNode();
        root.right.right.value = 11;
        printFromToBottom(root);}
}
