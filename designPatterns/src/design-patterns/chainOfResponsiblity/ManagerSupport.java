package chainOfResponsiblity;

public class ManagerSupport extends Handler{

    @Override
    public void handleRequest(String request) {
        if(request.equalsIgnoreCase("medium")){
            System.out.println("Request handled by Manager");
        }
        else if(nextHandler!=null){
            nextHandler.handleRequest(request);
        }
    }

}
