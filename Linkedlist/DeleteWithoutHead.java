public class DeleteWithoutHead {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void deleteNode(Node head){
        Node temp = head.next;
        head.data = temp.data;
        head.next = temp.next;
    }

    public void printList(Node head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        DeleteWithoutHead list = new DeleteWithoutHead();
        list.push(2);
        list.push(4);
        list.push(1);
        list.push(12);
        list.push(1);

        System.out.println("List before deleting");
        list.printList(list.head);

        list.deleteNode(list.head);
        System.out.println();

        System.out.println("List after deleting");
        list.printList(list.head);
    }
}
