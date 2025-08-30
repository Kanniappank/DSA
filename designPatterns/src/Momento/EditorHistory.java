package Momento;

import java.util.Stack;

public class EditorHistory {
    private Stack<Momento> history = new Stack<>();

    public void push(Momento momento) {
        history.push(momento);
    }

    public Momento pop() {
        if (history.isEmpty()) {
            return null;
        }
        return history.pop();
    }
}
