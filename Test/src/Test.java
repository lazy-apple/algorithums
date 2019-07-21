import java.util.HashSet;
import java.util.Set;

/**
 * @author LaZY(李志一)
 * @create 2019-07-21 15:54
 */
public class Test {
    public static class Node {
        Node next;
        int val;

        public Node(int i){
            this.val = i;
        }
    }
    public static Node  getloop(Node head1, Node head2){
        Set<Node> set=new HashSet<>();
        Node p1=head1;
        Node p2=head2;
        while(p1!=null){
            p1=p1.next;
            set.add(p1);
        }
        while(p2!=null){
            if(set.contains(p2))break;
            p2=p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
        Node head2 = new Node(1);
        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getloop(head1, head2));

    }
}
