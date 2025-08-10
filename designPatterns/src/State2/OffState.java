package State2;

public class OffState implements IState{

    @Override
    public void pressPowerButton(TVContext context) {
        System.out.println("TV powered On");
        context.setState(new OnState());
    }
    
}
