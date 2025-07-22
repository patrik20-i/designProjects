import model.Message;
import subscriber.PrintSubscriber;
import subscriber.LoggingSubscriber;
import subscriber.Subscriber;

public class SubscriberDemo {
    public static void main(String[] args) {
        // Create Message objects
        Message message1 = new Message("Hello World!");
        Message message2 = new Message("This is a test message");
        Message message3 = new Message("PubSub System Working!");
        
        // Create subscribers
        Subscriber printSubscriber = new PrintSubscriber();
        Subscriber loggingSubscriber = new LoggingSubscriber();
        
        System.out.println("=== PrintSubscriber Demo ===");
        printSubscriber.consume(message1);
        printSubscriber.consume(message2);
        
        System.out.println("\n=== LoggingSubscriber Demo ===");
        loggingSubscriber.consume(message2);
        loggingSubscriber.consume(message3);
        
        System.out.println("\n=== Creating Message objects in main ===");
        // You can create Message objects anywhere and pass them around
        Message customMessage = new Message("Custom message created in main");
        System.out.println("Created: " + customMessage);
        System.out.println("Content: " + customMessage.getContent());
        
        // Pass to subscribers
        printSubscriber.consume(customMessage);
        loggingSubscriber.consume(customMessage);
    }
}
