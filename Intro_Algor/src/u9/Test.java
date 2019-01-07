package u9;

/**
 * @author LaZY（李志一）
 * @data 2019/1/7 - 14:23
 */
public class Test {
    public static void main(String[] args) {
        int a[] = {3,2,9,0,10,1};//0,1,2,3,9,10
        int result = Select.randomized_select(a,2);
        System.out.println(result);
    }
}
