public class RemoveNthNodeFromEnd {
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

    public void removeNthNodeFromEnd(Node head, int n){
        Node fast = head;
        Node slow = head;

        for(int i=0 ;i<n; i++){
            if(fast.next == null){
                if (i == n-1){
                    head = head.next;
                }
                return;
            }
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        if(slow.next != null){
            slow.next = slow.next.next;
        }
    }

    public void printlist(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd list = new RemoveNthNodeFromEnd();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);

        list.removeNthNodeFromEnd(list.head, 6);
        list.printlist(list.head);
    }
}
