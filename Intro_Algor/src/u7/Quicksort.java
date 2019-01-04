package u7;

import util.Util;

/**
 * @author LaZY（李志一）
 * @data 2019/1/4 - 10:03
 */
public class Quicksort {
    /***
     * 快速排序：
     *  1.条件：前界小于后界；
     *  2.数组分区（区域A：小于主元；主元；区域B：大于主元）；
     *      找到主元（末尾元素）。
     *      设置区域界（第一次为数组第一个元素的前面）。
     *      小于主元的元素移动到区域界之前（从数组第一个元素，查找到主元前一个元素）。
     *      将主元放到两区域的中间。
     *  3.对区域A快速排序;
     *  4.对区域B快速排序.
     * @param a 数组
     * @param p 排序的前界
     * @param r 排序的后界
     */
    private static void QUICKSORT(int a[],int p,int r){
        if(p<r){//递归出口
            int q = PARTITION(a,p,r);
            QUICKSORT(a,p,q-1);
            QUICKSORT(a,q+1,r);
        }
    }

    /***
     * 分区
     * @param a
     * @param p
     * @param r
     * @return
     */
    private static int PARTITION(int a[],int p,int r){
        int x = a[r];//主元
        int i = p - 1;//区域界
        for (int j = p; j <= r-1 ; j++) {
            if(a[j] < x){
                i ++;
                Util.change(a,i,j);
            }
        }
        Util.change(a,r,i+1);
        return i+1;
    }

    /***
     * 快速排序-外部方法
     * @param a 待排序数组a
     */
    public static void QUICKSORT(int a[]){
        QUICKSORT(a,0,a.length-1);
    }
}
