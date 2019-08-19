/**数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 *
 * 解题思路：1.）快速排序 2）计数器
 * @author LaZY(李志一)
 * @create 2019-08-19 23:21
 */
public class Test29 {
    public static int moreThanHalfNum(int[] numbers) {
        int result = numbers[0];
        int count = 1;
        for (int i = 1; i < numbers.length; i++) {
            if(count <= 0){
                result = numbers[i];
                count = 1;
            }
            else if(result == numbers[i]){
                count ++;
            }
            else {
                count --;
            }
        }
        //还要检查是否真的超过数组一半，可能并没有超过一半的元素
        return result;
    }
}
