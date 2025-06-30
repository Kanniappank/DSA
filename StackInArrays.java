


public class StackInArrays<T> {

    private int top;
    private int maxSize;
    private T[] stackArr;

    public StackInArrays(int size) {
        this.maxSize = size;
        this.top = -1;
        this.stackArr = (T[]) new Object[size];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(T data) {
        if (isFull()) {
            System.out.println("Stack over flow cannot push " + data);
            return;
        }
        stackArr[++top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stackArr[top--];
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stackArr[top];
    }

    public int size() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }
        return top;
    }

    public void printStackElements() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        System.out.println("Printing stack elements : ");
        for(int i=0;i<=top;i++){
            System.out.print(stackArr[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackInArrays<Integer> stk = new StackInArrays<>(10);
        stk.push(100);
        stk.push(200);
        stk.push(300);
        stk.push(400);
        stk.push(500);
        stk.push(600);
        System.out.println(stk.peek());
        stk.pop();
        System.out.println("Stacks current size is: "+stk.size());
        // stk.push(700);
        // stk.push(800);
        // stk.push(900);
        // stk.push(1000);
        // stk.push(1100);
        stk.printStackElements();

    }
}
