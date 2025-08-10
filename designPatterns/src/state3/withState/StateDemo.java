package state3.withState;

// This is a better approach because:
// - It uses the State pattern to encapsulate state-specific behavior
// - Each state is represented by a separate class, making the code more maintainable
// - New states can be easily added without modifying existing code
// - State transitions are handled cleanly within the state classes
// - The context class (TrafficLightContext) remains simple and delegates to the current state
// - It follows the Open/Closed Principle by being open for extension but closed for modification
// - The state pattern eliminates the need for complex conditional logic
public class StateDemo {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();

        trafficLight.next();
        trafficLight.next();
        trafficLight.next(); 
        trafficLight.next();
    }
}

