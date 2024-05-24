
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManagementSystem {
    private Map<String, Student> students;
    private Map<String, Course> courses;
    private List<Enrollment> enrollments;

    public StudentManagementSystem() {
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
        this.enrollments = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void deleteStudent(String studentId) {
        students.remove(studentId);
    }

    public void updateStudent(String studentId, String name, String department, String contactInfo) {
        Student student = students.get(studentId);
        if (student != null) {
            student.setName(name);
            student.setDepartment(department);
            student.setContactInfo(contactInfo);
        }
    }

    public Student searchStudent(String criteria) {
        for (Student student : students.values()) {
            if (student.getName().equals(criteria) || student.getId().equals(criteria)) {
                return student;
            }
        }
        return null;
    }

    // .................................................................................
    public boolean findById(String Id) {

        for (Student student : students.values()) {
            if (student.getId().equals(Id))
                return true;
        }

        return false;
    }

    public boolean findByName(String name) {

        for (Student student : students.values()) {
            if (student.getName().equals(name))
                return true;
        }

        return false;
    }
    // ...........................................................................

    public void manageEnrollment(String studentId, String courseId) {
        Student student = students.get(studentId);
        if (student != null) {
            student.enrollCourse(courseId);
        } else {

        }

    }

    public void addGrade(String studentId, String courseId, String grade) {
        Student student = students.get(studentId);
        if (student != null) {
            student.addGrade(courseId, grade);
        } else {
            System.out.println("Student Id not found .Please try again ");
        }
    }


    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
    }

    public Course getCourse(String courseId) {
        return courses.get(courseId);
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public int studentCount() {
        return getAllStudents().size();
    }

    public Student getStudentById(String studentId) {

        return students.get(studentId);
    }
}
