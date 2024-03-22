package model;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "AcademicUnit")
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
  
    @Column(name = "code")
    private String code;
  
    @Column(name = "name")
    private String name;
  
    @ManyToOne
    @JoinColumn(name = "parentUnitId")
    private AcademicUnit parentUnit;
    
    @OneToMany(mappedBy = "parentUnit")
    private List<AcademicUnit> childUnits;
    
      
    @Enumerated(EnumType.STRING)
    @Column(name = "academicType", columnDefinition = "ENUM('PROGRAMME','FACULTY','DEPARTMENT')")
    private AcademicEnum academicType;
    
//    @OneToMany(mappedBy = "academicUnit")
//    private List<Course> courses;
    
    @OneToMany(mappedBy = "academicUnit")
    private List<StudentRegistration> studentRegistrations;
    
  
    // Getters and setters
   public enum AcademicEnum {
        PROGRAMME, FACULTY, DEPARTMENT
    }


	public AcademicUnit() {
		super();
	}


	public AcademicUnit(Integer id, String code, String name, AcademicUnit parentUnit, List<AcademicUnit> childUnits,
			AcademicEnum academicType, List<StudentRegistration> studentRegistrations) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.parentUnit = parentUnit;
		this.childUnits = childUnits;
		this.academicType = academicType;
		this.studentRegistrations = studentRegistrations;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public AcademicUnit getParentUnit() {
		return parentUnit;
	}


	public void setParentUnit(AcademicUnit parentUnit) {
		this.parentUnit = parentUnit;
	}


	public List<AcademicUnit> getChildUnits() {
		return childUnits;
	}


	public void setChildUnits(List<AcademicUnit> childUnits) {
		this.childUnits = childUnits;
	}


	public AcademicEnum getAcademicType() {
		return academicType;
	}


	public void setAcademicType(AcademicEnum academicType) {
		this.academicType = academicType;
	}


	public List<StudentRegistration> getStudentRegistrations() {
		return studentRegistrations;
	}


	public void setStudentRegistrations(List<StudentRegistration> studentRegistrations) {
		this.studentRegistrations = studentRegistrations;
	}

	
	
}
