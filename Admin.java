public class Admin extends User {
    private StudentManagementSystem sms;

    public Admin(String username, String password, StudentManagementSystem sms) {
        super(username, password);
        this.sms = sms;
    }

    

    @Override
    public void addStudent(Student student) {
        sms.addStudent(student);
    }

    @Override
    public void deleteStudent(String studentId) {
        sms.deleteStudent(studentId);
    }

    @Override
    public void updateStudent(String studentId, String name, String department, String contactInfo) {
        sms.updateStudent(studentId, name, department, contactInfo);
    }

    @Override
    public Student searchStudent(String criteria) {
        return sms.searchStudent(criteria);
    }

    @Override
    public void manageEnrollment(String studentId, String courseId) {
        sms.manageEnrollment(studentId, courseId);
    }

    @Override
    public void addGrade(String studentId, String courseId, String grade) {
        sms.addGrade(studentId, courseId, grade);
    }
}
