package u6;

import util.Util;

/**
 * @author LaZY（李志一）
 * @data 2018/12/18 - 13:06
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("============维护最大堆性质=============");
        int[] a = {16,4,10,14,7,9,3,2,8,1};
        Heap.init(a);
        Heap.MAX_HEAPIFY(a,1);
        Util.print(a);
        System.out.println("============建堆=============");
        int[] a2 = {4,1,3,2,16,9,10,14,8,7};
        Heap.BUILD_MAX_HEAP(a2);
        Util.print(a2);
        System.out.println("============堆排序=============");
        int[] a3 = {16,14,10,8,7,9,3,2,4,1};
        Heap.HEAPSORT(a3);
        Util.print(a3);

        System.out.println("============优先队列=============");
        System.out.println("============获取堆中最大元素关键字=============");
        int[] a4 = {4,1,3,2,16,9,10,14,8,7};
        Heap.BUILD_MAX_HEAP(a4);
        System.out.println(Priority_queue.HEAP_MAXMUM(a4));
        System.out.println("============取出堆中最大元素关键字=============");
        Priority_queue.HEAP_EXTRACT_MAX(a4);
        Heap.copy_in_heap(a4);
        Util.print(Heap.heap);
        System.out.println("============将堆中一个元素的关键字修改=============");
        int[] a5 = {4,1,3,2,16,9,10,14,8,7};
        Heap.BUILD_MAX_HEAP(a5);
        Priority_queue.HEAP_INCREASE_KEY(a5,8,15);
        Util.print(a5);
        System.out.println("============向堆中添加元素=============");
        Priority_queue.MAX_HEAP_INSERT(a5,17);
        Util.print(Heap.heap);
    }
}
