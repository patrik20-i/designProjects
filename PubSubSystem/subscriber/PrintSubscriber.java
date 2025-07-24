package PubSubSystem.subscriber;

import PubSubSystem.Message;

import PubSubSystem.Message;

public class PrintSubscriber implements Subscriber {
<<<<<<< HEAD
    @Override
    public void consume(Message message) {
        System.out.println("Received message: " + message.toString());
=======
    
    @Override
    public void consume(Message message) {
        System.out.println("PrintSubscriber received: " + message.toString());
        
        // You can also access the content directly
        System.out.println("Message content: " + message.getContent());
        
        // Example of creating a new Message object
        Message newMessage = new Message("Response from PrintSubscriber");
        System.out.println("Created new message: " + newMessage);
>>>>>>> 7e4a7db81eeb4d7593f38ae57462fef521d76fd0
    }
}
