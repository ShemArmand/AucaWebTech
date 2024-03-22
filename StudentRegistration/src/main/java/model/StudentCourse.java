package model;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "StudentCourse")
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
  
    @Column(name = "credits")
    private Integer credits;
  
    @Column(name = "result")
    private BigDecimal result;
  
    @ManyToOne
    @JoinColumn(name = "CourseId")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "studentRegistrationId")
    private StudentRegistration studentRegistration;

	public StudentCourse() {
		super();
	}

	public StudentCourse(Integer id, Integer credits, BigDecimal result, Course course,
			StudentRegistration studentRegistration) {
		super();
		this.id = id;
		this.credits = credits;
		this.result = result;
		this.course = course;
		this.studentRegistration = studentRegistration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public StudentRegistration getStudentRegistration() {
		return studentRegistration;
	}

	public void setStudentRegistration(StudentRegistration studentRegistration) {
		this.studentRegistration = studentRegistration;
	}

	
    // Getters and setters
    
    
    
}
