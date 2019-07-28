/**输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 * 解题思路：结合二叉搜索树和后续遍历特点：
 *              根节点在最后
 *              小于根节点部分，大于根节点部分，根节点
 * @author LaZY(李志一)
 * @create 2019-07-28 11:03
 */
public class Test24 {
    public boolean verifySequenceOfBST(int[] arr){
        if(arr == null || arr.length < 1){//验证参数
            return false;
        }
        return verifySequenceOfBST(arr,0,arr.length - 1);
    }

    public boolean verifySequenceOfBST(int[] arr,int start,int end){
        if(start >= end){//递归出口
            return true;
        }
        int index = 0;
        //！！！！！！！！！！！！！前面这个条件很必要！！！！！
        while(index < end - 1 && arr[index] < arr[end]){
            index ++;
        }

        int right = index;
        while(index < end - 1 && arr[index] > arr[end]){
            right ++;
        }

        if(right != end - 1){
            return false;
        }

        //verifySequenceOfBST(arr,start,index),,start不要写成0
        return verifySequenceOfBST(arr,start,index)&&verifySequenceOfBST(arr,index+1,end - 1);
    }
}
