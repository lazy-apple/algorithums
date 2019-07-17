/**
 * @author LaZY(李志一)
 * @create 2019-07-09 22:53
 */
public class BubbleSort {
//    冒泡排序：时间复杂度：O(n^2)
//               空间复杂度O(1)
    public void sort(int[] a){
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length ; j++) {
                if(a[j - 1] > a[j]){
                    sw(a,j,j-1);
                }
            }
        }
    }

    public void sw(int[] a,int i,int j){
        a[i] = a[j] ^ a[i];
        a[j] = a[j] ^ a[i];
        a[i] = a[j] ^ a[i];
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] ints = {1, 1, 2, 8, 3, 1, 6, 4, 5};
        bubbleSort.sort(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
