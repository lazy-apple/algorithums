/**单链表相交
 *
 * 解题思路：
 *  链表无环：
 *          -相交
 *          不相交
 *  链表有环：
 *          -入环节点相同
 *          入环节点不同：
 *                  -不相交
 *                  -相交
 * @author LaZY(李志一)
 * @create 2019-07-21 14:23
 */
public class ListNodeHaveO {
    public static class ListNode{
        ListNode next;
        int val;
    }

    public static class NodeMes{
        ListNode node;
        int len;
        public NodeMes(ListNode node,int len){
            this.node = node;
            this.len = len;
        }
    }

    public boolean test(ListNode node1,ListNode node2){
        if(check(node1) || check(node2)){
            return false;
        }
        ListNode hasNode1 = hasO(node1);
        ListNode hasNode2 = hasO(node2);
        if((hasNode1 !=null && hasNode2 ==null)||(hasNode2 !=null && hasNode1 ==null)){
            return false;
        }else if(hasNode1 ==null && hasNode2 ==null){//都没环
            NodeMes mes1 = getTail(node1,null);
            NodeMes mes2 = getTail(node2,null);
            if(mes1.node != mes2.node){
                return false;
            }
           getPointNoO(mes1.len,mes2.len,node1,node2);//返回的结果
            return true;
        }else {//都有环
            NodeMes mes1 = getTail(node1,hasNode1);
            NodeMes mes2 = getTail(node2,hasNode2);
            if(mes1.node != mes2.node){
                //入环节点不相同
            }else {
                //入环节点相同
            }
        }
        return false;
    }

    public boolean check(ListNode node){
        return node == null;
    }

    /***
     *是否有环，有环返回入环节点
     * @param head
     * @return 返回null，代表无环
     */
    public ListNode hasO(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != slow){
            if(fast == null || slow == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    public boolean sanmeO(ListNode node1,ListNode node2){
        return hasO(node1) == hasO(node2);
    }

    public NodeMes getTail(ListNode head,ListNode tail){
        int length = 0;
        while (head != tail && head.next != tail){
            head = head.next;
            length ++;
        }
        return new NodeMes(head,length + 1);
    }

    public ListNode getPointNoO(int len1,int len2,ListNode node1,ListNode node2){
        ListNode firstNode = len1 > len2 ? node1 : node2;
        ListNode lastNode = len1 < len2 ? node1 : node2;
        int len = Math.abs(len1 - len2);
        for (int i = 0; i < len; i++) {
            firstNode = firstNode.next;
        }
        while (firstNode != lastNode){
            firstNode = firstNode.next;
            lastNode = lastNode.next;
        }
        return firstNode;
    }

}
