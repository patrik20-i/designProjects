package PubSubSystem.subscriber;

import PubSubSystem.Message;

public class PrintSubscriber implements Subscriber {
    
    @Override
    public void consume(Message message) {
        System.out.println("PrintSubscriber received: " + message.toString());
        
        // You can also access the content directly
        System.out.println("Message content: " + message.getContent());
        
        // Example of creating a new Message object
        Message newMessage = new Message("Response from PrintSubscriber");
        System.out.println("Created new message: " + newMessage);
    }
}
