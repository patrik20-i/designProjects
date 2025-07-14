import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManagement {
    private static TaskManagement instance;

    private final List<Task> tasks;
    private final List<User> users;

    private final Map<User, List<Task>> userTasksMap;
    private final Map<Task, List<Comment>> taskCommentsMap;

    private TaskManagement(){
        tasks = new ArrayList<>();
        users = new ArrayList<>();

        userTasksMap = new ConcurrentHashMap<>();
        taskCommentsMap = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManagement getInstance(){
        if(instance == null){
            return new TaskManagement();
        }

        return instance;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void assignTaskToUser(User user, Task task) {
        if (!tasks.contains(task) || !users.contains(user)) {
            throw new IllegalArgumentException("Task or User does not exist.");
        }
        userTasksMap.computeIfAbsent(user, _ -> new ArrayList<>()).add(task);
    }

    public List<Task> getTasksForUser(User user) {
        return userTasksMap.getOrDefault(user, new ArrayList<>());
    }

    public void addCommentToTask(Task task, Comment comment) {
        if (!tasks.contains(task)) {
            throw new IllegalArgumentException("Task does not exist.");
        }
        taskCommentsMap.computeIfAbsent(task, _ -> new ArrayList<>()).add(comment);
    }

    public List<Comment> getCommentsForTask(Task task) {
        return taskCommentsMap.getOrDefault(task, new ArrayList<>());
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        taskCommentsMap.remove(task);
        userTasksMap.values().forEach(taskList -> taskList.remove(task));
    }

    public void removeUser(User user) {
        users.remove(user);
        userTasksMap.remove(user);
    }
     
}