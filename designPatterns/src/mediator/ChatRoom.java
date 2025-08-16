package mediator;

public class ChatRoom implements ChatMediator {

    @Override
    public void sendMessage(String message, User user) {
        System.out.println(user.getName() + " Says " + message);
    }

}
