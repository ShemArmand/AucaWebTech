package model;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @Column(name = "regNo", unique=true)
    private String regNo;
    
    @OneToOne(mappedBy = "student")
    private StudentRegistration studentRegistration;

    @Column(name = "name")
    private String name;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

	public Student() {
		super();
	}

	public Student(Integer id, String regNo, StudentRegistration studentRegistration, String name, String dateOfBirth) {
		super();
		this.id = id;
		this.regNo = regNo;
		this.studentRegistration = studentRegistration;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public StudentRegistration getStudentRegistration() {
		return studentRegistration;
	}

	public void setStudentRegistration(StudentRegistration studentRegistration) {
		this.studentRegistration = studentRegistration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
}
