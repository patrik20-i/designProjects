package CourseRegistrationSystem;

import java.util.List;
import java.util.ArrayList;

public class Course {
    private final String code;
    private final String name;
    private final int credits;
    private final int capacity;
    private List<String> enrolledStudentIds;

    public Course(String code, String name, int credits, int capacity) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.capacity = capacity;
        this.enrolledStudentIds = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents(){
        return enrolledStudentIds.size();
    }

    public List<String> getEnrolledStudentIds() {
        return new ArrayList<>(enrolledStudentIds);
    }

    public void setEnrolledStudentIds(List<String> enrolledStudentIds) {
        this.enrolledStudentIds = enrolledStudentIds;
    }

    public void addStudent(String studentId){
        if (!enrolledStudentIds.contains(studentId)) {
            enrolledStudentIds.add(studentId);
        }
    }

    public void removeStudent(String studentId){
        enrolledStudentIds.remove(studentId);
    }
}
