package resourcebooking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", nullable = false, length = 20)
	private String firstname;
	
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastname;
	
	@Column(name = "Specialization", nullable = false, length = 20)
	private String Specialization;
	
	@Column(name = "email", nullable = false, length = 20)
	private String email;
	
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	
	@Column(name = "gender", nullable = false, length = 20)
	private String gender;
	
	@Column(name = "phone", nullable = false, length = 12)
	private Long phone;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String Specialization) {
		this.Specialization = Specialization;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	
	

}
