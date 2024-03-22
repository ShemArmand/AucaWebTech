package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
  
    @Column(name = "name")
    private String name;
  
    @Column(name = "startDate")
    private LocalDate startDate;
  
    @Column(name = "endDate")
    private LocalDate endDate;
    
    @OneToMany(mappedBy = "academicUnit")
    private List<Course> courses;

	public Semester() {
		super();
	}

	public Semester(Integer id, String name, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
  
    // Getters and setters
    
}
