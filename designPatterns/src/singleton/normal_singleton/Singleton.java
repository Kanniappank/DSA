package singleton.normal_singleton;

/**
 * Demonstrates a basic implementation of the Singleton design pattern.
 * 
 * <p>
 * The {@code Singleton} class ensures that only one instance of itself can be created.
 * The instance is lazily initialized when {@code createInstance()} is called for the first time.
 * Subsequent calls to {@code createInstance()} return the same instance.
 * </p>
 *
 * <p>
 * <b>Drawback:</b>
 * This implementation is not thread-safe. In a multithreaded environment, it is possible
 * for multiple threads to create separate instances of the {@code Singleton} class if they
 * call {@code createInstance()} at the same time, leading to multiple singleton objects.
 * </p>
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton Object created");
    }

    public static Singleton createInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}