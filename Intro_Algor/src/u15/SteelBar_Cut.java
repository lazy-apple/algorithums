package u15;

/**
 * 动态规则--
 * 钢条切割：给定一定长度为n英寸的钢条和一个价格表pi（i = 1,2,3……n）,求切割方案，使销售收益rn最大。
 * @author LaZY（李志一）
 * @data 2019/1/8 - 10:50
 */
public class SteelBar_Cut {

    /***
     * 简单递归求钢条切割的收益：
     *      1.递归出口：
     *          长度为0，返回0;
     *      2.初始化收益值为最小值；
     *      3.遍历取得最终收益（从0到n-1）：
     *          用当前收益和切割后的收益作比较：
     *              切割后收益=左边切割收益+右边切割收益（递归）
     * @param p 价格数组p
     * @param n 钢条长度n
     * @return 长度为n的钢条的最大收益
     */
    public static int cut_rod(int[]p,int n){
        if(n == 0){
            return 0;
        }
        int q = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {//wrong i的初值应该为1，想要获取数组第一个元素则使用i-1
            q = Math.max(q,p[i-1]+cut_rod(p,n-i));
        }
        return q;
    }

    /***
     * 自顶向下法（带备忘）:
     *      1.构建备忘表，填充最小值;
     *      2.使用上述递归方法:
     *          1).如果备忘表中已存在（长度为n的收益），直接返回;
     *          2).递归出口：长度为0，收益为0;
     *          3).收益初始最小值;
     *          4).遍历取得最终收益;
     *          5).将长度为n的收益保存在备忘表中;
     *          6).返回长度为n的收益。
     *
     * @param p 价格数组p
     * @param n 钢条长度n
     * @return 长度为n的钢条的最大收益
     */
    public static int memoized_cut_rod(int p[],int n){
        int r[] = build_Memorandum(n);
        return memoized_cut_rod_aux(p,n,r);
    }

    /**
     * 自底向上法
     *      1.构建备忘数组；
     *      2.从1遍历到n，获取最优解，并将结果存放在备忘表中：
     *          对每个数其不同方案遍历取结果；
     *      3.返回备忘数组中n元素的值（长度为n的最优解）
     * @param p
     * @param n
     * @return
     */
    public static int bottom_up_cut_rod(int p[],int n){
        int r[] = build_Memorandum(n);
        r[0] = 0;//原因：第一次遍历计算时会使用到r[0]的值。
        for (int j = 1; j <= n; j++) {//从1遍历到n，获取最优解
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q,p[i-1]+r[j-i]);//wrong 错误写法：Math.max(q,p[i]+r[j-i]) 错误原因：i的初值为1（不是0），q数组中第一个元素的索引为i-1
            }
            r[j] = q;                 //并将结果存放在备忘表中
        }
        return r[n];
    }


    /***
     * 递归求解
     * @param p 价格数组p
     * @param n 钢条长度n
     * @param r 备忘表
     * @return 长度为n的钢条的最大收益
     */
    public static int memoized_cut_rod_aux(int p[],int n,int r[]){
        int q = 0;//收益初始值
        if(r[n]>=0){
            return r[n];
        }
        if(n == 0){
            q = 0;
        }
        else {
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q,p[i-1]+memoized_cut_rod_aux(p,n-i,r));
            }
        }
        r[n] = q;
        return q;
    }

    /***
     * 构建备忘表
     */
    private static int[] build_Memorandum(int n){
        int a[] = new int[n+1];//wrong 元素个数为长度+1
        int value = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            a[i] = value;
        }
        return a;
    }
}
