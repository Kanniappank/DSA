import Momento.Editor;
import Momento.History;
import State.BrushTool;
import State.Canvas;
import State.EraserTool;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //before creating contractor
//        User user = new User();
//        user.name="Kanniappan";
//        System.out.println((user.name));

        //after creating constructor

//        User user = new User("Kanniappan K");
//        System.out.println(user.name);
//        user.sayHello();

        // creating object for an interface
//        TaxCalculator calculator = getCalculator();
//        calculator.calculateTax();

        //Encapsulation
//        var account =new Account();
//        account.balance=-1; // this    will not work because balance is a private variable
//        account.deposit(10);
//        System.out.println("after deposit "+account.getBalance());
//        account.widthDraw(5);
//        System.out.println("after withdraw "+account.getBalance());

//        abstraction
//        var mailServer = new MailService();
//        mailServer.sendEmail();

//        Inheritance
//        var textBox = new TextBox();
//        var checkBox = new CheckBox();
//        textBox.enable();

//        polymorphism
//        textBox.draw();
//        checkBox.draw();
//drawUIControl(new CheckBox());


//        Momento pattern

//        var editor = new Editor();
//        var history = new History();
//        editor.setContent("a");
//        history.push(editor.createState());
//        editor.setContent("b");
//        history.push(editor.createState());
//        editor.setContent("c");
//        editor.restore(history.pop());
//
//        System.out.println(editor.getContent());

//        State pattern
        var canvas = new Canvas();
        canvas.setCurrentTool(new BrushTool());
        canvas.mouseDown();
        canvas.mouseUp();
        canvas.setCurrentTool(new EraserTool());
        canvas.mouseDown();
        canvas.mouseUp();

    }

    public static void drawUIControl(UIControl control){
        control.draw();
    }

    public static TaxCalculator getCalculator() {
        return new TaxCalculator2019();
    }
}