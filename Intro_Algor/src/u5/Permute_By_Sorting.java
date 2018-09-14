package u5;

import java.util.Random;

/**
 * @author LaZY（李志一）
 * @data 2018/9/14 - 15:24
 */

public class Permute_By_Sorting {
    /***
     * 随机排列数组
     *   1.对数组元素随机产生优先级
     *   2.根据优先级对数组元素进行排序
     * @param a 待排序的数组
     */
    public static void permute_by_sorting(int a[]){
        int n = a.length;
        int[] random = new int[n];
        Random ran = new Random();
        for (int i = 0; i <random.length ; i++) {
            random[i] = ran.nextInt((n*n*n)-1)+1;
        }
        util.Util.print(random);
        Util.sort(random,a);
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4,5};
        permute_by_sorting(a);
        util.Util.print(a);
    }
}
