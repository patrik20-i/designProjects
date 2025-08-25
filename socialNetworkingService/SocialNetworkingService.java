package socialNetworkingService;

import java.util.List;

import socialNetworkingService.model.Post;
import socialNetworkingService.observer.UserNotifier;
import socialNetworkingService.service.*;

import socialNetworkingService.model.*;

public class SocialNetworkingService {
    private final UserService userService;
    private final PostService postService;
    private final NewsFeedService newsFeedService;

    public SocialNetworkingService(){
        userService = new UserService();
        postService = new PostService();
        newsFeedService = new NewsFeedService();
        postService.addObserver(new UserNotifier());
    }

     public User createUser(String name, String email) {
        return userService.createUser(name, email);
    }

    public void addFriend(String userId1, String userId2) {
        userService.addFriend(userId1, userId2);
    }

    public Post createPost(String authorId, String content) {
        User author = userService.getUserById(authorId);
        return postService.createPost(author, content);
    }

    public void addComment(String userId, String postId, String content) {
        User user = userService.getUserById(userId);
        postService.addComment(user, postId, content);
    }

    public void likePost(String userId, String postId) {
        User user = userService.getUserById(userId);
        postService.likePost(user, postId);
    }

    public List<Post> getNewsFeed(String userId) {
        User user = userService.getUserById(userId);
        return newsFeedService.getFeed(user);
    }
    
}
