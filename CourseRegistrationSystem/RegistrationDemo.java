package CourseRegistrationSystem;

public class RegistrationDemo {
    public static void main(String[] args) {
        System.out.println("=== Registration Class Demo ===\n");
        
        // Get the singleton instance
        CourseRegistrationSystem system = CourseRegistrationSystem.getInstance();
        
        // Add students and courses
        Student student1 = new Student("REG001", "John Doe", "john@email.com");
        Student student2 = new Student("REG002", "Jane Smith", "jane@email.com");
        
        Course course1 = new Course("JAVA101", "Java Programming", 4, 2); // Small capacity for testing
        Course course2 = new Course("DB201", "Database Design", 3, 5);
        
        system.addStudent(student1);
        system.addStudent(student2);
        system.addCourse(course1);
        system.addCourse(course2);
        
        System.out.println("1. Using CourseRegistrationSystem methods (which delegate to Registration):");
        system.registerStudentForCourse("REG001", "JAVA101");
        system.registerStudentForCourse("REG002", "JAVA101");
        
        // Try to register a third student (should fail due to capacity)
        Student student3 = new Student("REG003", "Bob Wilson", "bob@email.com");
        system.addStudent(student3);
        system.registerStudentForCourse("REG003", "JAVA101");
        
        System.out.println("\n2. Using Registration class directly:");
        
        // Get Registration objects for direct operations
        Registration reg1 = system.getRegistration("REG001", "DB201");
        Registration reg2 = system.getRegistration("REG002", "DB201");
        Registration reg3 = system.getRegistration("REG003", "DB201");
        
        if (reg1 != null) {
            System.out.println("Registration object: " + reg1);
            reg1.registerCourse(student1, course2);
        }
        
        if (reg2 != null) {
            reg2.registerCourse(student2, course2);
        }
        
        if (reg3 != null) {
            reg3.registerCourse(student3, course2);
        }
        
        System.out.println("\n3. Using static Registration methods:");
        
        // Try to register someone who's already registered (should fail)
        Registration.performRegistration(student1, course2);
        
        // Test dropping courses
        Registration.performDrop(student1, course1);
        
        System.out.println("\n4. Display individual student registrations:");
        system.displayStudentRegistrations("REG001");
        system.displayStudentRegistrations("REG002");
        system.displayStudentRegistrations("REG003");
        
        System.out.println("\n5. Check registration status:");
        Registration checkReg = system.getRegistration("REG002", "JAVA101");
        if (checkReg != null) {
            System.out.println("Is REG002 registered for JAVA101? " + checkReg.isStudentRegistered());
        }
        
        Registration checkReg2 = system.getRegistration("REG003", "JAVA101");
        if (checkReg2 != null) {
            System.out.println("Is REG003 registered for JAVA101? " + checkReg2.isStudentRegistered());
        }
        
        System.out.println("\n=== Final Status ===");
        system.displayAllEnrollments();
        system.displayCourseCapacities();
    }
}
