package composite;

/**
 * Demonstrates the Composite Design Pattern in Java.
 *
 * <p>
 * The Composite Design Pattern is a structural pattern that allows you to compose objects into tree structures
 * to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.
 * </p>
 *
 * <p>
 * In this example:
 * <ul>
 *   <li><b>Leaf</b> represents individual components (e.g., Hard drive, Mouse, Monitor, Ram, CPU).</li>
 *   <li><b>Composite</b> represents groups of components (e.g., Peripheral, Cabinet, Mother Board, Computer) that can contain both Leafs and other Composites.</li>
 *   <li>All components implement the <b>IComponent</b> interface, allowing uniform treatment.</li>
 * </ul>
 * </p>
 *
 * <p>
 * The main method builds a computer system hierarchy using both leaf and composite objects,
 * and then displays the price of the entire structure using <code>showPrice()</code>.
 * </p>
 *
 * <p>
 * This pattern is useful when you need to work with tree-like structures and want to treat individual objects and groups of objects in the same way.
 * </p>
 */
public class CompositeDemo {

    

    public static void main(String[] args) {
        
        IComponent hd= new Leaf("Hard drive", 4000);
        IComponent mouse= new Leaf("Mouse", 500);
        IComponent monitor= new Leaf("Monitor", 10000);
        IComponent ram= new Leaf("Ram", 3000);
        IComponent cpu= new Leaf("CPU", 5000);

        Composite peri = new Composite("Peripheral");
        Composite cabinet = new Composite("Cabinet");
        Composite motherBoard = new Composite("Mother Board");
        Composite computer = new Composite("Computer");

        peri.addComponent(mouse);
        peri.addComponent(monitor);
        peri.addComponent(hd);
        cabinet.addComponent(motherBoard);
        motherBoard.addComponent(cpu);
        motherBoard.addComponent(ram);
        
        computer.addComponent(peri);
        computer.addComponent(cabinet);

        // computer.showPrice();
        computer.showPrice();





    }
    
}
