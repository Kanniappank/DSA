

public class DoublyLinkedList {
    class Node<T> {
        T data;
        Node back;
        Node next;

        Node(T data) {
            this.data = data;
            this.back = null;
            this.next = null;
        }

        Node(T data, Node next, Node back) {
            this.data = data;
            this.back = back;
            this.next = next;
        }
    }

    private Node convertArraytoDLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        int len = arr.length;
        for(int i=1;i<len;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next=temp;
            prev=temp; // move the prev to the next node i.e. temp.
        }
        return head;
    }
    private void printDoublyLinkedList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList testList = new DoublyLinkedList();
        int[] arr = {3,5,7,8,6,9};
        testList.printDoublyLinkedList(testList.convertArraytoDLL(arr));

    }
}
