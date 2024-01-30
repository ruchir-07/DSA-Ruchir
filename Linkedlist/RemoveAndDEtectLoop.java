public class RemoveAndDEtectLoop {
    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public void printList(Node node){
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    void detectAndRemoveLoop(Node node){
        if(node == null || node.next == null)
            return;
        Node fast = node, slow = node;
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && slow != null){
            if(slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        /* If loop exists */
        if (slow == fast){
            slow = node;
            if (slow != fast){
                while (slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }

                /* since fast->next is the looping point */
                fast.next = null; // remove loop
            }

            /* This case is added if fast and slow pointer meet at first position. */
            else {
                while (fast.next != slow){
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }

    public static void main(String[] args) {
        RemoveAndDEtectLoop list = new RemoveAndDEtectLoop();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}
