package chainOfResponsiblity;

public class LowLevelSupport extends Handler {

    @Override
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("low")) {
            System.out.println("Low level support handled this request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
