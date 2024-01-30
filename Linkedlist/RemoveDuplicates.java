public class RemoveDuplicates {
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

    public void removeDuplicates(){
        Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;

        while (ptr1 != null && ptr1.next != null){
            ptr2 = ptr1;

            while (ptr2.next != null){
                if(ptr1.data == ptr2.next.data)
                    ptr2.next = ptr2.next.next;
                else
                    ptr2 = ptr2.next;
            }

            ptr1 = ptr1.next;
        }
    }

    public void printList(){
        Node tnode = head;
        while (tnode != null){
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicates list = new RemoveDuplicates();
        list.push(10);
        list.push(12);
        list.push(11);
        list.push(11);
        list.push(12);
        list.push(11);

        list.removeDuplicates();
        list.printList();
    }
}
