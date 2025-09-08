package mediator_whatsapp;

public class MediatorDemo {
    
    public static void main(String[] args) {
        ChatMediator grp = new WhatsAppGrp();

        User alice = new WhatsAppUser(grp, "Alice");
        User charlie = new WhatsAppUser(grp, "charlie");
        User bob = new WhatsAppUser(grp, "Bob");

        grp.addUser(bob);
        grp.addUser(alice);
        grp.addUser(charlie);

         alice.send("Hello everyone!");
        bob.send("Hey Alice!");
        charlie.send("What's up guys?");
    }
}
