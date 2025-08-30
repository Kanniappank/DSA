package visitor;

public class RoomPricingVisitor implements IRoomVisitor {

    @Override
    public void visit(SingleRoom singleRoomObject) {
        System.out.println("pricing logic computation for single room");
        singleRoomObject.roomPrice = 1000;
        
    }

    @Override
    public void visit(DoubleRoom doubleRoomObject) {
        System.out.println("Pricing logic computation for Double Room");
        doubleRoomObject.roomPrice = 2000;
        
    }

    @Override
    public void visit(DeluexRoom deluexRoomObject) {
       System.out.println("Pricing logic computation for Deluex Room");
         deluexRoomObject.roomPrice = 3000;
        
    }
    
}
