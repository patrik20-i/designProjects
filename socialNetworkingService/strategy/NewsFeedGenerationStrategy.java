package socialNetworkingService.strategy;

import java.util.List;

import socialNetworkingService.model.*;

public interface NewsFeedGenerationStrategy {
    List<Post> generateFeed(User user);
}
