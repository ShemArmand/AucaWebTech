package model;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @OneToOne
    @JoinColumn(name = "CourseDefinitionId")
    private CourseDefinition courseDefinition;
    
    
    @ManyToOne
    @JoinColumn(name = "AcademicUnitId")
    private AcademicUnit academicUnit;      
    
    @ManyToOne
    @JoinColumn(name = "SemesterId")
    private Semester semester; 
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TeacherId")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AssistantTutorId")
    private Teacher assistantTutor;

	public Course() {
		super();
	}

	public Course(Integer id, CourseDefinition courseDefinition, AcademicUnit academicUnit, Semester semester,
			Teacher teacher, Teacher assistantTutor) {
		super();
		this.id = id;
		this.courseDefinition = courseDefinition;
		this.academicUnit = academicUnit;
		this.semester = semester;
		this.teacher = teacher;
		this.assistantTutor = assistantTutor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CourseDefinition getCourseDefinition() {
		return courseDefinition;
	}

	public void setCourseDefinition(CourseDefinition courseDefinition) {
		this.courseDefinition = courseDefinition;
	}

	public AcademicUnit getAcademicUnit() {
		return academicUnit;
	}

	public void setAcademicUnit(AcademicUnit academicUnit) {
		this.academicUnit = academicUnit;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getAssistantTutor() {
		return assistantTutor;
	}

	public void setAssistantTutor(Teacher assistantTutor) {
		this.assistantTutor = assistantTutor;
	}
	public String getTeacherName() {
        if (teacher != null) {
            return teacher.getName();
        }
        return null;
    }

    public String getAssistantTutorName() {
        if (assistantTutor != null) {
            return assistantTutor.getName();
        }
        return null;
    }
  
    

	
    
}
