/**
 * 最大子数组问题
 * @author LaZY（李志一）
 * @data 2018/9/11 - 10:28
 */
public class Maximum_Subarray {

    /***
     * 求最大子数组和
     *
     *   1.根据数组中间点，将数组分为两份
     *   2.分别求出两份数组的最大子数组的和
     *   3.求出跨越中间点的最大子数组的和
     *   4.将三份的值进行比较
     *
     * @param a 整个的数组
     * @param low   要操作数组的起始点
     * @param high  要操作数组的末尾点
     * @return  最大子数组的和
     *
     */
    private  static  int FIND_MAXMUM_SUBARRAY(int a[],int low,int high){
        if (low == high){//递归的出口
            return a[low];
        }else {
            int mid = (low + high)/2;

            int max_left = FIND_MAXMUM_SUBARRAY(a,low,mid);
            int max_right = FIND_MAXMUM_SUBARRAY(a,mid+1,high);
            int max_mid = FIND_MAX_CROSSING_SUBARRAY(a,low,mid,high);

            if (max_left>max_mid&&max_left>max_right){
                return  max_left;
            }else if (max_right>max_left&&max_right>max_mid){
                return max_right;
            }else {
                return max_mid;
            }
        }

    }

    /***
     * 求跨越中间点的最大子数组的和
     *
     *  1.求中间点的左边子数组(包含中间点的元素)的和
     *      a.从中间点向左迭代，求出总和
     *      b.和当前最大字数组的和进行比较
     *      c.总和大于当前最大子数组便进行替换
     *  2.求中间点的右边子数组的和
     *  3.两次结果相加
     *
     * @param a 整个的数组
     * @param low   求解子数组的起始索引
     * @param mid   求解子数组的中间索引
     * @param high  求解子数组的末尾索引
     * @return  最大子数组的和
     */
    private static int FIND_MAX_CROSSING_SUBARRAY(int a[],int low,int mid,int high){
        //求中间点左边最大子数组的和
        int left_sum = 0;
        int sum = 0;
        for (int i = mid; i >=low ; i--) {
            sum += a[i];
            if (sum > left_sum){
                left_sum = sum;
                //max_left = i;//获取左边界
            }
        }
        //求中间点右边最大子数组的和
        int right_sum = 0;
        sum = 0;
        for (int i = mid + 1; i <= high ; i++) {
            sum += a[i];
            if (sum>right_sum){
                right_sum = sum;
                //max_right = i;//获取右边界
            }
        }
        return left_sum+right_sum;
    }

    /***
     * 求最大子数组和的外部方法
     * @param a 要操作的数组
     * @return 最大子数组和的值
     */
    public  static  int FIND_MAXMUM_SUBARRAY(int a[]){
        return FIND_MAXMUM_SUBARRAY(a,0,a.length-1);
    }

    //测试结果
    public static void main(String[] args) {
        int a[] = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        System.out.println(FIND_MAXMUM_SUBARRAY(a));
    }
}
