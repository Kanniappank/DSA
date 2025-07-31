/**
 * Demonstrates the usage of a thread-safe Singleton pattern in Java.
 * <p>
 * This class contains a {@code main} method that creates two threads,
 * each attempting to obtain an instance of the {@code Singleton} class
 * using the {@code Singleton.createInstance()} method. The hash code of
 * the singleton instance is printed by each thread, illustrating that
 * both threads receive the same instance, thus confirming the singleton
 * property even in a multithreaded environment.
 * </p>
 *
 * <h2>Real-time Example:</h2>
 * <p>
 * Consider a logging service in an application where multiple threads
 * may attempt to log messages simultaneously. To ensure consistency and
 * avoid creating multiple logger instances, a thread-safe singleton
 * ensures that all threads use the same logger instance.
 * </p>
 *
 * <h2>Thread Safety Explanation:</h2>
 * <p>
 * In a multithreaded context, if singleton instance creation is not
 * properly synchronized, multiple threads could create separate instances,
 * violating the singleton principle. The {@code Singleton.createInstance()}
 * method (implementation not shown here) is expected to use thread-safe
 * mechanisms (such as synchronized blocks, double-checked locking, or
 * static initialization) to ensure that only one instance is created,
 * even when accessed by multiple threads concurrently.
 * </p>
 *
 * <h2>Drawbacks:</h2>
 * <ul>
 *   <li>
 *     Increased complexity: Implementing thread safety (e.g., using synchronization or double-checked locking)
 *     adds complexity to the code.
 *   </li>
 *   <li>
 *     Performance overhead: Synchronization can introduce performance bottlenecks, especially if the
 *     singleton instance is accessed frequently.
 *   </li>
 *   <li>
 *     Difficult testing: Singletons can make unit testing harder, as they carry global state across tests.
 *   </li>
 *   <li>
 *     Limited scalability: In some scenarios, using a singleton can limit scalability and flexibility,
 *     especially in distributed or highly concurrent systems.
 *   </li>
 * </ul>
 */
package singleton.thread_safe_singleton;



class SingletonThreadSafe {
    public static void main(String[] args) {
        Runnable task = () -> {
            Singleton instance = Singleton.createInstance();
            System.out.println(Thread.currentThread().getName() + " -> " + instance.hashCode());
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }

}