
public class DoublyLinkedList {
    class Node<T> {
        T data;
        Node<T> back;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.back = null;
            this.next = null;
        }

        Node(T data, Node<T> next, Node<T> back) {
            this.data = data;
            this.back = back;
            this.next = next;
        }
    }

    private <T> Node<T> convertArraytoDLL(T[] arr) {
        Node<T> head = new Node<>(arr[0]);
        Node<T> prev = head;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            Node<T> temp = new Node<>(arr[i], null, prev);
            prev.next = temp;
            prev = temp; // move the prev to the next node i.e. temp.
        }
        return head;
    }

    private <T> void printDoublyLinkedList(Node<T> head) {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private <T> Node<T> deleteAtHead(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<T> prev = head;
        head = head.next;
        prev.next = null;
        head.back = null;
        return head;
    }

    private <T> Node<T> deleteTailNode(Node<T> head) {
        Node<T> temp = head;
        if (head == null || head.next == null) {
            return head;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        Node<T> prev = temp.back;
        prev.next = null;
        temp.back = null;
        return head;
    }

    private <T> Node<T> deleteAtKthPosition(Node<T> head, int position) {
        if (head == null) {
            return head;
        }
        if (position == 1) {
            return this.deleteAtHead(head);
        }

        int count = 1;
        Node<T> temp = head;
        while (temp != null) {
            if (count == position) {

                Node<T> prev = temp.back;
                Node<T> next = temp.next;
                if (prev == null && next == null) {
                    return null;
                }
                if (next == null) {
                    return this.deleteTailNode(head);
                }
                prev.next = next;
                next.back = prev;
                temp.next = null;
                temp.back = null;
                break;
            } else {
                temp = temp.next;
                count++;

            }
        }
        return head;
    }

    private <T> void deleteNode(Node<T> head) {
        Node<T> prev = head.back;
        Node<T> next = head.next;

        if (next == null) {
            prev.next = null;
            head.back = null;
            return;
        }
        prev.next = next;
        next.back = prev;

        head.next = null;
        head.back = null;

    }

    private <T> Node<T> insertBeforeHead(Node<T> head, T value) {
        Node<T> newNode = new Node<>(value, head, null);
        if (head != null) {
            head.back = newNode;
        }
        return newNode;
    }

    private <T> Node<T> insertBeforeTail(Node<T> head, T value) {
        if (head.next == null) {
            return this.insertBeforeHead(head, value);
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node<T> prev = temp.back;
        Node<T> newNode = new Node<>(value, temp, prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }

    private <T> Node<T> insertAtkthPosition(Node<T> head, int position, T value) {
        if (position == 1) {
            return this.insertBeforeHead(head, value);
        }
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            if (count == position)
                break;
            temp = temp.next;

        }
        if (temp == null) {
            return this.insertBeforeTail(head, value);
        }
        Node<T> prev = temp.back;
        Node<T> newNode = new Node<>(value, temp, prev);
        if (prev != null) {
            prev.next = newNode;
        }
        temp.back = newNode;
        return head;
    }

    private <T> void insertBeforeNode(Node<T> head, T value) {
        Node prev = head.back;
        Node<T> newNode = new Node<>(value,head,prev);
        prev.next=newNode;
        head.back=newNode;
    }

    public static void main(String[] args) {

        DoublyLinkedList testList = new DoublyLinkedList();
        Integer[] arr = { 3, 5, 7, 8, 6, 9 };
        testList.printDoublyLinkedList(testList.convertArraytoDLL(arr));
        Node<Integer> head = testList.convertArraytoDLL(arr);
        System.out.println("Delete Head");
        // testList.printDoublyLinkedList(testList.deleteAtHead(head));
        // System.out.println("Delete Tail");
        testList.printDoublyLinkedList(testList.deleteTailNode(head));
        System.out.println("Delete at kth position");
        // testList.printDoublyLinkedList(testList.deleteAtKthPosition(head, 1));
        // System.out.println("New node at head");
        testList.printDoublyLinkedList(testList.insertBeforeHead(head, 100));
        System.out.println("Insert before tail");
        testList.printDoublyLinkedList(testList.insertBeforeTail(head, 200));
        System.out.println("Insert at position");
        testList.printDoublyLinkedList(testList.insertAtkthPosition(head, 8, 300));
        System.out.println("Insert before node");
        testList.insertBeforeNode(head.next.next.next.next.next.next.next, 800);
        testList.printDoublyLinkedList(head);
    }
}
