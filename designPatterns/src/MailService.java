public class MailService {
    public void sendEmail(){
        connect();
        authenticate();
        System.out.println("Sending email");
        disConnect();
    }

//    making methods private will hide this function in the place where you create object for this class
    private void authenticate(){
        System.out.println("Authenticate");
    }
    private void connect(){
        System.out.println("Connect");
    }
    private void disConnect(){
        System.out.println("Disconnect");
    }

}

