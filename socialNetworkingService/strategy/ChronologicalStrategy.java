package socialNetworkingService.strategy;

import socialNetworkingService.model.*;
import java.util.*;

public class ChronologicalStrategy implements NewsFeedGenerationStrategy {
    public List<Post> generateFeed(User user){
        
        List<Post> feed = new ArrayList<>();

        Set<User> friends = user.getFriends();

        for (User u : friends) {
            for(Post p: u.getPosts()){
                feed.add(p);
            }
        }

        feed.sort((p1,p2)-> p2.getTimestamp().compareTo(p1.getTimestamp()));

        return feed;
    }
}
