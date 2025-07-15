package subscriber;

import PubSubSystem.Message;
import PubSubSystem.Publisher;

public interface Subscriber {
    public void consume(Message message);
}