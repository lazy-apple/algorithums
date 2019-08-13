/**输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 解题思路：中序遍历+递归
 * @author LaZY(李志一)
 * @create 2019-08-13 23:36
 */
public class Test27 {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    public static BinaryTreeNode convert(BinaryTreeNode root) {

        // 用于保存处理过程中的双向链表的尾结点
        BinaryTreeNode[] lastNode = new BinaryTreeNode[1];//第一次为null
        convertNode(root, lastNode);

        // 找到双向链表的头结点
        BinaryTreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static void convertNode(BinaryTreeNode root, BinaryTreeNode[] lastNode) {
        if(root != null){
            if(root.left != null){
                convertNode(root.left,lastNode);
            }
            root.left = lastNode[0];
            if(lastNode[0] != null){
                lastNode[0].right = root;
            }
            lastNode[0] = root;
            if(root.right != null){
                convertNode(root.right,lastNode);
            }
        }
    }

}
