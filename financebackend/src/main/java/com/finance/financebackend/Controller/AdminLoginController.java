package com.finance.financebackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.financebackend.Beans.AdminLogin;
import com.finance.financebackend.Service.AdminLoginService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminLoginController {
	
    @Autowired
    AdminLoginService adminloginservice;
    
    
    //http://localhost:8282/admin/validate
    @GetMapping("/validate/{aname}/{apass}")
	public int validateAdmin(@PathVariable(value="aname") String aname,@PathVariable(value="apass") String apass) {
    	AdminLogin a;
    	a=adminloginservice.findAdmin(aname) ;
		if(a==null) {
//			username does not exist
			return 0;
		}
		else if(a.getApass().equals(apass)) {
//			correct password
			return 1;
		}
//		wrong credentials
		else
		return 0;
	}
}
