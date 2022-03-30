package com.finance.financebackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.financebackend.Beans.CardDetails;
import com.finance.financebackend.Beans.User;
import com.finance.financebackend.Service.AuthenticateUserService;
import com.finance.financebackend.Service.CardDetailsService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/UserDetails")
public class UserAdminController {
	
	@Autowired
	AuthenticateUserService adService;
	@Autowired
	CardDetailsService cdService;
	
	//http://localhost:8282/UserDetails/getUserdetails
	@GetMapping("/getUserdetails")
	public List<User> getAll(){
		return adService.getUserdetails();
	}
	
	//http://localhost:8282/UserDetails/findUser
	@GetMapping("/findUser/{regid}")
	public User getUserById(@PathVariable(value = "regid") long regid) {
		return adService.findUser(regid);
	}
	
	//http://localhost:8282/UserDetails/addUser
	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User user) {
	return adService.addUser(user);
	}
	
	//http://localhost:8282/UserDetails/updateUser
	@PutMapping("/updateUser/{regid}")
	public boolean updateuserById(@PathVariable(value="regid") long regid) {
		return adService.updateUser(regid);
	}
	
	//http://localhost:8282/UserDetails/deleteUser
	@DeleteMapping("/deleteUser/{regid}")
	public boolean deleteUser(@PathVariable(value="regid") long regid) {
		return adService.deleteUser(regid);
		//return prodService.deleteProduct(product);
	}
	
	//http://localhost:8282/UserDetails/DeleteUser
	@DeleteMapping("/DeleteUser")
	public boolean deleteUser(@RequestBody User user, long regid) {
		return adService.deleteUser(regid);
	}
	
	//http://localhost:8282/UserDetails/getCarddetails
	@GetMapping("/getCarddetails")
	public List<CardDetails> getAllCards(){
		return cdService.getCarddetails();
	}
	
	//http://localhost:8282/UserDetails/findCard
	@GetMapping("/findCard/{regid}")
	public CardDetails getCardById(@PathVariable(value = "regid") long regid) {
		return cdService.findCard(regid);
	}
	
	//http://localhost:8282/UserDetails/addCard
	@PostMapping("/addCard")
	public boolean addCard(@RequestBody CardDetails card) {
		
	return cdService.addCard(card);
	}
	
	//http://localhost:8282/UserDetails/updateCard
	@PutMapping("/updateCard/{regid}")
	public boolean updatecardById(@PathVariable(value="regid")long regid) {
		return cdService.updateCard(regid);
	}
	
	//http://localhost:8282/UserDetails/deleteCard
	@DeleteMapping("/deleteCard/{regid}")
	public boolean deleteCard(@PathVariable(value="regid") long regid) {
	return cdService.deleteCard(regid);
	//return prodService.deleteProduct(product);
	}
	

}
