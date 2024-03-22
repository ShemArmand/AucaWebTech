package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class RegistrarUser {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registrarId")
    
    private Integer registrarId;

    @Column(name = "registrarNames")
    private String registrarNames;

    @Column(name = "registrarPhone")
    private String registrarPhone;

    @Column(name = "registrarUserName")
    private String registrarUserName;

    @Column(name = "registrarPassword")
    private String registrarPassword;

	public RegistrarUser() {
		super();
	}

	public RegistrarUser(Integer registrarId, String registrarNames, String registrarPhone, String registrarUserName,
			String registrarPassword) {
		super();
		this.registrarId = registrarId;
		this.registrarNames = registrarNames;
		this.registrarPhone = registrarPhone;
		this.registrarUserName = registrarUserName;
		this.registrarPassword = registrarPassword;
	}

	public Integer getRegistrarId() {
		return registrarId;
	}

	public void setRegistrarId(Integer registrarId) {
		this.registrarId = registrarId;
	}

	public String getRegistrarNames() {
		return registrarNames;
	}

	public void setRegistrarNames(String registrarNames) {
		this.registrarNames = registrarNames;
	}

	public String getRegistrarPhone() {
		return registrarPhone;
	}

	public void setRegistrarPhone(String registrarPhone) {
		this.registrarPhone = registrarPhone;
	}

	public String getRegistrarUserName() {
		return registrarUserName;
	}

	public void setRegistrarUserName(String registrarUserName) {
		this.registrarUserName = registrarUserName;
	}

	public String getRegistrarPassword() {
		return registrarPassword;
	}

	public void setRegistrarPassword(String registrarPassword) {
		this.registrarPassword = registrarPassword;
	}

    // Constructors, getters, and setters can be added as needed.
}
