package u6;

import util.Util;

/**
 * @author LaZY（李志一）
 * @data 2018/12/18 - 12:38
 */
public class Heap {
    public static int heapLenth;//堆中元素个数

    /***
     * 初始化堆
     * @param a
     * 数组
     */
    public static void init(int[] a){
        heapLenth = a.length;
    }

    /***
     * 获取父节点的下标
     * @param i 当前节点
     * @return  父节点的坐标
     */
    public static int parent(int i){
        return i/2-1;
    }

    /***
     * 获取左孩子的下标
     * @param i
     * @return
     */
    public static int left(int i){
        return 2*i+1;
    }

    /***
     * 获取右孩子的下标
     * @param i
     * @return
     */
    public static int right(int i){
        return 2*i+1+1;
    }

    /***
     * 维护最大堆性质
     *1.获取坐标为i元素的左孩子l和有孩子r
     *2.检测左孩子l和当前元素的大小
     *  ·判断左孩子的坐标是否大于堆中元素个数（用于结束递归）
     *  ·将较大的数，存在新变量large中
     *3.检测右孩子r和large的大小
     *  ·判断右孩子的坐标是否大于堆中元素个数（用于结束递归）
     *  ·如果右孩子大于large，则将右孩子的值存在large中
     *4.如果large的值和当前元素的值不相等（不满足最大堆条件）
     *  ·将当前元素和large的值交换
     *  ·维护large（递归）
     *
     * @param a 数组
     * @param i 检测的坐标
     */
    public static void MAX_HEAPIFY(int[] a,int i){
        int largest;
        int r = right(i);
        int l = left(i);

        if (l<=heapLenth&&a[l]>a[i]){
            largest = l;
        }else {
            largest = i;
        }

        if (r<=heapLenth&&a[r]>a[largest]){
            largest = r;
        }

        if (largest != i){//不满足最大堆条件
            int t;
            t = a[largest];
            a[largest] = a[i];
            a[i] = t;

            MAX_HEAPIFY(a,largest);
        }

    }
}
