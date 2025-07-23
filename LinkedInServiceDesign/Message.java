package LinkedInServiceDesign;

import java.util.Date;
import java.util.UUID;

public class Message {
    private final String id;
    private final String content;
    private User sender;
    private User reciever;
    private final Date timestamp;

    public Message(String content, User reciever, User sender){
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.sender = sender;
        this.reciever = reciever;
        this.timestamp = new Date();
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReciever() {
        return reciever;
    }

    public void setReciever(User reciever) {
        this.reciever = reciever;
    }

    public Date getTimestamp() {
        return new Date(timestamp.getTime());
    }
}