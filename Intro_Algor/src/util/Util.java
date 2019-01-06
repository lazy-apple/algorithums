package util;

import java.util.Random;

/**
 * @author LaZY（李志一）
 * @data 2018/9/14 - 15:42
 */
public class Util {
    /***
     *格式化遍历打印数组（int型）
     * @param a
     */
    public static void print(int[]a){
        System.out.print("【");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("】");
    }

    /***
     * 格式化遍历打印数组（String型）
     * @param a
     */
    public static void print(String[]a){
        System.out.print("【");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("】");
    }

    /***
     * 交换数组中两个元素的值
     * @param a 数组
     * @param i 交换元素的索引1
     * @param j 交换元素的索引2
     */
    public static void change(int a[],int i,int j){
        int t = a[j];
        a[j] = a[i];
        a[i] = t;
    }

    /***
     * 将数组a拷贝到数组b中（a的长度<=b的长度）
     * @param a
     * @param b
     */
    public static void copyArray(int a[],int b[]){
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
    }

    public static int random(int start,int end){
        Random random = new Random();
        int ran = random.nextInt(end+1-start)+start;
        return ran;
    }

    /***
     * 获得数组中的最大值
     * @param a
     * @return
     */
    public static int getMax(int a[]){
        int max = a[0];
        for (int i = 0; i < a.length-2; i++) {
           max = Math.max(max,a[i+1]);
        }
        return max;
    }
}
