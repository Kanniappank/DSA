/**
 * Demonstrates adherence to the Liskov Substitution Principle (LSP).
 *
 * <p>
 * LSP states that objects of a superclass should be replaceable with objects of its subclasses
 * without altering the correctness of the program.
 * </p>
 *
 * <p>
 * <b>How LSP is maintained:</b>
 * <ul>
 *   <li>
 *     The {@link Vehicle} class defines general behavior (e.g., {@code getNumberOfWheels()}).
 *   </li>
 *   <li>
 *     Subclasses such as {@link EngineVehicle}, {@link MotorCycle}, {@link Car}, and {@link ByCycle}
 *     extend {@link Vehicle} and provide specific implementations where needed.
 *   </li>
 *   <li>
 *     No subclass breaks the contract of the superclass; all methods return expected types and values.
 *   </li>
 *   <li>
 *     This allows any {@link Vehicle} reference to be replaced by its subclasses without unexpected behavior,
 *     thus following LSP.
 *   </li>
 * </ul>
 * </p>
 */
package solid.liskov_substitution.liskov_substitution_without_violation;
   
import java.util.ArrayList;
import java.util.List;

class Vehicle {

   public Integer getNumberOfWheels() {
      return 2;
   }

  
}

class EngineVehicle  extends Vehicle{

   public Integer getNumberOfWheels() {
      return 2;
   }

   public boolean hasEngine() {
      return true;
   }
}

class MotorCycle extends EngineVehicle {

}

class Car extends EngineVehicle {
   @Override
   public Integer getNumberOfWheels() {
      return 4;
   }
}

class ByCycle extends Vehicle {


}

public class LSPWithoutViolation {

   public static void main(String[] args) {
      List<Vehicle> list = new ArrayList();
      list.add(new MotorCycle());
      list.add(new Car());
      list.add(new ByCycle());
      for (Vehicle vehicle : list) {
         // System.out.println("is this has engine" + vehicle.hasEngine()); has engine cannot be accessed because it is in engine vehicles
         System.out.println("is this has engine" + vehicle.getNumberOfWheels());
      }
   }
}
