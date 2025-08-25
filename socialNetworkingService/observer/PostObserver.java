package socialNetworkingService.observer;

import socialNetworkingService.model.*;

public interface PostObserver {
    void onPostCreated(Post post);
    void onComment(Post post, Comment comment);
    void onLike(Post post, User user);
    
}
