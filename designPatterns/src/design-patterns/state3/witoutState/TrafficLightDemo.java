package state3.witoutState;

/*
 * This design has several issues:
 * 
 * 1. Poor Extensibility:
 * - Adding new states requires modifying the TrafficLight class directly
 * - Violates Open-Closed Principle as class needs to be changed for new states
 *
 * 2. Complex State Management:
 * - State transitions are likely handled through complex if/else or switch statements
 * - As states increase, the logic becomes harder to maintain
 * 
 * 3. State Logic Coupling:
 * - State-specific behavior is tightly coupled within TrafficLight class
 * - Makes it difficult to modify behavior of individual states
 *
 * 4. Poor Separation of Concerns:
 * - TrafficLight class handles both state management and state-specific behavior
 * - Violates Single Responsibility Principle
 *
 * 5. Hard to Test:
 * - Testing different states requires changing internal state
 * - State transitions are not easily isolated for testing
 *
 * A better approach would be using the State Pattern where:
 * - Each state is encapsulated in its own class
 * - State transitions are delegated to state objects
 * - New states can be added by creating new classes
 * - State-specific behavior is isolated and maintainable
 */
public class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();

    }
}
