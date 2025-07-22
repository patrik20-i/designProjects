package subscriber;

import model.Message;

public interface Subscriber {
    public void consume(Message message);
}