/**输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc。则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac 、bca、cab 和cba
 *
 * 解题思路：递归
 * @author LaZY(李志一)
 * @create 2019-08-15 23:23
 */
public class Test28 {
    public static void permutation(char[] chars) {
        // 输入较验
        if (chars == null || chars.length < 1) {
            return;
        }
        // 进行排列操作
        permutation(chars, 0);
    }

    private static void permutation(char[] arr, int begin) {
        if(arr.length - 1 == begin){
            System.out.println(arr + " ");
        }else{
            for (int i = begin ; i < arr.length; i++) {
                swap(arr,begin,i);
                permutation(arr,begin + 1);
            }
        }
    }

    private static void swap(char[] arr, int begin, int i) {
        char t = arr[begin];
        arr[begin] = arr[i];
        arr[i] = t;
    }

}
