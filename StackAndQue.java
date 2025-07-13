
import java.util.Arrays;
import java.util.Stack;

class StackandQue {

    static class Pair<T> {

        T x;
        T y;

        public Pair(T x, T y) {
            this.x = x;
            this.y = y;
        }
    }
    // min stack with pair
    // static class MinStack {

    // Stack<Pair<Integer>> stk = new Stack<>();
    // public void push(int data) {
    // int min;
    // if (stk.isEmpty()) {
    // min = data;
    // } else {
    // min = Math.min(data, stk.peek().y);
    // }
    // stk.push(new Pair<>(data, min));
    // }
    // public int peek() {
    // return stk.peek().x;
    // }
    // public void pop() {
    // stk.pop();
    // }
    // public int size() {
    // return stk.size();
    // }
    // public int getMin() {
    // return stk.peek().y;
    // }
    // }
    // without a pair
    static class MinStack {

        Stack<Integer> stk = new Stack<>();
        int min = Integer.MAX_VALUE;

        public void push(int val) {
            if (stk.isEmpty()) {
                min = val;
                stk.push(min);
            } else {
                if (val > min) {
                    stk.push(min);
                } else {
                    stk.push(2 * val - min); // modifing the value and pushing to the stack so the we can get back the
                                             // pervious min val;
                    min = val;
                }
            }
        }

        public Integer peek() {
            if (stk.isEmpty()) {
                System.out.println("Stack under flow");
                return null;
            }
            int x = stk.peek();
            if (x > min) {
                return x;
            }
            return min;
        }

        public Integer pop() {
            if (stk.isEmpty()) {
                System.out.println("Stack is under flowing");
                return null;
            }
            int x = stk.peek();
            stk.pop();
            if (min > x) {
                min = 2 * min - x; // to update the previous minimum value the formula we used in the push is
                                   // reciprocal
            }
            return null;
        }

        public Integer getMin() {
            if (min != Integer.MAX_VALUE) {
                return min;
            }
            System.out.println("Stack is undeflowing");
            return null;
        }
    }

