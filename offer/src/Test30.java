/**输入n个整数，找出其中最小的k个数。
 * @author LaZY(李志一)
 * @create 2019-08-20 23:08
 */
public class Test30 {

    public static void getLeastNumbers(int[] input, int[] output) {
        int start = 0;
        int end = input.length - 1;
        int index = partition(input,start,end);

        int target = output.length - 1;
        while(index != target){
            index = index > target ? partition(input,start,index - 1):partition(input,index + 1,end);
        }
        System.arraycopy(input, 0, output, 0, output.length);
    }


    private static int partition(int[] input, int start, int end) {

        return start;
    }


}
