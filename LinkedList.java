
public class LinkedList {

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<Integer> convertArray2LinkedList(int[] arr) {
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node<Integer> temp = new Node<>(arr[i]);
            mover.next = temp;
            mover = temp; // used to move to the next next nodesxt next nodes
        }
        return head;
    }

    private static int linkListLength(Node<Integer> head) {
        int count = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private void printLinkedList(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    private boolean isPresent(Node<Integer> head, int num) {
        Node<Integer> temp = head;
        while (temp != null) {
            if (temp.data == num) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private <T> Node<T> removeHead(Node<T> head) {
        if (head == null)
            return head;
        head = head.next;
        return head;
    }

    private <T> Node<T> removeTail(Node<T> head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private <T> Node<T> removeAtPosition(Node<T> head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 1) {
            return removeHead(head);
        }
        int count = 1;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            if (count == k) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private <T> Node<T> removeANodeAtvalue(Node<T> head, int value) {
        if (head == null) {
            return null;
        }
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(value)) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private <T> Node<T> insertAtHead(Node<T> head, T value) {
        Node<T> temp = new Node(value);
        temp.next = head;
        return temp;
    }

    private <T> Node<T> insertAtTail(Node<T> head, T data) {
        if (head == null) {
            return new Node<>(data);
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node<T> newNode = new Node<>(data);
        temp.next = newNode;
        return head;
    }

    private <T> Node<T> insertAtPosition(Node<T> head, int position, T data) {
        if (head == null) {
            if (position == 1)
                return new Node<>(data);
            else
                throw new RuntimeException("the given position is not in the linked list");
        }
        if (position == 1) {
            return new Node<>(data);
        }

        Node<T> temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            if (count == position - 1) {
                Node<T> newNode = new Node<>(data);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    private <T> Node<T> insertAtValue(Node<T> head, T value, T data) {
        if (head == null) {
            return new Node<>(data);
        }
        if (head.data == value) {
            return new Node<>(data);
        }
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                Node<T> newNode = new Node<>(data);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    private <T> Node<T> returnTheMidNode(Node<T> head) {

        /*
         * Brute force
         * iterate throught the linked list
         * count the number of linked list
         * find the mid using mid = (count/2)+1;
         * set temp = head again
         * iterate again reduce mid by one for each iteration
         * it mid reaches 0 it is the mid node
         */
        // int count = 0;
        // Node temp = head;
        // while (temp != null) {
        // count++;
        // temp = temp.next;
        // }
        // temp = head;
        // int mid = (count / 2) + 1;
        // System.out.println("Mid " + mid);
        // while (temp != null) {
        // mid--;
        // if (mid == 0)
        // break;
        // temp = temp.next;
        // }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 4, 7, 8, 9, 1, 0 };
        LinkedList testList = new LinkedList();

        Node<Integer> head = testList.convertArray2LinkedList(arr);
        testList.printLinkedList(head);
        System.out.println("Linked list length " + linkListLength(head));
        System.out.println(testList.isPresent(head, 6));
        testList.printLinkedList(testList.removeHead(head));
        System.out.println();
        testList.printLinkedList(testList.removeTail(head));
        System.out.println();
        testList.printLinkedList(head);
        System.out.println();
        // testList.printLinkedList(testList.removeANodeAtvalue(head, 5));
        System.out.println();
        testList.printLinkedList(testList.insertAtHead(head, 17));
        System.out.println("priting linked list");
        testList.printLinkedList(head);
        System.out.println("Printing the mid node");
        System.out.println(testList.returnTheMidNode(head).data);
    }
}
