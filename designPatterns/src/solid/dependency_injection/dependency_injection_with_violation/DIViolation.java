// This code violates the Dependency Injection (DI) principle because the Computer class
// directly creates and depends on a specific WiredKeyBoard implementation. 
// This tight coupling makes it hard to substitute different keyboard types or mock them for testing.
// With DI, dependencies should be provided from outside, not created internally.
package solid.dependency_injection.dependency_injection_with_violation;

class WiredKeyBoard{
    public void connect(){
        System.out.println("Wired keyboard connected");
    }
}

class Computer{
    private WiredKeyBoard keyBoard = new WiredKeyBoard();

    public void start(){
        keyBoard.connect();
    }
}

class DIViolation {
    public static void main(String[] args) {
        Computer pc= new Computer();
        pc.start();
    }


}