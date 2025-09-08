package Momento;

public class MomentoDemo {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.setText("Hello");
        System.out.println("Current text : " + editor.getText());
        history.push(editor.save());

        editor.setText("Hello World");
        System.out.println("Current text : " + editor.getText());
        history.push(editor.save());

        editor.setText("Hello, World! Welcome to Momento pattern");
        System.out.println("Current text : " + editor.getText());
        // history.push(editor.save());

        Momento previousState = history.pop();
        editor.restore(previousState);
        System.out.println("After undo : " + editor.getText());

        previousState = history.pop();
        editor.restore(previousState);
        System.out.println("After Second undo : " + editor.getText());

    }
}
