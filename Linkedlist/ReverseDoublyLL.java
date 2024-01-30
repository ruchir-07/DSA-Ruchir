public class ReverseDoublyLL {

    static Node head;

    static class Node {

        int data;
        Node next, prev;

        Node(int d)
        {
            data = d;
            next = prev = null;
        }
    }

    void reverse(){
        Node temp = null;
        Node curr = head;

        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if(temp != null){
            head = temp.prev;
        }
    }

    void push(int data){
        Node newNode = new Node(data);
        newNode.prev = null;
        newNode.next = head;

        if (head != null){
            head.prev = newNode;
        }

        head = newNode;
    }

    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ReverseDoublyLL list = new ReverseDoublyLL();

        /* Let us create a sorted linked list to test the
         functions Created linked list will be 10->8->4->2
       */
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);

        System.out.println("Original linked list ");
        list.printList(head);

        // Function call
        list.reverse();

        System.out.println("");
        System.out.println("The reversed Linked List is ");
        list.printList(head);
    }
}
