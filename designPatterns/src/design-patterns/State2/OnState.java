package State2;

public class OnState implements IState{

    @Override
    public void pressPowerButton(TVContext context) {
        System.out.println("TV getting turned Off");
        context.setState(new OffState());
    }
    
}
