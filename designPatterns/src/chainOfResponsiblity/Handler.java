package chainOfResponsiblity;

public abstract class Handler {
    protected Handler nextHandler;

    public Handler setNext(Handler nextHandler){
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract void handleRequest(String request);
}


