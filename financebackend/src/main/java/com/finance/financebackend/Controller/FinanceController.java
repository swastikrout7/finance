package com.finance.financebackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.financebackend.Beans.CardDetails;
import com.finance.financebackend.Beans.ProductHistory;
import com.finance.financebackend.Beans.User;
import com.finance.financebackend.Repository.CardDetailsRepository;
import com.finance.financebackend.Repository.UserRepository;
import com.finance.financebackend.Service.FinanceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/finance")
public class FinanceController {
	
	 @Autowired
	 FinanceService finSer;
	 @Autowired
	 UserRepository usRep;
	 @Autowired
	 CardDetailsRepository cdRep;
	 
	//http://localhost:8585/finance/financeHistory
	  //Details of user transaction history
     @GetMapping("/financeHistory/{regid}")
     public List<ProductHistory> getProducts(@PathVariable(value="regid")int regid){
   	  return finSer.getProducts(regid);
     }
     
   //http://localhost:8585/finance/details
     //Details of User from user table.
     @GetMapping("/details/{regid}")
     public User getDetails(@PathVariable(value="regid")long regid) {
   	 return finSer.getDetailsByRegId(regid);
     }
     
     //just for testing
     //http://localhost:8585/finance/alldetails
     @GetMapping("/alldetails")
     public List<User> getAllDetails() {
   	  return finSer.getAllDetails();
     }
     
     
     //http://localhost:8585/finance/addetails
     //Just for testing
     @PostMapping("/addetails")
     public String addDetails(@RequestBody User userDet) {
   	 return finSer.addDetails(userDet);
     }
     
   //http://localhost:8585/finance/carddetails
     @GetMapping("/carddetails/{regid}")
     public CardDetails getCardDet(@PathVariable(value="regid")long regid){
   	  return finSer.getCardDetailsByRegId(regid);
     }
     

}
