package com.finance.financebackend.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finance.financebackend.Beans.ProductHistory;
import com.finance.financebackend.Service.ProductHistoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/producthistory")

public class ProductHistoryController {
	@Autowired
	ProductHistoryService prodhistService;

	//http://localhost:8282/producthistory/addProduct
	@PostMapping("/addProduct")
	public boolean addProduct(@RequestBody ProductHistory prodhist) {
		return prodhistService.addProduct(prodhist);
	}
	
	//http://localhost:8282/producthistory/viewProduct
	@GetMapping("/viewProduct")
	public List<ProductHistory> getAll() {
		return prodhistService.viewProduct();
	}
}
