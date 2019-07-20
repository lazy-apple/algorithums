/**
 * @author LaZY(李志一)
 * @create 2019-07-20 19:26
 */
public class QuickSort {
    private void Qsort(int[] list, int low, int high){
        int privot;
        if(low < high) {
            print(list);
            /*算出枢轴值privot*/
            privot = Partition(list, low, high);
            /*对低子表递归排序*/
            Qsort(list, low, privot-1);
            /*对高子表递归排序*/
            Qsort(list, privot+1, high);
        }
    }

    private int Partition(int[] list, int low, int high){
        /*用表的第一个记录做枢轴记录*/
        int privotkey = list[low];
        while (low < high){
            while (low < high && list[high] > privotkey)
                high--;
            /*将比枢轴记录小的记录交换到低端*/
            swap(list, low, high);
            while (low < high && list[low] < privotkey)
                low++;
            /*将比枢轴记录大的记录交换到高端*/
            swap(list, low, high);
        }
        /*返回枢轴所在的位置*/
        return low;
    }

    private void swap(int [] list,int j, int i){
        int temp;
        temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private void print(int[] data) {
        System.out.println("当前list数组的值：");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] list = {50,40,80,30,60,70,10,90,20};
        QuickSort qs = new QuickSort();
        qs.Qsort(list, 0, list.length-1);
        qs.print(list);
    }
}
