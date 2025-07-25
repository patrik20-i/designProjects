<<<<<<< HEAD
=======
package PubSubSystem;

import PubSubSystem.subscriber.Subscriber;
>>>>>>> 7e4a7db81eeb4d7593f38ae57462fef521d76fd0

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import subscriber.Subscriber;

public class Topic {
    private final String name;
    private final Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();

    public Topic(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void broadCast(Message message){
        for(Subscriber subscriber: subscribers){
            Dispatcher.dispatch(subscriber,message);
        }

    }

    
}
