package resourcebooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	@Query("SELECT u FROM Doctor u WHERE u.email = ?1")
	public Doctor findByEmail(String email);
	

}
