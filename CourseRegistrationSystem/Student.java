package CourseRegistrationSystem;

import java.util.List;
import java.util.ArrayList;

public class Student {
    private final String id;
    private final String name;
    private final String email;
    private List<String> enrolledCourses;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.enrolledCourses = new ArrayList<>();
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

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void addCourse(String courseCode){
        if (!enrolledCourses.contains(courseCode)) {
            enrolledCourses.add(courseCode);
        }
    }
    
    public void removeCourse(String courseCode){
        enrolledCourses.remove(courseCode);
    }
}
