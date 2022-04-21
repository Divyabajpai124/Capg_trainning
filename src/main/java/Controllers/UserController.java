package Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Developer;
import com.example.demo.DeveloperRepository;
import com.example.demo.DeveloperService;
import com.example.demo.Login;
import com.example.demo.LoginService;
import com.example.demo.Project2;
import com.example.demo.ProjectService;
import com.example.demo.loginRepo;

@RestController
@RequestMapping("/UserLogin")
public class UserController {
	
    @Autowired
    DeveloperService service;
    @Autowired
    LoginService services;
    @Autowired
    ProjectService ser;
    @Autowired
    loginRepo r;
    @Autowired
    DeveloperRepository repo;
     @RequestMapping("/login")
    public String tests() {
    	return "test login controller";
    }
    
    @RequestMapping("/getlogin/{username},{userpassword}")
    public ResponseEntity<Login> findOne(@PathVariable(value="username")String username,@PathVariable(value="userpassword")String userpassword) {
    	try {
    		List<Login> log=services.findByusername(username);
    	if(log !=null) {
    		Login logpass=services.findByuserpassword(userpassword);
    		if (logpass !=null) {
    			
    			System.out.println("valid");
    			return new ResponseEntity<Login>(logpass,HttpStatus.FOUND);
    		}
    		
    	}
    	
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}
    	}catch(Exception ex) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
		return null;}
    
    @RequestMapping("/getdeveloper/{id}")
    public ResponseEntity<Developer> findOne(@PathVariable(value="id")Integer id) {
    	try {
    		Developer d=service.findById(id);
    	if(d !=null) {
    		return new ResponseEntity<>(d,HttpStatus.OK);
    		
    	}
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}
    	
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }}
    
@PutMapping("/updatepassword")
public ResponseEntity<Login> updatepass(@RequestBody Login l){
	try{
		services.update(l,l.getUsername());
		
	
	return new ResponseEntity<Login>(l,HttpStatus.OK);
}catch (Exception ex) {
	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
}}
@GetMapping(value="/getProject/{id}")
public ResponseEntity<Project2> findone(@PathVariable(value="id") Integer proid){
	Project2 prod=ser.fetchProjectById( proid);
if(prod!=null) {
	return new ResponseEntity<>(prod,HttpStatus.OK);
}
else {
	return new ResponseEntity<>(prod,HttpStatus.NOT_FOUND);
}
}
/*@PutMapping("/addDetails")
public ResponseEntity<Login> add(@RequestBody Login l){
	try {
		
		List<Login> l2=r.findAll();
		
		for(Login ln:l2) {
			if(ln.getUserpassword()==l.getUserpassword()) {
			Developer d=service.findById();
				service.saveDev(d);
			}
		}
		services.addinUser(l);
		return new ResponseEntity<Login>(l,HttpStatus.OK);
		
	}catch (Exception ex) {
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
}
}*/
}