public class SortLL012 {
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
        head= newNode;
    }

    public void printList(){
        Node tnode =head;
        while (tnode != null){
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public void sortList(){
        int[] count = {0, 0, 0};
        Node ptr = head;

        while (ptr != null){
            count[ptr.data]++;
            ptr = ptr.next;
        }

        ptr = head;
        int i=0;

        while (ptr != null){
            if(count[i] == 0)
                i++;
            else{
                ptr.data = i;
                --count[i];
                ptr = ptr.next;
            }
        }
    }

    public static void main(String[] args) {
        SortLL012 llist = new SortLL012();

        llist.push(0);
        llist.push(1);
        llist.push(0);
        llist.push(2);
        llist.push(1);
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(2);

        System.out.println("Linked List before sorting");
        llist.printList();
        System.out.println();

        llist.sortList();

        System.out.println("Linked List after sorting");
        llist.printList();
    }
}
