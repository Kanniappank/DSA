class Employee {

    String name;
    int age;
    String empId;

    public Employee(String name, int age, String empId) {
        this.name = name;
        this.age = age;
        this.empId = empId;
    }

    @Override
    public String toString() {
        return name + " (" + empId + ")";
    }
}

public class QueInLinkedList<T> {

    int size;
    Node<T> start;
    Node<T> end;

    public class Node<U> {

        private final U data;
        private Node<U> next;

        public Node(U data) {
            this.data = data;
            this.next = null;
        }

    }

    public boolean isEmpty() {
        return start == null;
    }

    public void enque(T data) {
        Node<T> temp = new Node<>(data);
        if (start == null) {
            start = end = temp;
        } else {
            end.next = temp;
            end = temp;
        }
        size++;
    }

    public T dque() {
        if (isEmpty()) {
            System.out.println("Que is empty");
            return null;
        }
        Node<T> temp = start;
        start = start.next;
        size--;
        return (T) temp.data;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("que is empty");
            return null;
        }
        return (T) start.data;
    }

    public int size() {
        return size;
    }

    public void printQue() {
        Node<T> current = start;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        QueInLinkedList<Employee> que = new QueInLinkedList<>();
        que.enque(new Employee("suresh", 30, "sr30"));
        que.enque(new Employee("Ranjith", 30, "rj30"));
        que.enque(new Employee("jitesh", 30, "jt30"));
        que.enque(new Employee("praveen", 30, "pr30"));
        que.printQue();
    }
}
