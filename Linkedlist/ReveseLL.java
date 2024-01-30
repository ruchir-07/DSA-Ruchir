import java.util.LinkedList;

public class ReveseLL {
    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node reverse(Node node){
        Node prev = null;
        Node curr = node;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        node = prev;
        return node;
    }

    static void printList(Node node){
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        head = new Node(85);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);

        System.out.println("Given linked list");
        printList(head);
        head = reverse(head);
        System.out.println();
        System.out.println("Reversed linked list ");
        printList(head);
    }
}
