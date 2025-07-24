package PubSubSystem;

public class Publisher {
    private final String id;
    private final Broker broker;

    public Publisher(String id, Broker broker){
        this.id = id;
        this.broker = broker;
    }

    public void publish(Topic topic, String payload){
        Message message = new Message(payload);
        broker.publish(topic.getName(), message);
    }

    public String getId(){
        return id;
    }
    
}
