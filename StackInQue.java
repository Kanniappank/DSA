
import java.util.LinkedList;
import java.util.Queue;

public class StackInQue<T> {
    Queue<T> que = new LinkedList<>();

    public void push(T data) {
        que.add(data);
        int size = que.size();
        for (int i = 1; i < size; i++) {
            que.add(que.peek());
            que.remove();
        }
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    public T pop() {
        return que.remove();
    }

    public T peek() {
        if (que.isEmpty()) {
            System.out.println("Stack is under flowing");
            return null;
        }
        return que.peek();
    }

    public int size() {
        return que.size();
    } 

    public static void main(String[] args) {
        StackInQue<Integer> stk=new StackInQue<>();
        stk.push(4);
        stk.push(9);
        stk.push(2);
        stk.push(5);
        System.out.println("peek stack "+stk.peek());
        System.out.println("pop stack "+stk.pop());
        System.out.println("pop stack "+stk.pop());
        System.out.println("peek stack "+stk.peek());
        stk.push(1);
        System.out.println("peek stack "+stk.peek());
    }
}


