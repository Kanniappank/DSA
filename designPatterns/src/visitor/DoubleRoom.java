package visitor;

public class DoubleRoom implements IRoomElement{

    public int roomPrice;

    @Override
    public void accept(IRoomVisitor visitor) {
        visitor.visit(this);
        
    }
    
}
