package PubSubSystem.subscriber;

public class LoggingSubscriber implements Subscriber {
    
    @Override
    public void consume(Message message) {
        // Log the message
        System.out.println("[LOG] " + java.time.LocalDateTime.now() + " - " + message.toString());
        
        // You can also create new Message objects
        Message logMessage = new Message("Logged: " + message.getContent());
        System.out.println("[LOG] Created log message: " + logMessage);
    }
}
