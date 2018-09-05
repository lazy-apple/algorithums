import java.util.ArrayList;
import java.util.List;

/**
 * 正序插入排序
 *
 * @author LaZY（李志一）
 * @data 2018/9/4 - 15:01
 */
public class Insertion_Sort {
    //原理：每当插入新的值，就进行一次排序
    //流程：
    //  插入元素和其后面的元素依次比较，当插入元素小于后面元素，让后面的元素（较大的元素）覆盖插入位置
    //  当迭代到数组的开头，退出迭代
    //  让最终迭代被覆盖位置的前一个位置，它的值为新插入元素的值。(让新插入的值，插入到合适位置)
    //      或者让新插入的元素的前一个索引的下一个位置（也就是新插入元素的索引），它的值为新插入元素的值。

    /**
     * 正序插入排序
     *
     * @param a 等待排序的数组
     * @return 排序后的数组
     */
    public static int[] insertion_sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];//新（插入的）元素
            int j = i - 1;//新元素的前一个元素的索引
            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 6, 5, 9, 8, 1};
        arr = insertion_sort(arr);
        //check result：
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}