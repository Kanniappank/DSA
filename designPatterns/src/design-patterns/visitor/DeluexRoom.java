package visitor;

public class DeluexRoom implements IRoomElement{

    public int roomPrice;

    @Override
    public void accept(IRoomVisitor visitor) {
       visitor.visit(this);
        
    }
    
}
