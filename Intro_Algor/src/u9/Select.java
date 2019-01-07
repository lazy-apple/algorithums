package u9;

import u7.Random_Quicksort;

/**
 * @author LaZY（李志一）
 * @data 2019/1/7 - 14:07
 */
public class Select {
    /**
     * 期望为线性时间的选择算法
     * （递归查找顺序统计量）：
     *      1.起始坐标和末尾坐标相等（递归出口）；
     *      2.分区（快速排序），并获取 k：主元在数组a范围内为第几个元素；
     *      3.k的值为顺序统计量的位置，则返回；
     *      4.如果没找到，就在分区内继续查找（递归）。
     *
     * @param a 数组
     * @param p 起始坐标
     * @param r 末尾坐标
     * @param i 顺序统计量的位置
     * @return 顺序统计量的值
     */
    private static int randomized_select(int a[],int p,int r,int i){
        if(p == r){
            return a[p];
        }

        int q = Random_Quicksort.RANDOMIZED_PARTITION(a,p,r);
        int k = q - p + 1;

        if(k == i){
            return a[q];
        }else if(i < k){
            return randomized_select(a,p,q-1,i);
        }else {
            return randomized_select(a,q+1,r,i-k);
        }
    }

    /***
     *期望为线性时间的选择算法（外部方法）
     * @param a 数组
     * @param i 顺序统计量位置
     * @return
     */
    public static int randomized_select(int a[],int i){
        return randomized_select(a,0,a.length-1,i);
    }
}
