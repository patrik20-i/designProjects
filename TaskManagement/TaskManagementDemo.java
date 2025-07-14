public class TaskManagementDemo {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        TaskManagement taskManagement = TaskManagement.getInstance();

        User user1 = new User("parteek");
        User user2 = new User("legend");

        // Add users to the task management system
        taskManagement.addUser(user1);
        taskManagement.addUser(user2);

        Task task1 = new Task("Design UI", "Create wireframes for the new dashboard", TaskStatus.NotStarted, TaskPriority.High, user2);
        Task task2 = new Task("Implement Backend", "Develop REST APIs for task management", TaskStatus.NotStarted, TaskPriority.Medium, user2);
        Task task3 = new Task("Testing", "Write unit tests for the backend logic", TaskStatus.NotStarted, TaskPriority.Low, user2);

        // Add tasks to the task management system
        taskManagement.addTask(task1);
        taskManagement.addTask(task2);
        taskManagement.addTask(task3);

        // Assign tasks to users
        taskManagement.assignTaskToUser(user1, task1);
        taskManagement.assignTaskToUser(user2, task2);
        taskManagement.assignTaskToUser(user1, task3);

        // Add comments to tasks
        task1.addComment(new Comment(user2, "Let me know if you need any feedback."));
        task2.addComment(new Comment(user1, "APIs should follow RESTful conventions."));
        task2.addComment(new Comment(user2, "Sure, I'll document the endpoints."));
        task3.addComment(new Comment(user1, "I'll start with the service layer tests."));
        task3.addComment(new Comment(user2, "Let me know if you find any issues."));

        // Print tasks and comments for each user
        System.out.println("Tasks for " + user1.getName() + ":");
        for (Task task : taskManagement.getTasksForUser(user1)) {
            System.out.println("- " + task.getTitle() + ": " + task.getDescription());
            for (Comment comment : task.getComments()) {
                System.out.println("  * " + comment.getUser().getName() + ": " + comment.getDescription());
            }
        }

        System.out.println("\nTasks for " + user2.getName() + ":");
        for (Task task : taskManagement.getTasksForUser(user2)) {
            System.out.println("- " + task.getTitle() + ": " + task.getDescription());
            for (Comment comment : task.getComments()) {
                System.out.println("  * " + comment.getUser().getName() + ": " + comment.getDescription());
            }
        }
    }
    
}
