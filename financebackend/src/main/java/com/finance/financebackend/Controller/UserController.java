package com.finance.financebackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.financebackend.Beans.NamePass;
import com.finance.financebackend.Beans.User;
import com.finance.financebackend.Service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	//http://localhost:8585/user/findUserByUname
	@GetMapping("/findUserByUname/{uname}")
	public User finUserByUname(@PathVariable(value="uname") String uname) {
		return userService.findUserByUname(uname);
	}
	
	//http://localhost:8585/user/getAllUsers
	@GetMapping("/getAllUsers")
	public List<User> findAllUser() {
		return userService.getAllUsers();
	}

	//http://localhost:8585/user/addUser
	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	//http://localhost:8585/user/userexists
	@GetMapping("/userexists/{uname}")
	public boolean findUserExists(@PathVariable(value="uname") String uname) {
		User u=null;
		u=userService.findUserByUname(uname);
		if(u!=null) {
			return true;
		}
		return false;
	}
	
	//http://localhost:8585/user/uservalidate
	@GetMapping("/uservalidate/{uname}/{upass}")
	public int validateUser(@PathVariable(value="uname") String uname,@PathVariable(value="upass") String upass) {
		User u;
		u=userService.findUserByUname(uname);
		if(u==null) {
//			username does not exist
			return 0;
		}
		else if(u.getUpass().equals(upass)) {
//			correct password
			return 1;
		}
//		wrong credentials
		return 0;
	}
	
	//http://localhost:8585/user/changepass
	@PutMapping("/changepass")
	public boolean changePass(@RequestBody NamePass namepass) {
		User u;
		System.out.println(namepass.getName());
		System.out.println(namepass.getPassword());
		u=userService.findUserByUname(namepass.getName());
		u.setUpass(namepass.getPassword());
		userService.addUser(u);
		return true;
	}
	
	//http://localhost:8585/user/getId
	@GetMapping("/getId/{uname}")
	public long findIdByUname(@PathVariable(value="uname") String uname) {
		User u=null;
		u=userService.findUserByUname(uname);
		return u.getRegid();
		
	
	}
}
