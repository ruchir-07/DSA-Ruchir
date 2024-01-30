public class LinkedListCycle {
    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    static boolean hasCycle(Node head){
        if(head == null){
            return false;
        }

        Node s1 = head;
        Node s2 = head.next;

        while(true){
            if(s1 == null || s2 == null || s2.next == null)
                return false;
            else if (s1 == s2)
                return true;

            s1 = s1.next;
            s2 = s2.next.next;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // Creating a cycle

        System.out.println("List without cycle has cycle: " + hasCycle(head));
    }
}
