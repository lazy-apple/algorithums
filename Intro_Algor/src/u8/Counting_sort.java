package u8;

import util.Util;

/**
 * @author LaZY（李志一）
 * @data 2019/1/4 - 14:13
 */
public class Counting_sort {
    /***
     * 计数排序
     *  1.数组C：填充0；
     *  2.数组A中，值相等的元素存在数组C的相应位置上；
     *  3.数组A中，小于k的值的个数存在数组C相应位置上；
     *  4.数组A中的元素填充进数组B中（利用数值的个数）；
     *      填充一个元素后，c中相应位置减1.
     * @param a 待排序数组
     * @return 排好序的数组
     */
    public static int[] counting_sort(int a[]){
        int max = Util.getMax(a);
        int c[] = new int[max+1];
        int b[] = new int[a.length];
        fill0(c);
        count(a,c);
        countSum(c);
        fillArray(a,b,c);
        return b;
    }

    /***
     * 数组A中的元素填充进数组B中（利用数值的个数）；
     * @param a
     * @param b
     * @param c
     */
    private static void fillArray(int a[],int b[],int c[]){
        for (int i = 0; i < a.length; i++) {
            b[c[a[i]]-1] = a[i];//wrong 错误写法：b[c[a[i]]] 出错原因：数组下标和元素个数的关系
            c[a[i]]--;
        }
    }

    /***
     * 数组A中，值相等的元素存在数组C的相应位置上；
     * @param a
     * @param c
     */
    private static void count(int a[],int c[]){
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }
    }

    /***
     * 数组A中，小于k的值的个数存在数组C相应位置上；
     * @param c
     */
    private static void countSum(int c[]){
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }
    }
    /***
     * 数组所有元素填充0
     * @param a
     */
    private static void fill0(int a[]){
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
    }
}
