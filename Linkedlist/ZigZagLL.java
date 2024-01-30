public class ZigZagLL {
    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    static void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

    static void zigZagList(Node head){
        int temp = 0;

        boolean flag = true;

        Node curr = head;
        while(curr != null && curr.next != null){
            if(flag == true){
                if(curr.data > curr.next.data){
                    temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }
            else {
                if(curr.data < curr.next.data){
                    temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }

            curr= curr.next;
            flag = !flag;
        }
    }

    static void printList(Node head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(6);
        push(8);
        push(7);
        push(3);
        push(4);

        System.out.println("Given linked list ");
        printList(head);

        zigZagList(head);

        System.out.println("Zig Zag Linked list ");
        printList(head);
    }
}
