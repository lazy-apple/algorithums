package util;

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
}
