public class MergeLL {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node mergeTwoLists(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node mergeHead;
        if (head1.data <= head2.data) {
            mergeHead = head1;
            head1 = head1.next;
        } else {
            mergeHead = head2;
            head2 = head2.next;
        }

        Node mergeTail = mergeHead;
        while (head1 != null && head2 != null) {
            Node temp;
            if (head1.data <= head2.data) {
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }

            mergeTail.next = temp;
            mergeTail = temp;
        }

        if (head1 != null)
            mergeTail.next = head1;
        else if (head2 != null)
            mergeTail.next = head2;

        return mergeHead;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(3);
        head1.next = new Node(5);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(10);
        head1.next.next.next.next = new Node(15);

        Node head2 = new Node(2);
        head2.next = new Node(7);
        head2.next.next = new Node(11);

        Node mergedLL = mergeTwoLists(head1, head2);
        printList(mergedLL);
    }
}
