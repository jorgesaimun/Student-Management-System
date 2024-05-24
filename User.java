public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
     
    
    public abstract void addStudent(Student student);
    public abstract void deleteStudent(String studentId);
    public abstract void updateStudent(String studentId, String name, String department, String contactInfo);
    public abstract Student searchStudent(String criteria);
    public abstract void manageEnrollment(String studentId, String courseId);
    public abstract void addGrade(String studentId, String courseId, String grade);
}
