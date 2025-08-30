package visitor;

public class RoomMaintenance implements IRoomVisitor {

    @Override
    public void visit(SingleRoom singleRoomObject) {
        System.out.println("Perfoming single room maintenance");

    }

    @Override
    public void visit(DoubleRoom doubleRoomObject) {
        System.out.println("Perfoming Double room maintenance");

    }

    @Override
    public void visit(DeluexRoom deluexRoomObject) {
        System.out.println("Perfoming deluex room maintenance");

    }

}
