package model;

import javax.persistence.*;

@Entity
@Table(name = "CourseDefinition")
public class CourseDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @OneToOne(mappedBy = "courseDefinition")
    private Course course;
    
    @Column(name = "code")
    private String code;
  
    @Column(name = "name")
    private String name;
  
    @Column(name = "description")
    private String description;

	public CourseDefinition() {
		super();
	}

	public CourseDefinition(Integer id, Course course, String code, String name, String description) {
		super();
		this.id = id;
		this.course = course;
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
  
    // Getters and setters
    
}
