package statergy;

public class StatergyDemo {
    /*
     * Strategy Design Pattern solves the following problems:
     * 
     * 1. When you need to switch between different algorithms or behaviors at
     * runtime
     * 2. When you have a family of similar algorithms and need to make them
     * interchangeable
     * 3. When you want to avoid multiple conditional statements for selecting
     * behavior
     * 4. When different variants of an algorithm exist and you want to isolate them
     * 5. When a class defines many behaviors that appear as multiple conditional
     * statements
     * 
     * The pattern enables:
     * - Encapsulation of algorithms/behaviors into separate strategy classes
     * - Runtime switching between different strategies
     * - Decoupling the algorithm implementation from code that uses the algorithm
     * - Easy addition of new strategies without changing existing code
     * 
     */
    public static void main(String[] args) {
        PaymentStatergy creditCard = new CreditCardPayment();
        PaymentStatergy paypal = new PaypalPayment();
        PaymentStatergy stripe = new StripePayment();
        PaymentStatergy crypto = new CryptoPayment();

        PaymentProcessor processor = new PaymentProcessor(creditCard);
        processor.executePayment();

        processor.setPaymentProcessor(stripe);
        processor.executePayment();

        processor.setPaymentProcessor(paypal);
        processor.executePayment();

        processor.setPaymentProcessor(crypto);
        processor.executePayment();

    }
    /*
 * Real-world Use Cases for Strategy Pattern:
 * 
 * 1. Payment Processing Systems:
 *    - Different payment methods (Credit Card, PayPal, Stripe, Crypto) can be swapped at runtime
 *    - Each payment method has its own validation and processing logic
 *    - New payment methods can be added without modifying existing code
 * 
 * 2. Navigation/Route Finding Apps:
 *    - Different routing algorithms for car, walking, public transit
 *    - Users can switch between route types on demand
 *    - Each routing strategy has specific logic for that mode of transport
 * 
 * 3. Data Compression:
 *    - Multiple compression algorithms (ZIP, RAR, 7z etc)
 *    - Application can choose compression type based on file type/size
 *    - Easy to add new compression methods
 * 
 * 4. Sorting Algorithms:
 *    - Different sorting strategies (QuickSort, MergeSort, BubbleSort)
 *    - Algorithm can be selected based on data size/type
 *    - Each sort maintains its own implementation
 * 
 * 5. Authentication Strategies:
 *    - Multiple auth methods (OAuth, JWT, Basic Auth)
 *    - System can switch between auth types as needed
 *    - Each auth strategy encapsulates its security logic
 * 
 * 6. Tax Calculation:
 *    - Different tax rules for various regions/countries
 *    - Tax strategy can change based on customer location
 *    - Easy to add new regional tax calculations
 */    
}
