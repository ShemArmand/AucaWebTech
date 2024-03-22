package model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Integer code;
  
    @Column(name = "names")
    private String names;
  
    @Column(name = "teach")
    private String teach;
  
    @Column(name = "assistantTutor")
    private String assistantTutor;

    @Column(name = "name") // Add this line
    private String name;
  
    @Enumerated(EnumType.STRING)
    @Column(name = "qualification", columnDefinition = "ENUM('MASTER','PHD','PROFESSOR')")
    private QualificationEnum qualification;
    
    @OneToMany(mappedBy = "teacher")
    private List<Course> teacherCourses;
    
    @OneToMany(mappedBy = "assistantTutor")
    private List<Course> assistantCourses;
  
    // Getters and setters
    public enum QualificationEnum {
        MASTER, PHD, PROFESSOR
    }

    public Teacher() {
        super();
    }

    public Teacher(Integer code, String names, String teach, String assistantTutor, String name, QualificationEnum qualification, List<Course> teacherCourses, List<Course> assistantCourses) {
        super();
        this.code = code;
        this.names = names;
        this.teach = teach;
        this.assistantTutor = assistantTutor;
        this.name = name;
        this.qualification = qualification;
        this.teacherCourses = teacherCourses;
        this.assistantCourses = assistantCourses;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTeach() {
        return teach;
    }

    public void setTeach(String teach) {
        this.teach = teach;
    }

    public String getAssistantTutor() {
        return assistantTutor;
    }

    public void setAssistantTutor(String assistantTutor) {
        this.assistantTutor = assistantTutor;
    }

    public String getName() { // Add this getter
        return name;
    }

    public void setName(String name) { // Add this setter
        this.name = name;
    }

    public QualificationEnum getQualification() {
        return qualification;
    }

    public void setQualification(QualificationEnum qualification) {
        this.qualification = qualification;
    }

    public List<Course> getTeacherCourses() {
        return teacherCourses;
    }

    public void setTeacherCourses(List<Course> teacherCourses) {
        this.teacherCourses = teacherCourses;
    }

    public List<Course> getAssistantCourses() {
        return assistantCourses;
    }

    public void setAssistantCourses(List<Course> assistantCourses) {
        this.assistantCourses = assistantCourses;
    }
    public String getAssistantTutorName() {
        // Implementation to retrieve the assistant tutor name
        // Replace this with your actual implementation logic
        return "Assistant Tutor Name";
    }
}