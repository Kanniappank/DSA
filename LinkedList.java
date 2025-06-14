
import java.util.ArrayList;


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

        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private <T> boolean hasCycle(Node<T> head) {
        /*
         * Bute force
         * use hasing to find whether the node repeats or not
         * time complexity O(N)
         * space complexity O(N) additional hash map is used
         */

        // Map<Node,Integer> hash = new HashMap();
        // Node temp = head;
        // while(temp!=null){
        // if(hash.containsKey(temp)){
        // return true;
        // }
        // hash.put(temp,1);
        // temp=temp.next;
        // }
        // return false;

        /*
         * Optimal approach tortiose and haris method
         * use fast and slow pointers
         * fast moves by one pointer slow moves by 2 pointers
         * if slow and fast pointer meets there is a loop return true else return false
         */

        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    private <T> Node<T> detectCycle(Node<T> head) {
        /*
         * Brute force
         * use hasing to check which node repeates first and it is the starting of the
         * loop
         */
        // Node<T> temp = head;
        // Map<Node<T>,Integer> hash = new HashMap<>();
        // while(temp!=null){
        // if(hash.containsKey(temp)){
        // return temp;
        // }
        // hash.put(temp, 1);
        // temp=temp.next;
        // }
        // return null;

        /*
         * Optimal approach
         * use tortoise and haris method
         * use slow and fast pointer slow moves by one fast moves by two
         * if slow and fast meet move any one of the pointer one by one count the
         * movement while counting
         * poiters will be equal at that point return the
         */

        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) { // till fast and slow meets
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;

    }

    private <T> Node<T> reverseLL(Node head) {
        /*
         * Brute force
         * add each element to the stack
         * iterate again set each element in the stack to each node
         * 
         */
        // Node temp = head;
        // Stack stk = new Stack();
        // while(temp!=null){
        // stk.add(temp.data);
        // temp=temp.next;
        // }
        // System.out.println(stk);
        // temp=head;
        // while(temp!=null){
        // temp.data=stk.peek();
        // stk.pop();
        // temp=temp.next;
        // }
        // return head;

        /* optimal approach */
        // Node temp = head;
        // Node prev = null;
        // while (temp != null) {
        // Node front = temp.next; // step-1 preserve the front node
        // temp.next = prev; // step-2 reverse the link
        // prev = temp; // step-3 move prev to the current node
        // temp = front; // step-4 move temp to the front node (i.e) next node
        // }
        // return temp;

        /* Recursive approach */

        if (head == null || head.next == null) {
            return head;
        }
        Node<T> newHead = reverseLL(head.next);
        Node<T> front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    private <T> boolean isPalindrome(Node<T> head) {
        /*
         * Brute force
         * use a stack variable add the nodes to the stack
         * iterate again
         * take elements from stack in the each iteration
         * compare with the current node if any one of the comparison fails
         * return false
         * else iterate throughout the end and return true
         */
        // Stack<T> stk = new Stack<>();
        // Node<T> temp = head;
        // while (temp != null) {
        // stk.add(temp.data);
        // temp = temp.next;
        // }
        // temp = head;
        // while (temp != null) {
        // if (temp.data != stk.peek()) {
        // return false;
        // }
        // stk.pop();
        // temp=temp.next;
        // }
        // return true;

        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node<T> newHead = this.reverseLL(slow.next);
        Node<T> first = head;
        Node<T> second = head;
        while (second != null) {
            if (first.data != second.data) {
                this.reverseLL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        this.reverseLL(newHead);
        return true;

    }

    private <T> Node<T> oddEvenList(Node<T> head) {
        // if(head==null || head.next==null){
        // return head;
        // }
        // Node<T> temp = head;
        // List<T> arr = new ArrayList<>();
        // while(temp!=null && temp.next!=null){
        // arr.add(temp.data);
        // temp=temp.next.next;
        // }
        // if(temp!=null){
        // arr.add(temp.data);
        // }
        // temp=head;
        // temp=temp.next;
        // while(temp!=null && temp.next!=null){
        // arr.add(temp.data);
        // temp=temp.next.next;
        // }
        // if(temp!=null){
        // arr.add(temp.data);
        // }
        // temp = head;
        // int i=0;
        // while(temp!=null){
        // temp.data=arr.get(i);
        // i++;
        // temp=temp.next;
        // }
        // return head;

        if (head == null || head.next == null) {
            return head;
        }

        Node<T> odd = head;
        Node<T> even = head.next;
        Node<T> evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next;
            odd = odd.next;
            even = even.next.next;
        }
        odd.next = evenHead;
        return head;
    }

    private <T> int findLengthOfLoop(Node<T> head) {
        /*
         * Brute force approach
         * use hashing to find the hasing to preserve the position of the each node
         * check wheather it is already avaliable in the hash before adding
         * if it is available subtract the current count the count stored in the re
         * accouring node
         * that is the length of the loop
         * time complexity O(N)
         * space Complexity O(N)
         */

        // Node temp = head;
        // Map<Node,Integer> hash = new HashMap<>();
        // int count=0;
        // while(temp!=null){
        // count++;
        // if(hash.containsKey(temp)){
        // return count-hash.get(temp);
        // }
        // hash.put(temp, count);
        // temp=temp.next;
        // }
        // return 0;

        /*
         * Optimal approach
         * use tortoise and hare method after fast and slow met
         * it is the intersection point at the intersection move any one ot the point
         * one by one step
         * till it reaches the another if they meet count the steps it is the loops
         * count
         */

        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return loopCount(fast, slow);
            }
        }
        return 0;
    }

    private <T> int loopCount(Node<T> fast, Node<T> slow) {
        int count = 0;
        while (slow != fast) {
            count++;
        }
        return count;
    }

    private <T> Node<T> sortLinkedList(Node<T> head){
        /*Brute force solution 
         * add the elements of the linked list to the arrray
         * sort the array 
         * again iterate through the linked list add the element one by one
         * to the linked list
         */
        // Node<T> temp=head;
        // ArrayList<T> arr = new ArrayList<>();
        // while(temp!=null){
        //     arr.add(temp.data);
        //     temp=temp.next;
        // } 
        // arr.sort(null);
        // System.out.println("Array"+arr);
        // temp=head;
        // int count=0;
        // while(temp!=null){
        //     temp.data=arr.get(count);
        //     temp=temp.next;
        //     count++;
        // }
        // return head;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 4, 7, 8, 9, 1, 0 };
        LinkedList testList = new LinkedList();

        Node<Integer> head = testList.convertArray2LinkedList(arr);
        testList.printLinkedList(head);
        System.out.println();
        // testList.printLinkedList(testList.reverseLL(head));
        // System.out.println();
        testList.printLinkedList(testList.sortLinkedList(head));

    }
}
