
package solid.dependency_injection.dependency_injection_without_violation;


// This code follows the Dependency Inversion Principle (DIP) because:
// 1. High-level modules (Computer) do not depend on low-level modules (WiredKeyBoard, WirelessKeyboard).
// 2. Both depend on the abstraction (IKeyboard interface).
// 3. The Computer class receives its dependency (IKeyboard) via constructor injection, allowing for flexibility and easy substitution of different keyboard implementations.
interface IKeyboard {
    void connect();
}

class WiredKeyBoard implements IKeyboard {

    @Override
    public void connect() {
        System.out.println("Wired Keyboard connected");
    }

}

class WirelessKeyboard implements IKeyboard {

    @Override
    public void connect() {
        System.out.println("wireless keyboard connected");
    }

}

class Computer {
    private IKeyboard keyboard;

    public Computer(IKeyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void start() {
        this.keyboard.connect();
    }
}

class DIWithoutViolation {

    public static void main(String[] args) {
        WirelessKeyboard hpKeyboard = new WirelessKeyboard();
        Computer pc1 = new Computer(hpKeyboard);
        pc1.start();
        WiredKeyBoard zebKeyBoard = new WiredKeyBoard();
        Computer pc2 = new Computer(zebKeyBoard);
        pc2.start();
    }

}