
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class DoublyLinkedList {

    public static class Node<T> {

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
            if (count == position) {
                break;
            }
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
        Node<T> prev = head.back;
        Node<T> newNode = new Node<>(value, head, prev);
        prev.next = newNode;
        head.back = newNode;
    }

    private <T> Node<T> insertAfterTail(Node<T> head, T value) {
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node<T> newNode = new Node<>(value, null, tail);
        tail.next = newNode;
        return head;
    }

    private <T> Node<T> reverseADoublyLinkedList(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        // brute force
        /*
         * travese through the DLL add data to the stack
         * again traverse through the DLL replace the data with the every data in DLL
         * time complexity
         */
        // Stack<T> stk=new Stack<>(); //space complexity O(N)
        // Node<T> temp = head;
        // while (temp!=null) {
        // stk.add(temp.data);
        // temp=temp.next;
        // } //O(N)
        // temp=head;
        // while(temp!=null){
        // temp.data=stk.peek();
        // stk.pop();
        // temp=temp.next;
        // }//O(N)
        // time complexity O(2N)

        // Optimal approach
        /*
         * idea is to turn the pointers front to back and back to front
         * iterate throught the array caputure the last address
         * and replace the back address with next
         * and next to last
         * through we can turn the point this is as simple as swapping the numbers
         * 
         * temp = a
         * a=b
         * b=temp
         * 
         * at the end return the last.back which will be the new head
         */
        Node<T> last = null;
        Node<T> temp = head;
        while (temp != null) {
            last = temp.back;
            temp.back = temp.next;
            temp.next = last;
            temp = temp.back;
        }
        return last.back;
    }

    public <T> Node<T> deleteAllOccurrences(Node<T> head, int target) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(target)) {
                if (temp == head) {
                    head = head.next;
                }
                Node<T> nextNode = temp.next;
                Node<T> prevNode = temp.back;
                if (nextNode != null) {
                    nextNode.back = prevNode;
                }
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }
            }
            temp = temp.next;
        }
        return head;
    }

    public ArrayList<ArrayList<Integer>> findPairOfSum(Node<Integer> head, Integer target) {
        /*
         * Brute Force Approach:
         * Iterate through all possible pairs of nodes in the doubly linked list and check if their sum equals the target.
         * For each node, traverse the rest of the list to find a matching pair.
         * 
         * Time Complexity: O(N^2), where N is the number of nodes in the list, since for each node we may traverse the entire remaining list.
         * Space Complexity: O(1), ignoring the space used for the result list.
         */
        // Node<Integer> temp1 = head;
        // ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // while (temp1 != null) {
        //     Node<Integer> temp2 = temp1.next;
        //     while (temp2 != null) {
        //         Integer sum = temp1.data + temp2.data;
        //         if (Objects.equals(sum, target)) {
        //             res.add(new ArrayList<>(Arrays.asList(temp1.data, temp2.data)));
        //             if (sum > target) {
        //                 break;
        //             }
        //         }
        //         temp2 = temp2.next;
        //     }
        //     temp1 = temp1.next;
        // }
        // return res;

        /*
             * Optimal Approach:
             * Since the doubly linked list is sorted, we can use the two-pointer technique.
             * Initialize one pointer at the start (left) and one at the end (right) of the list.
             * Move the pointers towards each other:
             *   - If the sum of the two nodes is equal to the target, add the pair to the result and move both pointers.
             *   - If the sum is less than the target, move the left pointer forward.
             *   - If the sum is greater than the target, move the right pointer backward.
             * Time Complexity: O(N), where N is the number of nodes in the list.
             * Space Complexity: O(1), ignoring the space used for the result list.
         */
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        Node<Integer> left = head;
        Node<Integer> right = this.findTail(head);

        while (left.data < right.data) {
            Integer sum = left.data + right.data;
            if (Objects.equals(sum, target)) {
                res.add(new ArrayList<>(Arrays.asList(left.data, right.data)));
                left = left.next;
                right = right.back;
            } else if (sum > target) {
                right = right.back;
            } else {
                left = left.next;
            }
        }
        return res;
    }

    public <T> Node<T> findTail(Node<T> head) {
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public <T> Node<T> removeDuplicatesInSortedDLL(Node<T> head) {
        /*
         * This function removes duplicate elements from a sorted doubly linked list.
         * It iterates through the list, and for each node, skips all subsequent nodes with the same value.
         * The next pointer of the current node is updated to point to the first node with a different value,
         * and the back pointer of that node is updated accordingly.
         *
         * Time Complexity: O(N), where N is the number of nodes in the list, since each node is visited once.
         * Space Complexity: O(1), as no extra space is used except for a few pointers.
         */ Node<T> temp = head;
        while (temp != null && temp.next != null) {
            Node<T> newNode = temp.next;
            while (newNode != null && newNode.data == temp.data) {
                newNode = newNode.next;
            }
            temp.next = newNode;
            if (newNode != null) {
                newNode.back = temp;
            }
            temp = temp.next;
        }
        return head;
    }


    public static void main(String[] args) {

        DoublyLinkedList testList = new DoublyLinkedList();
        Integer[] arr = {1, 1, 2, 2, 3, 3, 3, 4, 5, 5, 6, 6, 7};
        testList.printDoublyLinkedList(testList.convertArraytoDLL(arr));
        Node<Integer> head = testList.convertArraytoDLL(arr);
        // System.out.println("Delete Head");
        // testList.printDoublyLinkedList(testList.deleteAtHead(head));
        // System.out.println("Delete Tail");
        // testList.printDoublyLinkedList(testList.deleteTailNode(head));
        // System.out.println("Delete at kth position");
        // testList.printDoublyLinkedList(testList.deleteAtKthPosition(head, 1));
        // System.out.println("New node at head");
        // testList.printDoublyLinkedList(testList.insertBeforeHead(head, 100));
        // System.out.println("Insert before tail");
        // testList.printDoublyLinkedList(testList.insertBeforeTail(head, 200));
        // System.out.println("Insert at position");
        // testList.printDoublyLinkedList(testList.insertAtkthPosition(head, 8, 300));
        // System.out.println("Insert before node");
        // testList.insertBeforeNode(head.next.next.next.next.next.next, 800);
        // testList.printDoublyLinkedList(head);
        // System.out.println("Insert after tail");
        // testList.printDoublyLinkedList(testList.insertAfterTail(head, 700));
        // System.out.println("REverse");
        // testList.printDoublyLinkedList(testList.reverseADoublyLinkedList(head));
        System.out.println(".()");
        testList.printDoublyLinkedList(testList.removeDuplicatesInSortedDLL(head));

    }
}
