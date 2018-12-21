package u6;

import util.Util;

/**
 * 优先队列
 * @author LaZY（李志一）
 * @data 2018/12/21 - 10:39
 */
public class Priority_queue {
    /***
     * 从集合中取出最大关键字元素:
     *  返回堆中第一个元素
     * @param a 集合
     * @return 集合中关键字最大的元素
     */
    public static int HEAP_MAXMUM(int a[]){
        return a[0];
    }

    /***
     * 去掉并返回集合中最大关键字的元素:
     *  1.验证（堆中有元素）；
     *  2.存取最大元素（堆中第一个元素）；
     *  3.最大元素和末尾元素交换值；
     *  4.堆中元素个数减一；
     *  5.重新维护堆中第一个元素；
     *  6.返回存取值。
     *
     * @param a 集合
     * @return 集合中关键字最大的元素
     */
    public static int HEAP_EXTRACT_MAX(int a[]){
        int max = 0;
        if(Heap.heapLenth<0){
            System.out.println("堆中无元素");
        }else{
            max = a[0];
            a[0] = a[Heap.heapLenth-1];
            Heap.heapLenth--;
            Heap.MAX_HEAPIFY(a,0);
        }
        return max;
    }

    /***
     * 将元素的关键字增加至k：
     *  1.验证：k不能小于本身；
     *  2.将元素的关键字修改为k；
     *  3.迭代（将元素与其父节点比较）。
     *      a.坐标必须大于根结点；
     *      b.元素的关键字比其父节点大，则进行互换；
     *      c.指向父节点，继续迭代。
     *
     * @param a 集合
     * @param i 被修改元素的坐标
     * @param k 要修改为的关键字
     */
    public static void HEAP_INCREASE_KEY(int a[],int i,int k){
        if(a[i]>=k){
            System.out.println("不符合条件");
        }else{
            a[i]= k;
            while(i>0&&a[Heap.parent(i)]<a[i]){
                Util.change(a,i,Heap.parent(i));
                i = Heap.parent(i);
            }
        }
    }

    /***
     * 把元素x插入到集合中：
     *  1.堆中元素数量加1；
     *  2.堆末尾添加最小关键字；
     *  3.将元素添加至末尾，执行HEAP-INCREASE-KEY，使其到达正确位置。
     *
     * @param a 集合
     * @param x 要插入元素的关键字
     */
    public static int[] MAX_HEAP_INSERT(int a[],int x){
        Heap.heapLenth++;
        //wrong 错误写法：直接在原数组上操作 错误原因：原数组已满，必须扩容或使用新数组替换。
        Heap.heap = new int[Heap.heapLenth];
        Util.copyArray(a,Heap.heap);
        //
        Heap.heap[Heap.heapLenth-1] = -9999;
        HEAP_INCREASE_KEY(Heap.heap,Heap.heapLenth-1,x);
        return Heap.heap;
    }
}
