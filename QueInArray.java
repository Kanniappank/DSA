


public class QueInArray<T> {

    int capacity;
    int currentSize;
    T[] queArray;
    int start;
    int end;

    public QueInArray(int size) {
        this.capacity = size;
        this.currentSize = 0;
        this.queArray = (T[]) new Object[capacity];
        this.start = -1;
        this.end = -1;
    }

    public boolean isFull() {
        return capacity == currentSize;
    }

    public boolean isEmpyt() {
        return currentSize == 0;
    }

    public void enque(T data) {
        if (isFull()) {
            System.out.println("Que is full cannot push items");
        }
        if (currentSize == 0) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % capacity;
        }
        queArray[end] = data;
        currentSize++;
    }

    public T dque() {
        if (isEmpyt()) {
            System.out.println("Quee is Empty");
            return null;
        }
        T el = queArray[start];
        if (currentSize == 1) {
            start = end = -1;
        } else {
            start = (start + 1) % capacity;
        }
        currentSize--;
        return el;
    }

    public T peek() {
        if (isEmpyt()) {
            System.out.println("Que is empty");
        }
        return queArray[start];
    }
    public int size(){
        return currentSize;
    }
    public void printQue(){
        if(isEmpyt()){
            System.out.println("que is empty");
        }
        System.out.println("Printing Que");
        for(int i=0;i<currentSize;i++){
            System.out.print(queArray[i]+" ");
        }
    }
    public static void main(String[] args) {
        QueInArray<Integer> q =new QueInArray<>(4);
        q.enque(10);
        q.enque(20);
        q.enque(30);
        System.out.println("Peeking the Que "+q.peek());
        System.out.println("dQue "+q.dque());
        System.out.println("dQue "+q.dque());
        q.enque(40);
        q.enque(50);
        System.out.println("dQue "+q.dque());
        System.out.println("dQue "+q.dque());
        System.out.println("dQue "+q.dque());
        q.printQue();

    }
}
