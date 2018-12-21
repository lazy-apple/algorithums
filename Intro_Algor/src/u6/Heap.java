package u6;

import util.Util;

/**
 * @author LaZY（李志一）
 * @data 2018/12/18 - 12:38
 */
public class Heap {
    public static int heapLenth;//堆中元素个数
    public static int[] heap;//堆容器
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
        return (i-1)/2;
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

    /**
     * 将数组中符合堆条件的元素存入堆中
     * @param a 数组
     */
    public static void copy_in_heap(int a[]){
        heap =new int[heapLenth];
        Util.copyArray(a,heap);
    }
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

        if (l<heapLenth&&a[l]>a[i]){//WRONG 错误写法：<=。原因：因为数组长度比数组最大索引多1。
            largest = l;
        }else {
            largest = i;
        }

        if (r<heapLenth&&a[r]>a[largest]){
            largest = r;
        }

        if (largest != i){//不满足最大堆条件
            int t;
            Util.change(a,largest,i);
            MAX_HEAPIFY(a,largest);
        }

    }

    /***
     * 建堆
     *1.初始化堆
     *  堆中元素个数=数组元素 个数
     *2.从n/2递减维护最大堆性质
     *  如果是数组的话，从n/2-1
     *
     * @param a （待排序的）数组
     */
    public static void BUILD_MAX_HEAP(int a[]){
        init(a);
        int i;
        for (i=heapLenth/2-1;i>=0;i--){//WRONG 错误写法：i = (heaplenth-1)/2
            MAX_HEAPIFY(a,i);
        }
    }

    /***
     * 堆排序
     *
     *1.建堆
     *2.将第一项元素与最后一项互换（因为第一项永远最大）
     *3.堆的元素个数-1（换到末尾的元素不再需要维护）
     *4.维护第一项元素（交换后的元素及其子树需要维护）
     *5.直到遍历到数组最后一个元素（最后一个元素不需要调整）
     *
     * @param a （待排序的）数组
     */
    public static void HEAPSORT(int a[]){
        BUILD_MAX_HEAP(a);
        for (int i = a.length-1; i >0 ; i--) {
            Util.change(a,0,i);//wrong 错误写法：（a,1,i）。错误原因：数组的第一个元素的索引为0
            heapLenth --;
            MAX_HEAPIFY(a,0);//wrong 错误写法：(a,0)。
        }
    }
}
