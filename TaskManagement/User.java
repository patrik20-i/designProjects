import java.util.List;
import java.util.ArrayList;

public class User {
    private final Integer id;
    private final String name;
    private final List<Task> tasks;
    private final List<Comment> comments;

    public User(String name){
        this.id = generateID();
        this.name = name;
        tasks = new ArrayList<>();
        comments = new ArrayList<>();
    }

    private static int idCounter = 1;

    private Integer generateID() {
        return idCounter++;
    }

    public Integer getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void assignTask(Task task){
        tasks.add(task);
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public List<Comment> getComments(){
        return comments;
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
    }
}
