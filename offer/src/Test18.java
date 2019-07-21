/**输入两棵二叉树A 和B，判断B 是不是A 的子结构。
 *
 * 解题思路：
 *  遍历第一棵树，如果某个节点为第二棵树的根节点，根据两棵树的节点进行匹配，结构均满足的话，返回true。
 *  结构不满足，就遍历匹配前的节点的左子树和右子树中是否能找到节点为第二棵树的根节点。
 * @author LaZY(李志一)
 * @create 2019-07-21 10:14
 */
public class Test18 {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /***
     * 这个方法每一次检查的是树中的某一个节点的情况
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == root2){
            return true;
        }
        if(root2 == null){
            return true;//因为root我们要查找是否为内部子树，此时遍历的节点已经没有了，说明他的这部分是满足要求的可以返回true
            //还有一点说面，如果这个条件成立，那么要么是根节点为null，要么是第二棵树他的子节点已经和第一棵树匹配。
        }
        if(root1 == null){
            return false;
        }
        boolean result = false;
        if(root1.value == root2.value){
            result = match(root1,root2);
        }
        if(result){
            return true;
        }
        return hasSubtree(root1.left,root2) || hasSubtree(root1.right,root2);
    }
    public static boolean match(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == root2){
            return true;
        }
        if(root2 == null){
            return true;//因为root我们要查找是否为内部子树，此时遍历的节点已经没有了，说明他的这部分是满足要求的可以返回true
            //还有一点说面，如果这个条件成立，那么要么是根节点为null，要么是第二棵树他的子节点已经和第一棵树匹配。
        }
        if(root1 == null){
            return false;
        }
        boolean result = false;
        if(root1.value == root2.value){
            result = match(root1.left,root2.left) && match(root1.right,root2.right);
        }
        return result;
    }
}
