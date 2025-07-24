<<<<<<< HEAD

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import subscriber.Subscriber;
=======
package PubSubSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import PubSubSystem.subscriber.*;
>>>>>>> 7e4a7db81eeb4d7593f38ae57462fef521d76fd0

public class Dispatcher {
    static private final ExecutorService executor = Executors.newCachedThreadPool();
    public Dispatcher(){
    }

    public static void dispatch(Subscriber subscriber, Message message){
        //submit a runable task to executor
        executor.submit(()->{
            try {
                subscriber.consume(message);
            } catch (Exception e) {
                System.err.println("dispatch error:"+ e.getMessage());
            }
        });

    }

    public void shutDown(){
        executor.shutdown();
    }
}
