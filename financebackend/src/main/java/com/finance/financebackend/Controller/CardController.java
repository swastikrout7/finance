package com.finance.financebackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.financebackend.Beans.CardDetails;
import com.finance.financebackend.Service.CardDetailsService;

@RestController
@CrossOrigin(origins = "*" )
@RequestMapping("/cardapi")
public class CardController {
	
	@Autowired
	CardDetailsService cardService;
	
	//http://localhost:8282/cardapi/updatebal
	@PutMapping("/updatebal/{regid}/{price}")
	public boolean updateBalance(@PathVariable(value="regid")int regid,@PathVariable(value ="price")int price) {
		
		return cardService.updateBalance(regid, price);
	}
	
	//http://localhost:8282/cardapi/getAll
	@GetMapping("/getAll")
	public List<CardDetails> getAll(){
		return cardService.getProducts();
	}

}
