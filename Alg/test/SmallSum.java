/**
 * @author LaZY(李志一)
 * @create 2019-07-17 19:25
 */
public class SmallSum {
    public void SmallSum(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    public void mergeSort(int[] a, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + ((r - l) >> 1);
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        a = merger(a, l, m, r);
    }

    public int[] merger(int[] a, int l, int m, int r) {
        int[] arr = new int[r - l + 1];
        int arrIndex = 0;
        int pl = l;
        int pr = m + 1;
        int sum = 0;
        while (pl <= m && pr <= r) {
            sum += a[pl] < a[pr] ? a[pl] *(r - pl + 1): 0;
            a[arrIndex++] = a[pl] < a[pr] ? a[pl++] : a[pr++];
        }
        while (pl <= m) {
            a[arrIndex++] = a[pl++];
        }
        while (pr <= r) {
            a[arrIndex++] = a[pr++];
        }

        for (int i = 0; i < arr.length; i++) {
            a[i + l] = arr[i];
        }
        return a;
    }
    public static void main(String[] args) {
        SmallSum bubbleSort = new SmallSum();
        int[] ints = {1, 1, 2, 8, 3, 1, 6, 4, 5};
        bubbleSort.SmallSum(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
