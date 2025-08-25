package socialNetworkingService.service;

import socialNetworkingService.strategy.*;

import java.util.List;

import socialNetworkingService.model.*;

public class NewsFeedService {
    private NewsFeedGenerationStrategy strategy;

    public NewsFeedService(){
        this.strategy = new ChronologicalStrategy();
    }

    public void setStrategy(NewsFeedGenerationStrategy strategy){
        this.strategy = strategy;
    }
    
    public List<Post> getFeed(User user){
        return strategy.generateFeed(user);
    }
}
