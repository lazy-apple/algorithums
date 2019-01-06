package u8;

import util.Util;

/**
 * @author LaZY（李志一）
 * @data 2019/1/4 - 14:43
 */
public class Test {
    public static void main(String[] args) {
        int a[] = {2,5,3,0,2,3,0,3};
        a = Counting_sort.counting_sort(a);
        Util.print(a);
    }
}
