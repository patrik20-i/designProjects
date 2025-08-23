package CourseRegistrationSystem;

public class Registration {
    private Student student;
    private Course course;

    public Registration(Student student, Course course){
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public synchronized void registerCourse(Student student, Course course){
        // Check if student is already enrolled
        if (student.getEnrolledCourses().contains(course.getCode())) {
            System.out.println("Student " + student.getId() + " is already enrolled in course " + course.getCode());
            return;
        }
        
        // Check course capacity
        if(course.getEnrolledStudents() >= course.getCapacity()){
            System.out.println("Course " + course.getCode() + " is full. Cannot register student " + student.getId());
            return;
        }
        
        // Perform registration
        course.addStudent(student.getId());
        student.addCourse(course.getCode());
        System.out.println("Student " + student.getId() + " successfully registered for course " + course.getCode());
    }

    public synchronized void dropCourse(Student student, Course course) {
        if (!student.getEnrolledCourses().contains(course.getCode())) {
            System.out.println("Student " + student.getId() + " is not enrolled in course " + course.getCode());
            return;
        }
        
        // Perform drop
        course.removeStudent(student.getId());
        student.removeCourse(course.getCode());
        System.out.println("Student " + student.getId() + " successfully dropped from course " + course.getCode());
    }

    // Static utility methods for direct registration/dropping without creating Registration instances
    public static synchronized void performRegistration(Student student, Course course) {
        Registration registration = new Registration(student, course);
        registration.registerCourse(student, course);
    }

    public static synchronized void performDrop(Student student, Course course) {
        Registration registration = new Registration(student, course);
        registration.dropCourse(student, course);
    }

    // Method to get registration status
    public boolean isStudentRegistered() {
        return student.getEnrolledCourses().contains(course.getCode());
    }

    @Override
    public String toString() {
        return "Registration{" +
                "student=" + student.getName() + " (" + student.getId() + ")" +
                ", course=" + course.getName() + " (" + course.getCode() + ")" +
                ", registered=" + isStudentRegistered() +
                '}';
    }

}
