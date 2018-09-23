package u5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static u2.Merge_Sort.merge_sort;

/**
 * @author LaZY（李志一）
 * @data 2018/9/14 - 15:09
 */
public class Util {
    public static List<Integer> list = new ArrayList<Integer>();
    int flag = 0;
    /***
     * 获取数组中指定位置元素的值
     * @param a 指定的数组
     * @param i 指定的位置（索引）
     * @return 指定索引位置的值
     */
    public static int getElement(int a[],int i){
        return a[i];
    }

    /***
     * 拷贝指定数组并返回
     * @param a 要拷贝的数组
     * @return 拷贝出的数组
     */
    public static int[] copy(int a[]){
        int[] newa = new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            newa[i] = a[i];
        }
        return newa;
    }

    /***
     * 按照优先级对数组元素进行排序
     * @param ran 待排序的数组
     * @param a 数组元素的优先级
     */
    public static void sort(int ran[], int a[]){
        int newa[] = copy(ran);
        int newfin[] = copy(a);
        merge_sort(ran);
        for (int i = 0; i <newa.length ; i++) {
            for (int j = 0; j < ran.length ; j++) {
                if (newa[i]== ran[j]){
                    int element = getElement(newfin, i);
                    a[j] = element;
                }
            }
        }
    }
}
