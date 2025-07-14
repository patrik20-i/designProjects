class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        // private constructor to prevent instantiation
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public void displayMessage() {
        System.out.println("ThreadSafeSingleton instance: " + this);
    }
}

class EagerSingleton {
    // The single instance, created immediately
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
     public void displayMessage() {
        System.out.println("EagerSingleton instance: " + this);
    }
}

public class singletonPattern {
    public static void main(String[] args) {
        System.out.println("Singleton Pattern example");
        ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
        singleton.displayMessage();

        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        eagerSingleton.displayMessage();
    }
}