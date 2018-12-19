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
    }
}
