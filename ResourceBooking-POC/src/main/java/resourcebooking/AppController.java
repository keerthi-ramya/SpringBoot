package resourcebooking;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private DoctorRepository doctorRepo;
		
	@Autowired
	private PatientRepository patientRepo;
	
	@GetMapping("")
	public String indexPage() {
		return "home";
	}
	
	@GetMapping("/index")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	
	@GetMapping("/login_patient")
	public String showLoginForm(Model model) {
		Patient patient=new Patient();
		model.addAttribute("patient",patient);
		return "login-patient";
	}
	 
	@PostMapping("/patient_login_process")
	public String loginProcesss(@ModelAttribute("patient") Patient patient , Model model) {
		System.out.println(patient.getEmail());
		String email1=patient.getEmail();
		Patient data=patientRepo.findByEmail(email1);
		if(data==null) {
			return "wrong";
		
		}
		else
		{
			
			if(patient.getPassword().equals(data.getPassword()))
			{
				List<Doctor> listDoctor = doctorRepo.findAll();
				model.addAttribute("listDoctors", listDoctor);
				return "booking";
			}
			else
			{
				return "booking";
			}
		}
		
	}
	
	@GetMapping("/login_doctor")
	public String showLoginFormd(Model model) {
		Doctor doctor=new Doctor();
		model.addAttribute("doctor",doctor);
		return "login-doctor";
	}
	 
	@PostMapping("/doctor_login_process")
	public String loginProcesssd(@ModelAttribute("doctor") Doctor doctor) {
		System.out.println(doctor.getEmail());
		String email1=doctor.getEmail();
		Doctor data=doctorRepo.findByEmail(email1);
		if(data==null) {
			return "wrong";
		
		}
		else
		{
			
			if(doctor.getPassword().equals(data.getPassword()))
			{
				return "booking";
			}
			else
			{
				return "booking";
			}
		}
		
	}
	
	
	
	@PostMapping("/user_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	 @PostMapping("/patient_login")
	 public String processLogin(Patient patient) {
		// patientRepo.findByEmail()
		 return"patientpage";
	 }
	
	@GetMapping("/add-doctor")
	public String addDoctor(Model model) {
		model.addAttribute("doctor", new Doctor());
		
		return "add_doctor";
	}
	
	@PostMapping("/adding-Doctor")
	public String addingDoctor(Doctor doctor) {
			
		doctorRepo.save(doctor);
		
		return "doctor_added";
	}
	
//	@PutMapping("edit-doctor")
//    public String updateDoctor(@RequestParam("id") Long id, @PathVariable("id") Long Id,Model model) {
//        Optional<Doctor> doctor = doctorRepo.findById(id);
//            
//        model.addAttribute("doctor", doctor);
//        return "update_doctor";
//    }
	
	
//	@GetMapping("edit-doctor")
//	public ModelAndView updateDoctor(@PathVariable("id") Long id) {
//		ModelAndView editView=new ModelAndView("Update_doctor");
//		Optional<Doctor> doctor = doctorRepo.findById(id);
//		editView.addObject("doctor",doctor);
//		
//		return editView;
//		
//	}

	
	
	
	@GetMapping("edit-doctor/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Doctor> doctor = doctorRepo.findById(id);
            
        model.addAttribute("doctor", doctor);
        return "update_doctor";
    }
	
	@PostMapping("edit-doctor-details/{id}")
	public String updateDoctor(@PathVariable("id") long id, @ModelAttribute("doctor") Doctor doctor, Model model) {
	    
	    	Optional<Doctor> doctorOptional = doctorRepo.findById(id);
	    	if(doctorOptional.isPresent()) {
	    		doctorOptional.get().setFirstname(doctor.getFirstname());
	    		doctorOptional.get().setLastname(doctor.getLastname());
	    		doctorOptional.get().setEmail(doctor.getEmail());
	    		doctorOptional.get().setPassword(doctor.getPassword());
	    		doctorOptional.get().setPhone(doctor.getPhone());
	    		doctorRepo.save(doctorOptional.get());
	    	}
	        return "register_success";
	}
	
	@GetMapping("/add-patient")
	public String addPatient(Model model) {
		model.addAttribute("patient", new Patient());
		
		return "add_patient";
	}
	
	@PostMapping("/adding-patient")
	public String addingPatient(Patient patient) {
	
		patientRepo.save(patient);
		
		return "patient_added";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		List<Doctor> listDoctor = doctorRepo.findAll();
		model.addAttribute("listDoctors", listDoctor);
		
		List<Patient> listPatient = patientRepo.findAll();
		model.addAttribute("listPatients", listPatient);
		
		return "users";
	}
//	@GetMapping("/doctorpage")
//	public String listDoctors(Model model) {
//		
//		return "doctorpage";
//		
//	}
	
	@GetMapping("/patientpage")
	public String listPatients(Model model) {
		
		return "patientpage";
		
	}
	
}
