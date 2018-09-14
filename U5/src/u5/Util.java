package u5;

/**
 * @author LaZY（李志一）
 * @data 2018/9/14 - 14:18
 */
public class Util {
    /***
     * 获取数组中指定位置元素的值
     * @param a 指定的数组
     * @param i 指定的位置（索引）
     * @return 指定索引位置的值
     */
    public static int getElement(int a[],int i){
        return a[i];
    }

    /***
     * 拷贝指定数组并返回
     * @param a 要拷贝的数组
     * @return 拷贝出的数组
     */
    public static int[] copy(int a[]){
        int[] newa = new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            newa[i] = a[i];
        }
        return newa;
    }

    public static void sort(int a[],int fin[]){
        int newa[] = copy(a);
        int newfin[] = copy(fin);
        merge_sort(a);
        for (int i = 0; i <newa.length ; i++) {
            for (int j = 0; j <a.length ; j++) {
                if (newa[i]==a[j]){
                    int element = getElement(newfin, i);
                    fin[j] = element;
                }
            }
        }
    }

    public static void merge_sort(int a[],int p,int r){
        if (p<r){
            int q = (p + r)/2;
            merge_sort(a,p,q);
            merge_sort(a,q+1,r);
            merge(a,p,q,r);
        }
    }


    public static void merge_sort(int a[]){
        int p = 0;
        int r = a.length-1;
        merge_sort(a,p,r);
    }


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

//    public static void main(String[] args) {
//        int a[] = new int[]{1,2,3,4,5};
//        int ra[] = new int[]{20,19,18,10,11};
//        sort(ra,a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//    }
}
