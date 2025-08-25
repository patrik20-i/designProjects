package socialNetworkingService.model;

public class Comment extends CommentableEntity{
    public Comment(User author, String content){
        super(author, content);
    }
}
