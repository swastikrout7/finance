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
import com.finance.financebackend.Beans.Product;
import com.finance.financebackend.Service.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/order")
public class ProductController {
	@Autowired
	ProductService prodService;

	//http://localhost:8585/order/getAll
	@GetMapping("/getAll")
	public List<Product> getAll() {
		return prodService.viewProduct();
	}

	//http://localhost:8585/order/getProductById
	@GetMapping("/getProductById/{prodid}") // Find by ID
	public Product getProductById(@PathVariable(value = "prodid") int prodid) {
		return prodService.findProduct(prodid);
	}

	//http://localhost:8585/order/addProducts
	@PostMapping("/addProducts")
	public String addProducts(@RequestBody Product product) {
		return prodService.addProducts(product);
	}

	//http://localhost:8585/order/getProductsByName
	@GetMapping("/getProductsByName/{prodname}") // Find by Name
	public List<Product> getProductsByName(@PathVariable(value = "prodname") String prodname) {
		return prodService.viewProductByName(prodname);
	}
}
