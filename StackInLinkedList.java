
public class StackInLinkedList<T> {

    int size;
    Node<T> top;

    private class Node<T> {

        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> temp = new Node<>(data);
        temp.next = top;
        top = temp;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is underflowing");
            return null;
        }
        Node temp = top;
        top = top.next;
        size--;
        return (T) temp.data;
    }

    public T peek() {
        return top.data;
    }

    public int size() {
        return size;
    }

    public void printStack() {
        Node current = top;
        System.out.println("Printing stack");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        StackInLinkedList<Integer> stk = new StackInLinkedList<>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.printStack();
        System.out.println("pop "+stk.pop());
        stk.printStack();
        System.out.println("peek "+stk.peek());
        System.out.println("size "+stk.size());


    }

}
