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
        var textBox = new TextBox();
        var checkBox = new CheckBox();
        textBox.enable();

//        polymorphism
        textBox.draw();
//        checkBox.draw();

drawUIControl(new CheckBox());
    }

    public static void drawUIControl(UIControl control){
        control.draw();
    }

    public static TaxCalculator getCalculator() {
        return new TaxCalculator2019();
    }
}