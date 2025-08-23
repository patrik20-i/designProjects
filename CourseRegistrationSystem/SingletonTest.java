package CourseRegistrationSystem;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Test ===");
        
        // Get two instances and verify they are the same
        CourseRegistrationSystem system1 = CourseRegistrationSystem.getInstance();
        CourseRegistrationSystem system2 = CourseRegistrationSystem.getInstance();
        
        System.out.println("Instance 1: " + system1);
        System.out.println("Instance 2: " + system2);
        System.out.println("Are they the same instance? " + (system1 == system2));
        System.out.println("Hash codes match? " + (system1.hashCode() == system2.hashCode()));
        
        // Add a student using one instance
        Student testStudent = new Student("TEST001", "Test Student", "test@email.com");
        system1.addStudent(testStudent);
        
        // Try to add a course using the other instance
        Course testCourse = new Course("TEST101", "Test Course", 3, 10);
        system2.addCourse(testCourse);
        
        // Register student for course using first instance
        system1.registerStudentForCourse("TEST001", "TEST101");
        
        // Display enrollments using second instance to verify data consistency
        system2.displayAllEnrollments();
        
        System.out.println("\n=== Singleton test completed successfully! ===");
    }
}
