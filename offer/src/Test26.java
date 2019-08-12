/**题目：复制复杂链表
 * @author LaZY(李志一)
 * @create 2019-08-08 23:37
 */
public class Test26 {
    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }
    public static ComplexListNode clone(ComplexListNode head) {
        // 如果链表为空就直接返回空
        if (head == null) {
            return null;
        }

        // 先复制结点
        cloneNodes(head);
        // 再链接sibling字段
        connectNodes(head);
        // 将整个链表拆分，返回复制链表的头结点
        return reconnectNodes(head);
    }

    private static ComplexListNode reconnectNodes(ComplexListNode head) {
        ComplexListNode newhead = head.next;
        ComplexListNode curCop = newhead;
        head.next = curCop.next;
        head = head.next;

        while (head != null){
            curCop.next = head.next;
            curCop = head.next;
            head.next = curCop.next;
            head = curCop.next;
        }
        return newhead;
    }

    private static void connectNodes(ComplexListNode head) {
        while (head != null){
            if (head.sibling != null) {
                head.next.sibling = head.sibling.next;//注意空指针
            }
            head = head.next.next;
        }
    }

    private static void cloneNodes(ComplexListNode head) {
        while(head != null){
            ComplexListNode newhead = new ComplexListNode();
            newhead.value = head.next.value;
            newhead.next = head.next;
            head.next = newhead;
            head = newhead.next;
        }
    }

}
