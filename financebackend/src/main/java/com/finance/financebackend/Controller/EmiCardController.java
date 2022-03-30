package com.finance.financebackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.financebackend.Beans.EmiCard;
import com.finance.financebackend.Service.EmiCardService;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emicard")
public class EmiCardController {
	@Autowired
	EmiCardService emicardservice;
	
	//http://localhost:8282/emicard/getAllEmiCard
	@GetMapping("/getAllEmiCard")
	public List<EmiCard> getAllEmiCard(){
		return emicardservice.getAllEmiCard();
	}
	
	//http://localhost:8282/emicard/addEmiCard
	@PostMapping("/addEmiCard")
	public boolean addEmiCard( @RequestBody  EmiCard emiCard) {
		return emicardservice.addEmiCard(emiCard);
	}

}
