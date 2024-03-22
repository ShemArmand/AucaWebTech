package model;

import javax.persistence.*;

@Entity
@Table(name = "StudentRegistration")
public class StudentRegistration {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Integer id;
@OneToOne
@JoinColumn(name = "studentId")
private Student student;



@Column(name = "registrationDate")
private String registrationDate;

@ManyToOne
@JoinColumn(name = "AcademicUnitId")
private AcademicUnit academicUnit;

@OneToOne
@JoinColumn(name = "SemesterId")
private Semester semester;


@Enumerated(EnumType.STRING)
@Column(name = "status",  columnDefinition = "ENUM('PENDING','ADMITTED','REJECTED')")
private StatusEnum status;

// Getters and setters
public enum StatusEnum {
    PENDING, ADMITTED, REJECTED
}

public StudentRegistration() {
	super();
}

public StudentRegistration(Integer id, Student student, String registrationDate, AcademicUnit academicUnit,
		Semester semester, StatusEnum status) {
		super();
		this.id = id;
		this.student = student;
		this.registrationDate = registrationDate;
		this.academicUnit = academicUnit;
		this.semester = semester;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
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
	
	public StatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
	    // You can convert the input String to the corresponding StatusEnum
	    if (status != null) {
	        this.status = StudentRegistration.StatusEnum.valueOf(status);
	    }
	}
}