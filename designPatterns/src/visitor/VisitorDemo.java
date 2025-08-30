package visitor;

public class VisitorDemo {
    /*
     * The Visitor Design Pattern solves several key problems:
     * 
     * 1. Separation of Concerns:
     * - Allows separating algorithms/operations from the objects they operate on
     * - New operations can be added without modifying existing object classes
     * 
     * 2. Double Dispatch:
     * - Enables performing different operations based on both the type of visitor
     * and type of element
     * - Avoids complex conditional logic and type checking
     * 
     * 3. Open/Closed Principle:
     * - New behaviors can be added by creating new visitor implementations
     * - Existing classes don't need to be modified when adding new operations
     * 
     * 4. Centralized Operations:
     * - Related operations are grouped together in visitor classes rather than
     * scattered across element classes
     * - Makes it easier to maintain related functionality
     * 
     * 5. Accumulating State:
     * - Visitors can maintain state as they traverse object structures
     * - Useful for gathering information across multiple objects
     * 
     * 6. Cross-Cutting Concerns:
     * - Handles operations that span multiple classes (like pricing, maintenance
     * etc.)
     * - Keeps element classes focused on their core responsibilities
     */ public static void main(String[] args) {

        IRoomElement singleRoom = new SingleRoom();
        IRoomElement doubleRoom = new DoubleRoom();
        IRoomElement deluexRoom = new DeluexRoom();

        IRoomVisitor pricingVisitorobj = new RoomPricingVisitor();

        singleRoom.accept(pricingVisitorobj);
        System.out.println(((SingleRoom) singleRoom).roomPrice);

        doubleRoom.accept(pricingVisitorobj);
        System.out.println(((DoubleRoom) doubleRoom).roomPrice);

        deluexRoom.accept(pricingVisitorobj);
        System.out.println(((DeluexRoom) deluexRoom).roomPrice);

        IRoomVisitor maintenanceObj = new RoomMaintenance();

        singleRoom.accept(maintenanceObj);

        doubleRoom.accept(maintenanceObj);

        doubleRoom.accept(maintenanceObj);

    }
}
