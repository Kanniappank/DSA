
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

    private class NodeWithChild<T> {

        T data;
        NodeWithChild<T> next;
        NodeWithChild<T> child;

        public NodeWithChild(T data, NodeWithChild<T> next, NodeWithChild<T> child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }

        public NodeWithChild(T data) {
            this.data = data;
            this.next = null;
            this.child = null;
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
        if (head == null) {
            return head;
        }
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
            if (position == 1) {
                return new Node<>(data);
            } else {
                throw new RuntimeException("the given position is not in the linked list");
            }
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

    private <T> Node<T> returnMidForMergeSort(Node<T> head) {
        Node<T> slow = head;
        Node<T> fast = head.next; // to get the node which is one step back to the mid node ie it belongs to the
        // left side
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private <T> Node<T> sortLinkedListBruteForce(Node<T> head) {
        /*
         * Brute force solution
         * add the elements of the linked list to the array
         * sort the array
         * again iterate through the linked list add the element one by one
         * to the linked list
         */
        Node<T> temp = head;
        ArrayList<T> arr = new ArrayList<>();
        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }
        arr.sort(null);
        System.out.println("Array" + arr);
        temp = head;
        int count = 0;
        while (temp != null) {
            temp.data = arr.get(count);
            temp = temp.next;
            count++;
        }
        return head;
    }

    private <T> Node<T> deleteMiddleNode(Node<T> head) {
        /*
         * Brute force
         * traverse the entire linked list count the number of nodes present
         * find the mid node by dividing the total count by 2 and delete the
         * mid node by pointing the previous node to the next node
         */

        // Node<T> temp = head;
        // int count = 0;
        // while (temp != null) {
        // count++;
        // temp = temp.next;
        // }
        // temp = head;
        // count = count / 2;
        // while (temp != null) {
        // count--;
        // if (count == 0) {
        // temp.next = temp.next.next;
        // break;
        // }
        // temp = temp.next;
        // }
        // return head;
        /*
         * Optmial approach
         * use tortoise and hare method find the midle node connect the prevois node and
         * next node
         */
        Node<T> slow = head;
        Node<T> fast = head;
        fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("mid " + slow.data);
        slow.next = slow.next.next;
        return head;
    }

    /**
     * Sorts a linked list containing nodes with data values 0, 1, or 2 using a
     * brute force counting approach.
     * <p>
     * This method counts the occurrences of 0s, 1s, and 2s in the list, then
     * overwrites the node values in order.
     * </p>
     *
     * Time Complexity: O(n), where n is the number of nodes in the list. Space
     * Complexity: O(1), as only a constant amount of extra space is used.
     *
     * @param head the head node of the linked list
     * @param <T> the type of data stored in the nodes (should be Integer for
     * correct behavior)
     * @return the head node of the sorted linked list
     */
    private Node<Integer> sortList(Node<Integer> head) {

        // int count0=0;
        // int count1=0;
        // int count2=0;
        // Node<Integer> temp = head;
        // while(temp!=null){
        // if(temp.data.equals(0)) count0++;
        // else if(temp.data.equals(1)) count1++;
        // else count2++;
        // temp=temp.next;
        // }
        // temp=head;
        // while(temp!=null){
        // if(count0 > 0){
        // temp.data = 0;
        // count0--;
        // } else if(count1 > 0){
        // temp.data = 1;
        // count1--;
        // } else if(count2 > 0){
        // temp.data = 2;
        // count2--;
        // }
        // temp = temp.next;
        // }
        // return head;
        /**
         * Optimal approach
         *
         */
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> temp = head;
        Node<Integer> zeroDummy = new Node<>(-1);
        Node<Integer> oneDummy = new Node<>(-1);
        Node<Integer> twoDummy = new Node<>(-1);
        Node<Integer> zero = zeroDummy;
        Node<Integer> one = oneDummy;
        Node<Integer> two = twoDummy;
        while (temp != null) {
            if (temp.data.equals(0)) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data.equals(1)) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null;
        return zeroDummy.next;

    }

    private <T extends Comparable<T>> Node<T> sortLinkedList(Node<T> head) {
        // Node<T> temp=head;
        // ArrayList<T> arr = new ArrayList<>();
        // while(temp!=null){
        // arr.add(temp.data);
        // temp=temp.next;
        // }
        // arr.sort(null);
        // System.out.println("Array"+arr);
        // temp=head;
        // int count=0;
        // while(temp!=null){
        // temp.data=arr.get(count);
        // temp=temp.next;
        // count++;
        // }
        // return head;

        /*
         * optimal approach
         * Here's a short and crisp summary of the operations:
         * 
         * **`midForSortingLL(Node head)`:** Finds the middle node of a linked list
         * using slow (1 step) and fast (2 steps) pointers.
         * 
         * **`sortLinkedList(Node head)`:**
         * **Base Case:** Returns `head` if the list is empty or has one node.
         * 
         * **Divide:** Finds the middle node using `midForSortingLL` and implicitly
         * divides the list into `left` and `right` halves.
         * 
         * **Conquer:** Recursively sorts the `left` and `right` halves.
         * 
         * **Combine:** Merges the two sorted halves using `mergeToLL`.
         * (A commented-out "brute force" approach involving `ArrayList` sorting is also
         * mentioned but not used).
         * 
         * **`mergeToLL(Node LL1, Node LL2)`:** Merges two sorted linked lists (`LL1`,
         * `LL2`) into one. It uses a `dummyNode` and compares elements to build the
         * merged list, then appends any remaining nodes.
         */
        if (head == null || head.next == null) {
            return head;
        }

        Node<T> mid = this.returnMidForMergeSort(head);
        Node<T> left = head;
        Node<T> right = mid.next;
        Node<T> leftSortedHead = this.sortLinkedList(left);
        Node<T> rightSortedHead = this.sortLinkedList(right);

        return this.mergeToLL(leftSortedHead, rightSortedHead);

    }

    private <T extends Comparable<T>> Node<T> mergeToLL(Node<T> LL1, Node<T> LL2) {

        Node<T> dummyNode = new Node<>(null);
        Node<T> temp = dummyNode;

        while (LL1 != null && LL2 != null) {
            if (LL1.data.compareTo(LL2.data) <= 0) {
                temp.next = LL1;
                LL1 = LL1.next;
            } else {
                temp.next = LL2;
                LL2 = LL2.next;
            }
            temp = temp.next;
        }
        temp.next = LL1 != null ? LL1 : LL2;

        return dummyNode.next;

    }

    /**
     * Finds the intersection node of two singly linked lists, if it exists.
     *
     * <p>
     * This method implements three approaches (brute force, better, and
     * optimal) to find the intersection node. The optimal approach is used in
     * the final implementation.
     * </p>
     *
     * <p>
     * <b>Optimal approach:</b><br>
     * Uses two pointers to traverse both linked lists. When a pointer reaches
     * the end of a list, it is redirected to the head of the other list. If the
     * lists intersect, the pointers will meet at the intersection node after at
     * most (lengthA + lengthB) steps. If they do not intersect, both pointers
     * will eventually become null at the same time, and the method returns
     * null. This approach runs in O(N + M) time and uses O(1) extra space.
     * </p>
     *
     * @param headA the head node of the first linked list
     * @param headB the head node of the second linked list
     * @param <T> the type of the data stored in the nodes
     * @return the intersection node if one exists; otherwise, null
     */
    public <T> Node<T> getIntersectionNode(Node<T> headA, Node<T> headB) {
        /**
         * Brute force using hash map check wheather the node have appeared
         * previously if it appeared return appeared node else return null
         */
        // Map<Node, Integer> hash = new HashMap<>();
        // Node<T> temp1 = headA;
        // while (temp1 != null) {
        // hash.put(temp1, 1);
        // temp1 = temp1.next;
        // }
        // System.out.println(hash);
        // Node<T> temp2 = headB;
        // while (temp2 != null) {
        // if (hash.containsKey(temp2)) {
        // return temp2;
        // }
        // temp2 = temp2.next;
        // }
        // return null;

        /**
         * Better approach get to the starting point of the smallest linked move
         * to the same postion of the largest linked list and move
         * simultanioulsly if nodes are equal return the node else return null
         */
        // Node<T> temp1 = headA;
        // int l1 = 0;
        // int l2 = 0;
        // Node<T> temp2 = headB;
        // while (temp1 != null) {
        // l1++;
        // temp1 = temp1.next;
        // }
        // while (temp2 != null) {
        // l2++;
        // temp2 = temp2.next;
        // }
        // if (l1 < l2) {
        // return findTheCollisionPoint(headA, headB, l2 - l1);
        // }else {
        // return findTheCollisionPoint(headB, headA, l1 - l2);
        // }
        /**
         * Optimal approach
         *
         */
        if (headA == null || headB == null) {
            return null;
        }

        Node<T> temp1 = headA;
        Node<T> temp2 = headB;

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == temp2) {
                return temp1;
            }

            if (temp1 == null) {
                temp1 = headB;
            }
            if (temp2 == null) {
                temp2 = headA;
            }
        }
        return null;
    }

    private <T> Node<T> findTheCollisionPoint(Node<T> head1, Node<T> head2, int d) {
        while (d > 0) {
            d--;
            head2 = head2.next;
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

    public Node<Integer> addOne(Node<Integer> head) {

        // head = this.reverseLL(head);
        // Node<Integer> temp = head;
        // int carry = 1;
        // Node<Integer> prev = null;
        // while (temp != null) {
        // temp.data += carry;
        // if (temp.data < 10) {
        // carry = 0;
        // break;
        // } else {
        // temp.data = 0;
        // carry = 1;
        // }
        // temp = temp.next;
        // }
        // if (carry == 1) {
        // Node newNode = new Node(1);
        // head = this.reverseLL(head);
        // newNode.next = head;
        // return newNode;
        // }
        // return this.reverseLL(head);
        /**
         * oPTIMA approach using recursion
         */
        int carry = this.helper(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    private Integer helper(Node<Integer> temp) {
        if (temp == null) {
            return 1;
        }
        Integer carry = helper(temp);
        temp.data += carry;
        if (temp.data < 10) {
            return 0;
        }
        temp.data = 0;
        return 1;
    }

    private Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummyNode = new Node(-1);
        Node<Integer> curr = dummyNode;
        Node<Integer> temp1 = l1;
        Node<Integer> temp2 = l2;
        Integer carry = 0;
        while (temp1 != null || temp2 != null) {
            Integer sum = carry;
            if (temp1 != null) {
                sum += temp1.data;
            }
            if (temp2 != null) {
                sum += temp2.data;
            }
            Node newNode = new Node(sum % 10);
            carry = sum / 10;
            curr.next = newNode;
            curr = curr.next;
            if (temp1 != null && temp1.next != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null && temp2.next != null) {
                temp2 = temp2.next;
            }
        }
        if (carry > 0) {
            Node newNode = new Node(carry);
            curr.next = newNode;
        }
        return dummyNode.next;

    }

    /**
     * Reverses nodes of a linked list in groups of size k.
     *
     * This method iteratively processes the linked list, reversing every
     * contiguous group of k nodes. For each group, it finds the k-th node,
     * detaches the group, reverses it, and then reconnects it to the rest of
     * the list. If the remaining nodes are fewer than k, they are left as is.
     *
     * Approach: - Traverse the list, for each group of k nodes: - Find the k-th
     * node. - Detach the group and reverse it. - Connect the reversed group to
     * the previous part and continue. - If the remaining nodes are less than k,
     * leave them unchanged.
     *
     * Link: https://www.youtube.com/watch?v=lIar1skcQYI doc :
     * https://docs.google.com/document/d/1iDjZEOqWWuFqb61ROCf_bxO6GN0efzucqumCPAaq91U/edit?tab=t.0
     *
     * Time Complexity: O(N), where N is the number of nodes in the linked list
     * (each node is visited once). Space Complexity: O(1), as the reversal is
     * done in-place without using extra space.
     *
     * @param head The head node of the linked list.
     * @param k The size of the groups to reverse.
     * @return The head node of the modified linked list after reversing every
     * k-group.
     */
    private <T> Node<T> reverseKGroup(Node<T> head, int k) {

        Node<T> temp = head;
        Node<T> nextNode = null;
        Node<T> prevNode = null;
        while (temp != null) {
            Node<T> kthNode = this.findKthNode(temp, k);
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            this.reverseLL(temp);
            if (temp == head) {
                head = kthNode;
            } else if (prevNode != null) {
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public <T> Node<T> findKthNode(Node temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    private <T> Node<T> rotateLinkedList(Node<T> head, int k) {
        int len = 1;
        Node<T> tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        if (len % k == 0) {
            return head;
        }
        k %= len;
        tail.next = head;
        Node<T> newTailNode = findKthNode(head, len - k);
        head = newTailNode.next;
        newTailNode.next = null;
        return head;
    }

    NodeWithChild<Integer> flatteredLinkedList(NodeWithChild<Integer> head) {
        //note: https://docs.google.com/document/d/1F9vZmGbrzQXsEIRT8DVg72Rlc5Gn0bvG69WdHps4D7k/edit?tab=t.0

        // NodeWithChild<Integer> temp = head;
        // List<Integer> res = new ArrayList<>();
        // while (temp != null) {
        //     res.add(temp.data);
        //     if (temp.child != null) {
        //         NodeWithChild<Integer> temp2 = temp.child;
        //         while (temp2 != null) {
        //             res.add(temp2.data);
        //             temp2 = temp2.next;
        //         }
        //     }
        //     temp = temp.next;
        // }
        // Collections.sort(res);
        // Node<Integer> newHead = new Node<>(res.get(0));
        // Node<Integer> mover = newHead;        
        // for(int i=1;i<res.size();i++){
        //     Node<Integer> newNode = new Node<>(res.get(i));
        //     mover.next = newNode;
        //     mover=mover.next;
        // }
        // return newHead;
        if (head == null || head.next == null) {
            return head;
        }
        NodeWithChild<Integer> mergedHead = this.flatteredLinkedList(head.next);
        // return merget2lists(head, mergedHead);
        head = merget2lists(head, mergedHead);
        return head;

    }

    static NodeWithChild<Integer> merget2lists(NodeWithChild<Integer> l1, NodeWithChild<Integer> l2) {
        LinkedList list = new LinkedList();
        LinkedList.NodeWithChild<Integer> dummyNode = list.new NodeWithChild<>(-1);
        NodeWithChild<Integer> res = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                res.child = l1;
                res = l1;
                l1 = l1.child;
            } else {
                res.child = l2;
                res = l2;
                l2 = l2.child;
            }
            res.next = null;
        }
        if (l1.next != null) {
            res.child = l1;
        } else {
            res.child = l2;
        }
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }
        return dummyNode.next;
    }

    static void printOriginalLinkedList(NodeWithChild<Integer> head, int depth) {
        while (head != null) {
            System.out.print(head.data);

            // If child exists, recursively
            // print it with indentation
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            // Add vertical bars
            // for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.println("inside the loop");
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5};
        // LinkedList testList = new LinkedList();

        // Node<Integer> head = testList.convertArray2LinkedList(arr);
        // int[] listA = {9, 9, 9, 9, 9};
        // int[] listB = {5, 6, 1, 8, 4, 5};
        // Node<Integer> LLA = testList.convertArray2LinkedList(listB);
        // testList.printLinkedList(LLA);
        // System.out.println(".()");
        // Node<Integer> LLB = testList.convertArray2LinkedList(listB);
        // testList.printLinkedList(LLB);
        // System.out.println(testList.getIntersectionNode(LLA, LLB));
        // testList.printLinkedList(head);
        // System.out.println();
        // testList.printLinkedList(testList.reverseLL(head));
        // System.out.println();
        // testList.printLinkedList(testList.sortLinkedList(head));
        // testList.deleteMiddleNode(head);
        // System.out.println("After deleting");
        // testList.printLinkedList(head);
        // testList.printLinkedList(testList.addOne(LLA));
        // testList.printLinkedList(testList.rotateLinkedList(head, 2));
        System.out.println("specail linked list");
        LinkedList list = new LinkedList();
        LinkedList.NodeWithChild<Integer> head = list.new NodeWithChild<>(5);
        head.child = list.new NodeWithChild<>(14);

        head.next = list.new NodeWithChild<>(10);
        head.next.child = list.new NodeWithChild<>(4);

        head.next.next = list.new NodeWithChild<>(12);
        head.next.next.child = list.new NodeWithChild<>(20);
        head.next.next.child.child = list.new NodeWithChild<>(13);

        head.next.next.next = list.new NodeWithChild<>(7);
        head.next.next.next.child = list.new NodeWithChild<>(17);

        System.out.println("print Original liked list");

        printOriginalLinkedList(head, 0);

        printOriginalLinkedList(list.flatteredLinkedList(head), 0);
    }
}
