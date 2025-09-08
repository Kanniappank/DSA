/**
 * The {@code Singleton} class demonstrates the Bill Pugh Singleton Design Pattern.
 * <p>
 * This approach leverages a static inner helper class to create the singleton instance.
 * The instance is created only when {@link #getInstance()} is called for the first time,
 * ensuring lazy initialization.
 * <ul>
 *   <li><b>Thread Safety:</b> The static inner class is loaded only when referenced,
 *       guaranteeing thread-safe initialization without explicit synchronization.</li>
 *   <li><b>Lazy Initialization:</b> The singleton instance is not created until it is needed,
 *       saving resources and improving performance.</li>
 *   <li><b>Performance:</b> No synchronization overhead is incurred during instance retrieval,
 *       making it more efficient than other thread-safe singleton implementations.</li>
 *   <li><b>Clarity:</b> The implementation is concise and avoids complex locking mechanisms.</li>
 * </ul>
 * <p>
 * This makes the Bill Pugh approach a preferred and robust way to implement the Singleton pattern in Java.
 */
package singleton.bill_pugh;



public class Singleton {

    // Private constructor prevents instantiation from other classes
    private Singleton() {
        System.out.println("Singleton instance created");
    }

    // Static inner class - loaded only when getInstance() is called
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Global access point
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}


class Main {
    public static void main(String[] args) {
        System.out.println("Calling getInstance first time:");
        Singleton s1 = Singleton.getInstance();

        System.out.println("Calling getInstance second time:");
        Singleton s2 = Singleton.getInstance();

        System.out.println("Are both instances same? " + (s1 == s2));
    }
}
