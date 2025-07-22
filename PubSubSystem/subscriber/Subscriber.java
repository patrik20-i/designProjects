package PubSubSystem.subscriber;

import PubSubSystem.Message;

public interface Subscriber {
    public void consume(Message message);
}