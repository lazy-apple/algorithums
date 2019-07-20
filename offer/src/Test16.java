/**定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * 解题思路：三指针
 * @author LaZY(李志一)
 * @create 2019-07-20 8:00
 */
public class Test16 {
    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode reverseList(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode pHead = node;
        ListNode pCur = node.next;
        ListNode pNext ;
        node.next = null;

        while (pCur != null){
            pNext = pCur.next;
            pCur.next = pHead;
            pHead = pCur;
            pCur = pNext;

        }
        return pHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        printList(head);
        head = reverseList(head);
        printList(head);

    }
}
