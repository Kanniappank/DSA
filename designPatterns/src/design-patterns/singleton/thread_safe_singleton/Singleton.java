
package singleton.thread_safe_singleton;

/**
 * Thread-safe Singleton class.
 * <p>
 * Real-world Example: Consider a configuration manager in an application that loads configuration settings from a file.
 * You want to ensure that only one instance of the configuration manager exists, so all parts of the application use the same settings.
 * The Singleton pattern ensures that only one instance is created and shared across threads.
 * </p>
 *
 * <p>
 * This class ensures that only one instance of {@code Singleton} is created throughout the application's lifecycle.
 * The {@code createInstance()} method is synchronized to make it thread-safe, preventing multiple threads from creating separate instances.
 * </p>
 *
 * <p>
 * <b>Drawbacks:</b>
 * <ul>
 *   <li>Synchronizing the {@code createInstance()} method can lead to performance issues, as it forces every thread to acquire the lock even after the instance is initialized.</li>
 *   <li>This approach may not be suitable for high-concurrency scenarios where performance is critical.</li>
 * </ul>
 * <b>Real-time Example of Drawback:</b>
 * <ul>
 *   <li>In a web server handling thousands of concurrent requests, if each request needs to access the singleton (e.g., a logger or configuration manager), the synchronized method can become a bottleneck, slowing down request processing and reducing throughput.</li>
 * </ul>
 * </p>
 */
class Singleton{
    private static Singleton instance;

    private Singleton(){

    }

    public static synchronized Singleton createInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }

}

