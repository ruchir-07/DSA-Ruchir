public class MultiplyLL {
    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    static long multiplyTwoLists(Node l1, Node l2){
        long N = 1000000007;
        long num1 = 0, num2 = 0;

        while (l1 != null || l2 != null){
            if(l1 != null){
                num1 = (num1*10)%N + l1.data;
                l1 = l1.next;
            }
            if(l1 != null){
                num2 = (num2*10)%N + l2.data;
                l2 = l2.next;
            }
        }

        return ((num1%N)*(num2%N))%N;
    }

    public static void printList(Node head){
        while (head != null){
            System.out.print(head.data);
            if(head.next != null)
                System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node list1 = new Node(9);
        list1.next = new Node(4);
        list1.next.next = new Node(6);
        System.out.println("First List:");
        printList(list1);

        Node list2 = new Node(8);
        list2.next = new Node(4);
        System.out.println("Second List:");
        printList(list2);

        System.out.print("Result is: ");
        System.out.println(multiplyTwoLists(list1, list2));
    }
}
