package visitor;

public interface IRoomVisitor {

    public void visit(SingleRoom singleRoomObject);

    public void visit(DoubleRoom doubleRoomObject);

    public void visit(DeluexRoom deluexRoomObject);

}
