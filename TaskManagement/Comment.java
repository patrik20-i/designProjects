public class Comment {
    private final User user;
    private final String description;
    private final String timestamp;

    public Comment(User user, String description){
        this.user = user;
        this.description = description;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public User getUser(){
        return user;
    }

    public String getDescription(){
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
