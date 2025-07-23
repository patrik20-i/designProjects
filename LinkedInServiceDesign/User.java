package LinkedInServiceDesign;

import java.util.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String password;
    private Profile profile;
    private final List<Connection> connections;
    private final List<Message> inbox;
    private final List<Message> sentMessages;
    private final List<Notification> notifications;
    

    public User(String name, String email , String password){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        this.connections = new ArrayList<>();
        this.sentMessages = new ArrayList<>();
        this.inbox = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public void setProfile(Profile profile){
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections);
    }

    public List<Message> getInbox() {
        return Collections.unmodifiableList(inbox);
    }

    public List<Message> getSentMessages() {
        return Collections.unmodifiableList(sentMessages);
    }

    public List<Notification> getNotifications() {
        return Collections.unmodifiableList(notifications);
    }

    public void addConnection(Connection connection) {
        if (connection != null && !connections.contains(connection)) {
            connections.add(connection);
        }
    }

    public void addMessageToInbox(Message message) {
        if (message != null) {
            inbox.add(message);
        }
    }

    public void addSentMessage(Message message) {
        if (message != null) {
            sentMessages.add(message);
        }
    }

    public void addNotification(Notification notification) {
        if (notification != null) {
            notifications.add(notification);
        }
    }

}