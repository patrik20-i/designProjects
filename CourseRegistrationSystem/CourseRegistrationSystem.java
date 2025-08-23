package CourseRegistrationSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * CourseRegistrationSystem - Singleton class for managing course registrations
 * 
 * This system uses the Registration class for all course enrollment and dropping operations.
 * The Registration class encapsulates the business logic for registering/dropping courses,
 * while this system manages the overall data storage and provides high-level operations.
 * 
 * Key design patterns used:
 * - Singleton Pattern: Ensures only one instance of the registration system
 * - Delegation Pattern: Delegates registration/drop operations to Registration class
 * - Thread Safety: Uses synchronized methods in Registration class for concurrent access
 */



public class CourseRegistrationSystem{
    private final Map<String, Student> students;
    private final Map<String, Course> courses;
    
    //defining multiple object for locking different functionalities
    private static final Object REGISTRATION_LOCK = new Object();
    private static final Object STUDENT_MANAGEMENT_LOCK = new Object();
    private static final Object COURSE_MANAGEMENT_LOCK = new Object();
    private static final Object INSTANCE_LOCK = new Object();
    private static volatile CourseRegistrationSystem instance;

    
    private CourseRegistrationSystem(){
        students = new ConcurrentHashMap<>();
        courses = new ConcurrentHashMap<>();
    }

    public static CourseRegistrationSystem getInstance() {
        if (instance == null) {
            synchronized (INSTANCE_LOCK) {
                if (instance == null) {
                    instance = new CourseRegistrationSystem();
                }
            }
        }
        return instance;
    }

    public void addStudent(Student student){
        synchronized(STUDENT_MANAGEMENT_LOCK){
            if(students.get(student.getId()) == null){
                students.put(student.getId(), student);
            }
        }
    }
    public void removeStudent(String studentId) {
        synchronized(STUDENT_MANAGEMENT_LOCK){
            if(students.containsKey(studentId)){
                students.remove(studentId);
            }
            else{
                System.out.println("Student not found: "+ studentId);
            }
        }
    }

    public void addCourse(Course course) {
        synchronized(COURSE_MANAGEMENT_LOCK){
            if (courses.get(course.getCode()) == null) {
                courses.put(course.getCode(), course);
            }
        }
    }

    public void removeCourse(String courseId) {
        synchronized(COURSE_MANAGEMENT_LOCK){
            if (courses.containsKey(courseId)) {
                courses.remove(courseId);
            } else {
                System.out.println("Course not found: " + courseId);
            }

        }
    }
    public void registerStudentForCourse(String studentId, String courseCode) {
        
        synchronized(REGISTRATION_LOCK)
        {
            Student student = students.get(studentId);
            Course course = courses.get(courseCode);
            
            if (student == null) {
                System.out.println("Student not found: " + studentId);
                return;
            }
            
            if (course == null) {
                System.out.println("Course not found: " + courseCode);
                return;
            }
            
            // Use Registration class static method for the actual registration logic
            Registration.performRegistration(student, course);
        }
    }

    public void dropStudentFromCourse(String studentId, String courseCode) {
        synchronized(REGISTRATION_LOCK){
            Student student = students.get(studentId);
            Course course = courses.get(courseCode);
            
            if (student == null) {
                System.out.println("Student not found: " + studentId);
                return;
            }
            
            if (course == null) {
                System.out.println("Course not found: " + courseCode);
                return;
            }
            
            // Use Registration class static method for the actual drop logic
            Registration.performDrop(student, course);
        }
    }

    // Method to get a Registration object for advanced operations
    public Registration getRegistration(String studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);
        
        if (student == null || course == null) {
            return null;
        }
        
        return new Registration(student, course);
    }

    // Method to get all registrations for a student
    public void displayStudentRegistrations(String studentId) {
        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found: " + studentId);
            return;
        }
        
        System.out.println("=== Registrations for " + student.getName() + " (" + studentId + ") ===");
        for (String courseCode : student.getEnrolledCourses()) {
            Course course = courses.get(courseCode);
            if (course != null) {
                Registration registration = new Registration(student, course);
                System.out.println(registration);
            }
        }
    }

    public void displayAllEnrollments() {
        System.out.println("=== All Student Enrollments ===");
        for (Student student : students.values()) {
            System.out.println("Student: " + student.getName() + " (" + student.getId() + ")");
            if (student.getEnrolledCourses().isEmpty()) {
                System.out.println("  No courses enrolled");
            } else {
                System.out.println("  Enrolled courses: " + student.getEnrolledCourses());
            }
        }
    }

    public void displayCourseCapacities() {
        System.out.println("=== Course Enrollment Status ===");
        for (Course course : courses.values()) {
            System.out.println("Course: " + course.getName() + " (" + course.getCode() + ")");
            System.out.println("  Capacity: " + course.getEnrolledStudents() + "/" + course.getCapacity());
            System.out.println("  Enrolled students: " + course.getEnrolledStudentIds());
        }
    }

}
