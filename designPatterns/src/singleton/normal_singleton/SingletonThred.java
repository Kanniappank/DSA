package singleton.normal_singleton;


public class SingletonThred {

    public static void main(String[] args) {
        Runnable task =()->{
            Singleton instance = Singleton.createInstance();
            System.out.println(Thread.currentThread().getName()+" -> "+instance.hashCode());
        };

        Thread thread1=new Thread(task,"Thread-1");
        Thread thread2=new Thread(task,"Thread-2");
    
        thread1.start();
        thread2.start();
    }

    
}
