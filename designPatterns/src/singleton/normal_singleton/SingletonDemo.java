package singleton.normal_singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.createInstance();
        Singleton obj2 = Singleton.createInstance();

        System.out.println(obj1.equals(obj2));

    }
}