    public boolean validParanthesis(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stk.push(s.charAt(i));
            } else {
                if (stk.isEmpty()) {
                    return false;
                }
                Character ch = stk.peek();
                stk.pop();
                if ((s.charAt(i) == ')' && ch == '(') || (s.charAt(i) == ']' && ch == '[')
                        || (s.charAt(i) == '}' && ch == '{')) {

                } else {
                    return false;
                }
            }
        }
        return stk.isEmpty();

    }

    public StringBuilder infixToPostFix(String s) {
        /*
         * | Type | Action |
         * | -------------------------------------- |
         * ------------------------------------------------------------------- |
         * | **Operand (A, B, 1, x)** | ➜ **Add to output** directly |
         * | **Left Parenthesis `(`** | ➜ **Push to stack** |
         * | **Right Parenthesis `)`** | ➜ **Pop from stack to output until `(` is
         * found**, then discard `(` |
         * | **Operator (`+`, `-`, `*`, `/`, `^`)** | ➜ Do this 👇 |
         * 
         * 
         */

        Stack<Character> stk = new Stack<>();
        int i = 0;
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        while (i < n) {
            Character ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            } else if (ch == '(') {
                stk.push(ch);
            } else if (s.charAt(i) == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    ans.append(stk.pop());
                }
                if (!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop();
                }
            } else {
                while (!stk.isEmpty() && this.priority(ch) <= this.priority(stk.peek())) {
                    ans.append(stk.pop());
                }
                stk.push(ch);
            }
            i++;
        }
        while (!stk.isEmpty()) {
            ans.append(stk.pop());
        }
        return ans;
    }

    public int priority(char c) {
        return switch (c) {
            case '^' ->
                3;
            case '*', '/' ->
                2;
            case '-', '+' ->
                1;
            default ->
                -1;
        };
    }

    public String infixToPrefix(String s) {
        int n = s.length(), i = 0;
        Stack<Character> stk = new Stack<>();
        StringBuilder ans = new StringBuilder();
        s = StackandQue.reverseString(s).toString();
        while (i < n) {
            Character ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            } else if (ch == '(') {
                stk.add(ch);
            } else if (ch == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    ans.append(stk.pop());
                }
                stk.pop();
            } else {
                // Operator handling with correct associativity
                while (!stk.isEmpty() && stk.peek() != '('
                        && (isRightAssociative(ch) ? priority(ch) < priority(stk.peek())
                                : priority(ch) <= priority(stk.peek()))) {
                    ans.append(stk.pop());
                }
                stk.push(ch);
            }
        }
        while (!stk.isEmpty()) {
            ans.append(stk.pop());
        }
        return StackandQue.reverseString(ans.toString()).toString();
    }

    public String postFixtoInfix(String s) {
        int i = 0, n = s.length();
        Stack<String> stk = new Stack();
        while (i < n) {
            Character ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                stk.push(String.valueOf(ch));
            } else {
                StringBuilder converted = new StringBuilder();
                String t2 = stk.pop();
                String t1 = stk.pop();
                converted.append('(').append(t1).append(ch).append(t2).append(')');
                stk.push(String.valueOf(converted));
            }
            i++;
        }
        return stk.pop();

    }

    public String prefixToInfix(String s) {
        Stack<String> stk = new Stack<>();
        int i = s.length() - 1;
        while (i >= 0) {
            Character ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stk.push(ch.toString());
            } else {
                StringBuilder converted = new StringBuilder();
                String t1 = stk.pop();
                String t2 = stk.pop();
                converted.append('(').append(t1).append(ch).append(t2).append(')');
                stk.push(converted.toString());
            }
            i--;
        }
        return stk.pop();
    }

    public String postfixToPrefix(String s) {
        Stack<String> stk = new Stack<>();
        int n = s.length(), i = 0;
        while (i < n) {
            Character ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stk.push(ch.toString());
            } else {
                StringBuilder converted = new StringBuilder();
                String t2 = stk.peek();
                String t1 = stk.peek();
                converted.append(ch).append(t2).append(t1);
                stk.push(converted.toString());
            }
            i++;
        }
        return stk.peek();
    }

    public String prefixToPostFix(String s) {
        Stack<String> stk = new Stack<>();
        int i = s.length() - 1;
        while (i > 0) {
            Character ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stk.push(ch.toString());
            } else {
                StringBuilder converted = new StringBuilder();
                String t1 = stk.peek();
                String t2 = stk.peek();
                converted.append(t1).append(t2).append(ch);
                stk.push(converted.toString());
            }
            i--;
        }
        return stk.peek();
    }

    public int[] findNextGratestElement(int[] arr) {
        int len = arr.length;
        int[] nge = new int[len];
        Stack<Integer> stk = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = stk.peek();
            }
            stk.push(arr[i]);
        }
        return nge;
    }
    public int[] findNextSmallerElement(int[] arr){
        int len=arr.length;
        int[] nge = new int[len];
        Stack<Integer> stk = new Stack<>();
        for(int i=len-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()>=arr[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                nge[i]=-1;
            }
            else{
                nge[i]=stk.peek();
            }
            stk.push(arr[i]);
        }
        return nge;
    }

    public int[] findNextFreatestElementCircularArray(int[] arr) {
        int len = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] nge = new int[len];
        for (int i = (2 * len) - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr[i % len]) {
                stk.pop();
            }
            if (i < len) {
                nge[i] = stk.isEmpty() ? -1 : stk.peek();
            }
            stk.push(arr[i % len]);
        }
        return nge;
    }

    public boolean isRightAssociative(char c) {
        return c == '^';
    }
    public static StringBuilder reverseString(String s) {
        int len = s.length();
        StringBuilder reversed = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            Character ch = s.charAt(i);
            if (ch == '(') {
                ch = ')';
            } else if (ch == ')') {
                ch = '(';
            }
            reversed.append(ch);
        }
        return reversed;
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        StackandQue skt = new StackandQue();
        minStack.push(12);
        minStack.push(15);
        minStack.push(10);
        System.out.println("min value in stack " + minStack.getMin());
        minStack.pop();
        System.out.println("top value in the stack " + minStack.peek());
        System.out.println("min value in stack " + minStack.getMin());
        // System.out.println(reverseString("(A+B)*C-D+F"));
        System.out.println(skt.infixToPostFix("a+b*c"));
        System.out.println("post fix to in fix " + skt.postFixtoInfix("abc*+"));
        int[] arr = {6, 8, 0, 1, 3};
        System.out.println(Arrays.toString(skt.findNextGratestElement(arr)));
        int[] newArr ={1,2,3,4,3};
        System.out.println(Arrays.toString(skt.findNextFreatestElementCircularArray(newArr)));
        int[] smallersArr = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(skt.findNextSmallerElement(smallersArr)));


    }
}
