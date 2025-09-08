package chainOfResponsiblity;

public class ChainOfResponsiblityDemo {

    public static void main(String[] args) {
        Handler low = new LowLevelSupport();
        Handler manager = new ManagerSupport();
        Handler director = new DirectorSupport();

        low.setNext(manager).setNext(director);

        low.handleRequest("low");
        low.handleRequest("Medium");
        low.handleRequest("high");
        low.handleRequest("unKnown");

    }
    
}
