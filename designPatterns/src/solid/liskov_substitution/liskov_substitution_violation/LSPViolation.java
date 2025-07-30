/**
 * Demonstrates a violation of the Liskov Substitution Principle (LSP).
 *
 * <p>
 * LSP states that objects of a superclass should be replaceable with objects of its subclasses
 * without altering the correctness of the program.
 * </p>
 *
 * <p>
 * <b>Violation Explanation:</b>
 * <ul>
 *   <li>
 *     The {@link Vehicle} class defines a method {@code hasEngine()} that returns {@code true} by default,
 *     implying all vehicles have engines.
 *   </li>
 *   <li>
 *     The {@link ByCycle} subclass overrides {@code hasEngine()} and returns {@code null} (cast to Boolean),
 *     which breaks the contract established by the base class (should return a boolean value).
 *   </li>
 *   <li>
 *     This can lead to {@link NullPointerException} or unexpected behavior when client code expects a boolean value.
 *   </li>
 *   <li>
 *     As a result, substituting a {@link Vehicle} with a {@link ByCycle} object changes the expected behavior,
 *     violating LSP.
 *   </li>
 * </ul>
 * </p>
 */
package solid.liskov_substitution.liskov_substitution_violation;

import java.util.ArrayList;
import java.util.List;

class Vehicle {

   public Integer getNumberOfWheels() {
      return 2;
   }

   public boolean hasEngine() {
      return true;
   }
}

class MotorCycle extends Vehicle {

}

class Car extends Vehicle {
   @Override
   public Integer getNumberOfWheels() {
      return 4;
   }
}

class ByCycle extends Vehicle {

   @SuppressWarnings("null")
   @Override
   public boolean hasEngine() {
      return (Boolean) null;
   }
}

public class LSPViolation {

   public static void main(String[] args) {
      List<Vehicle> list = new ArrayList();
      list.add(new MotorCycle());
      list.add(new Car());
      list.add(new ByCycle());
      for (Vehicle vehicle : list) {
         System.out.println("is this has engine" + vehicle.hasEngine());
      }
   }
}
