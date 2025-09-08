package mediator;

public class MediatorDemo {

    public static void main(String[] args) {

        ChatMediator chatRoom = new ChatRoom();

        User user1 = new ChatUser(chatRoom, "Suriya");
        User user2 = new ChatUser(chatRoom, "Karan");

        user1.send("Hi Karan");
        user2.send("Hi Suriya");
    }

}
