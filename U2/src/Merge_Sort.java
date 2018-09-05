/**
 * @author LaZY（李志一）
 * @data 2018/9/5 - 16:04
 */
public class Merge_Sort {
    /***
     *
     * 归并排序
     *
     *  1.将数组分为两部分
     *  2.将每一部分的数组归并排序
     *  3.将两部分合并
     *
     * @param a 待排序的数组
     * @param p 数组的起始位置
     * @param r 数组的末尾位置
     */
    public static void merge_sort(int a[],int p,int r){
        int q = (p + r)/2;
        if (q<p){
            merge_sort(a,p,q);
            merge_sort(a,q+1,r);
            merge(a,p,q,r);
        }
    }

    /***
     * 归并排序的外部方法
     * @param a
     */
    public static void merge_sort(int a[]){
        int p = 0;
        int r = a.length;
        merge_sort(a,p,r);
    }

    /***
     * 归并排序的合并
     *
     *  1.将（两部分排完序的）数组分成两个数组进行排序
     *  2.在每个数组的最后面加上哨兵（一个很大的数，用来标识数组到了尽头）
     *  3.对每个数组最上面的数字进行比较，较小的复制到最初的数组中（没分裂的数组）
     *
     * @param a 待排序的数组（分界点前后必须已经排好序）
     * @param p 排序的起始位置
     * @param q 排序的分界位置
     * @param r 排序的末尾位置
     *
     */
    public static void merge(int a[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int L[] = new int[n1 + 1];
        int R[] = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = a[p + i];

        }
        for (int i = 0; i < n2; i++) {
            R[i] = a[q + 1 + i];
        }
        L[n1] = 9999999;
        R[n2] = 9999999;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] < R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 4, 5, 7, 1, 2, 3, 6};
        merge(arr, 0, 3, 7);
        //check result：
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

        System.out.println();

        int arr1[] = new int[]{5,2,4,7,1,3,2,6};
        merge_sort(arr1);
        //check result：
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
