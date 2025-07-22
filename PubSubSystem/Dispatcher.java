package PubSubSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import PubSubSystem.subscriber.*;

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
