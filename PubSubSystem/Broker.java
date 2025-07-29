package PubSubSystem;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import PubSubSystem.subscriber.*;

public class Broker {
    //need a map of topics
    private final Map<String, Topic> topics = new ConcurrentHashMap<>();
    
    public Broker(){

    }

    public void createTopic(String name){
        topics.putIfAbsent(name, new Topic(name));
    }

    public void subscribe(String topicName, Subscriber subscriber){
        Topic topic = topics.get(topicName);
        if(topic == null){
            throw new IllegalArgumentException("Topic not found"+topicName);
        }
        topic.addSubscriber(subscriber);
    }

    public void unsubscribe(String topicName, Subscriber subscriber){
        Topic topic = topics.get(topicName);
        if(topic!=null){
            topic.removeSubscriber(subscriber);
        }
    }

    public void publish(String topicName, Message message){
        Topic topic = topics.get(topicName);
        if(topic == null){
            throw new IllegalArgumentException("Topic not found"+topicName);
        }
        if(topic!=null){
            topic.broadCast(message);
        }
    }


}