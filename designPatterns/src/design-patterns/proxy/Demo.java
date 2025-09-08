/**
 * Demonstrates the Proxy Design Pattern using a database query execution scenario.
 * <p>
 * In this example, the Proxy Design Pattern is used to control access to a resource (database query execution).
 * The {@code DataBaseExecuterProxy} acts as a surrogate for the real database executer, allowing only authorized users
 * (e.g., users with correct credentials) to execute certain queries such as "DELETE".
 * <p>
 * The {@code main} method creates an instance of {@code IExecuter} using the proxy, passing user credentials.
 * It then attempts to execute a "DELETE" query. The proxy checks the credentials and determines whether the operation
 * should be allowed, thus providing an additional layer of security and access control.
 * <p>
 * This pattern is useful for scenarios where you want to add functionality (like access control, logging, or caching)
 * to an object without modifying its code.
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        
        IExecuter nonAdminExecuter = new DataBaseExecuterProxy("Admin","Admin@123");
        nonAdminExecuter.executeQuery("DELETE");

    }

    
}
