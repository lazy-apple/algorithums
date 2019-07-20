/**
 * 单链表快速排序
 * partition：
 * 引入两个指针，第一个指针的前面保证都是比头结点小的，
 *              第一个和第二个指针中间保证是比头结点大的，
 *              最后，交换第一个指针和头结点的值
 *
 *
 * @author LaZY(李志一)
 * @create 2019-07-20 19:41
 */
public class ListNodeQuickSort {
    public class ListNode {
        ListNode next;
        int val;

        public ListNode(int data) {
            this.val = data;
        }
    }

    public ListNode sortList(ListNode head){
        quickSort(head,null);
        return head;
    }

    public void quickSort(ListNode start,ListNode end){
        if(start != end){
            ListNode node = partition(start, end);
            quickSort(start,node);
            quickSort(node.next,end);
        }
    }
    public ListNode partition(ListNode start,ListNode end){
        ListNode p1 = start;
        ListNode p2 = start.next;
        while (p2 != end){
            if(start.val> p2.val){
                p1 = p1.next;
                swap(p1,p2);
            }
            p2 = p2.next;
        }
        if(p1 != start){
            swap(start,p1);
        }
        return p1;
    }

    private void swap(ListNode p1, ListNode p2) {
        int t = p1.val;
        p1.val = p2.val;
        p2.val = t;
    }
}
