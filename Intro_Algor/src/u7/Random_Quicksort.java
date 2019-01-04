package u7;

import util.Util;

/**
 * @author LaZY（李志一）
 * @data 2019/1/4 - 10:54
 */
public class Random_Quicksort {
    /***
     * 随机快速排序
     * @param a
     * @param p
     * @param r
     */
    private static void RANDOMIZED_QUICKSORT(int a[],int p,int r){
        if(p<r){//递归出口
            int q = RANDOMIZED_PARTITION(a,p,r);
            RANDOMIZED_QUICKSORT(a,p,q-1);
            RANDOMIZED_QUICKSORT(a,q+1,r);
        }
    }
    /***
     * 随机区主元分区
     * @param a
     * @param p
     * @param r
     * @return
     */
    public static int RANDOMIZED_PARTITION(int a[],int p,int r){
        int random = Util.random(p,r);
        Util.change(a,random,r);
        return Quicksort.PARTITION(a,p,r);
    }

    /***
     * 外部方法
     * @param a
     */
    public static void RANDOMIZED_QUICKSORT(int a[]){
        RANDOMIZED_QUICKSORT(a,0,a.length-1);
    }
}
