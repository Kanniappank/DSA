package chainOfResponsiblity;

public class DirectorSupport extends Handler {

    @Override
    public void handleRequest(String request) {
        if(request.equalsIgnoreCase("High")){
            System.out.println("Director handled this request");
        }
        else if(nextHandler!=null){
            nextHandler.handleRequest(request);
        }
        else{
            System.out.println("No one can handle this request");
        }
    }
    
}
