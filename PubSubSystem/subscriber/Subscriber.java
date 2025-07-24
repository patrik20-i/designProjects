package subscriber;

import PubSubSystem.Message;

public interface Subscriber {
    void consume(Message message);
}