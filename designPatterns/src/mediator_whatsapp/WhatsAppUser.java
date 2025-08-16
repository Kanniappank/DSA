package mediator_whatsapp;

public class WhatsAppUser extends User {

    public WhatsAppUser(ChatMediator mediator, String name) {
        super(mediator, name);

    }

    @Override
    public void send(String message) {
        System.out.println("📤 " + name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message, String senderName) {
        System.out.println("📥 " + name + " received from " + senderName + ": " + message);
    }

}
