/**
 * @author flycottle
 * @version 1.0
 * @date 2019/7/20
 */


public class 链表实现快速排序 {
    public class ListNode {
        ListNode next;
        int val;

        public ListNode(int data) {
            this.val = data;
        }
    }

    public ListNode sortList(ListNode head) {
        quicksort(head, null);
        return head;
    }


    public static void quicksort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partion(head, end);
            quicksort(head, node);
            quicksort(node.next, end);
        }
    }

    public static ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != end) {
            if (head.val > p2.val) {
                p1 = p1.next;
                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }
        if (p1 != head) {
            int tmp = p1.val;
            p1.val = head.val;
            head.val = tmp;
        }
        return p1;
    }


}
