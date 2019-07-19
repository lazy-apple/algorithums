/**输入一个链表，输出该链表中倒数第k 个结点．为了符合大多数人的习惯，本题从1 开始计数，即链表的尾结点是倒数第1 个结点．例如一个链表有6 个结点，从头结点开始它们的值依次是1 、2、3、4、5 、6。这个个链表的倒数第3 个结点是值为4 的结点．
 *
 *
 * 解题思路：两个指针，第一个先走k-1步，第二个一直不动，然后两个指针一起走，第一个指针走到尾部，第二个指针就来到了倒数第k个
 * @author LaZY(李志一)
 * @create 2019-07-19 21:01
 */
public class Test15 {
    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode findKthToTail(ListNode node, int k){
        if(node == null){
            return null;
        }
        ListNode p1 = node;
        ListNode p2 = node;
        for (int i = 0; i < k - 1; i++) {
            if (p1.next == null){
                return null;
            }
            p1 =  p1.next;
        }
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

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

        System.out.println(findKthToTail(head, 1).value); // 倒数第一个
        System.out.println(findKthToTail(head, 5).value); // 中间的一个
        System.out.println(findKthToTail(head, 9).value); // 倒数最后一个就是顺数第一个

        System.out.println(findKthToTail(head, 10));
    }
}
