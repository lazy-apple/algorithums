package u5;

/**
 * @author LaZY（李志一）
 * @data 2018/9/23 - 21:14
 */


public class ON_LINE_MAXIMUM {
    /***
     *  * 雇用问题
     *
     * 1.给每个应聘者打分
     * 2.淘汰前k位应聘者，并记录其中的最高分
     * 3.从k位往后，大于之前最高分的应聘者就能胜任
     * 4.最高分的仍然在前k位之中，第n位应聘者胜任
     *
     * @param sorce 存储员工成绩的数组
     * @param k 界限
     * @return  胜任员工在数组中的索引
     */
    public static int on_line_maximum(int[] sorce,int k){
        int bestSorce = 0;
        for (int i = 0; i < k; i++) {
            if(sorce[i]>bestSorce){
                bestSorce = sorce[i];
            }
        }
        for (int i = k; i < sorce.length; i++) {
            if (sorce[i]>bestSorce){
                return i;
            }
        }
        return sorce.length - 1;
    }

    public static void main(String[] args) {
        int sorce[] = new int[]{2,15,3,11,30};
        int i = on_line_maximum(sorce,2);
        System.out.println(i);
    }
}
