import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    
    private String id;
    private String name;
    private String department;
    private String contactInfo;

    private List<String> courses;
    private Map<String, String> grades;

    public Student(String name, String department, String contactInfo) {
        this.id = generateStudentId();
        this.name = name;
        this.department = department;
        this.contactInfo = contactInfo;
        this.courses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    private String generateStudentId() {
        return String.format("%05d", (int) (Math.random() * 100000));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void enrollCourse(String courseId) {
        courses.add(courseId);
    }

    public void addGrade(String courseId, String grade) {
        grades.put(courseId, grade);
    }

    public List<String> getCourses() {
        return courses;
    }

    public Map<String, String> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", courses=" + courses +
                ", grades=" + grades +
                '}';
    }
}
