
import java.util.Stack;

public class QueInStack<T> {
    Stack<T> s1 = new Stack<>();
    Stack<T> s2 = new Stack<>();

    //This method applicale only for less number of pushes
    // public void push(T data) {

    //     while (!s1.isEmpty()) {
    //         s2.push(s1.peek());
    //         s1.pop();
    //     }
    //     s1.push(data);

    //     while (!s2.isEmpty()) {
    //         s1.push(s2.peek());
    //         s2.pop();
    //     }

    // }

    // public T pop() {
    //     return s1.pop();
    // }

    // public T peek() {
    //     if (s1.isEmpty()) {
    //         System.out.println("que is empty");
    //         return null;
    //     }
    //     return s1.peek();
    // }

    // public int size() {
    //     return s1.size();
    // }

    //pushes are more

    // public void push(T data){

    // }

    public static void main(String[] args) {
        QueInStack<Integer> que = new QueInStack<>();
        que.push(10);
        que.push(20);
        que.push(30);
        System.out.println(que.peek());

        que.pop();
        que.pop();

        que.push(40);
        // que.push(50);
        // que.push(60);
        // que.pop();
        System.out.println(que.peek());
    }
}
