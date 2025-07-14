import java.util.List;

import java.util.ArrayList;

public class Task {
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private User assignedUser;
    private List<Comment> comments;

    public Task(String title, String description, TaskStatus status, TaskPriority priority, User assignedUser) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignedUser = assignedUser;
        this.comments = new ArrayList<Comment>();
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

}
