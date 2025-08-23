package CourseRegistrationSystem;

public class CourseRegistrationDemo {
    public static void main(String[] args) {
        // Get the singleton instance of the course registration system
        CourseRegistrationSystem system = CourseRegistrationSystem.getInstance();
        
        // Add some students
        Student student1 = new Student("S001", "Alice Johnson", "alice@email.com");
        Student student2 = new Student("S002", "Bob Smith", "bob@email.com");
        Student student3 = new Student("S003", "Charlie Brown", "charlie@email.com");
        
        system.addStudent(student1);
        system.addStudent(student2);
        system.addStudent(student3);
        
        // Add some courses
        Course course1 = new Course("CS101", "Introduction to Programming", 3, 30);
        Course course2 = new Course("MATH201", "Calculus I", 4, 25);
        Course course3 = new Course("ENG102", "English Composition", 3, 20);
        
        system.addCourse(course1);
        system.addCourse(course2);
        system.addCourse(course3);
        
        System.out.println("=== Course Registration System Demo ===\n");
        
        // Register students in courses
        System.out.println("Registering students in courses:");
        system.registerStudentForCourse("S001", "CS101");
        system.registerStudentForCourse("S001", "MATH201");
        system.registerStudentForCourse("S002", "CS101");
        system.registerStudentForCourse("S002", "ENG102");
        system.registerStudentForCourse("S003", "MATH201");
        system.registerStudentForCourse("S003", "ENG102");
        
        System.out.println("\nCurrent enrollments:");
        system.displayAllEnrollments();
        
        // Drop some courses
        System.out.println("\nDropping courses:");
        system.dropStudentFromCourse("S001", "MATH201");
        system.dropStudentFromCourse("S002", "ENG102");
        
        System.out.println("\nEnrollments after drops:");
        system.displayAllEnrollments();
        
        // Display course capacities
        System.out.println("\nCourse enrollment status:");
        system.displayCourseCapacities();
    }
    
}
