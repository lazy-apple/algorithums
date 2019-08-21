/**连续子数组的最大和
 * @author LaZY(李志一)
 * @create 2019-08-21 23:12
 */
public class Test31 {
    public static int test(int[] arr){
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = sum + arr[i] > arr[i] ? sum + arr[i] : arr[i];
            max = max > sum ? max : sum;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(test(new int[]{-2, -8, -1, -5, -9}));
    }
}
