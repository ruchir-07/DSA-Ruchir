public class DelLesserNodes {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    void delLesserNodes(){
        reverseList();

        delNodes();

        reverseList();
    }

    void delNodes(){
        Node temp, curr = head, maxNode = head;

        while (curr != null && curr.next != null){
            if(curr.next.data < maxNode.data){
                temp = curr.next;
                curr.next = temp.next;
                temp = null;
            }
            else {
                curr = curr.next;
                maxNode = curr;
            }
        }
    }

    void reverseList(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }


    public static void main(String[] args) {
        DelLesserNodes llist = new DelLesserNodes();

        /* Constructed Linked List is 12->15->10->11->
           5->6->2->3 */
        llist.push(3);
        llist.push(2);
        llist.push(6);
        llist.push(5);
        llist.push(11);
        llist.push(10);
        llist.push(15);
        llist.push(12);

        System.out.println("Given Linked List");
        llist.printList();

        llist.delLesserNodes();

        System.out.println("Modified Linked List");
        llist.printList();
    }
}
