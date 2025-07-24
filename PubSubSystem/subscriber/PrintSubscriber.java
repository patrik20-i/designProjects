package subscriber;

import PubSubSystem.Message;

public class PrintSubscriber implements Subscriber {
    @Override
    public void consume(Message message) {
        System.out.println("Received message: " + message.toString());
    }
}
