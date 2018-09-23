package u5;

/**
 * @author LaZY（李志一）
 * @data 2018/9/23 - 16:28
 */

import util.Util;

import java.util.Random;

/***
 *随机排列数组
 * 1.迭代取值范围（范围逐渐缩小）
 * 2.取范围内的随机数
 * 3.将当前索引的元素和随机索引的元素互换
 */
public class RANDOMIZE_IN_PLACE {
    public static void randomize_in_place(int[] a){
        int length = a.length;
        for (int i = 0; i <length-1; i++) {//数组最后一个索引的值不需要再随机改变
            int ran =new Random().nextInt(length-i) + i;

            int t = a[ran];
            a[ran] = a[i];
            a[i] = t;
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3};
        randomize_in_place(a);
        Util.print(a);
    }
}
