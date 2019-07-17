/**输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 *
 * 解题思路，定义两个指针分别位于头和尾，一个向后移动（遇到的是奇数），一个向前移动（遇到的是偶数）。
 * 当前面指针遇到偶数，等待后面指针遇到奇数，然后两数互换。
 * @author LaZY(李志一)
 * @create 2019-07-17 22:35
 */
public class Test14 {
    public void reorderOddEven (int[] a){
        if (a == null || a.length <= 1){
            return;
        }
        int start = 0;
        int end = a.length - 1;
        while (start < end){//由于相等的情况在奇数和偶数中间，所以不用处理
            while (start < end && a[start] %2 != 0){
                start ++;
            }
            while (start < end && a[end] %2 == 0){
                end --;
            }

            a[start] = a[start] ^ a[end];
            a[end] = a[start] ^ a[end];
            a[start] = a[start] ^ a[end];

            start ++;
            end --;
        }


    }
    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        new Test14().reorderOddEven(array);
        printArray(array);
    }
}
