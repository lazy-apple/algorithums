package u15;

/**
 * @author LaZY（李志一）
 * @data 2019/1/8 - 10:59
 */
public class Test {
    public static void main(String[] args) {
        int p[] = new int[]{1,5,8,9,10,17,17,20,24,30};
//        System.out.println(SteelBar_Cut.cut_rod(p, 4));
        System.out.println(SteelBar_Cut.memoized_cut_rod(p, 4));
    }

}
