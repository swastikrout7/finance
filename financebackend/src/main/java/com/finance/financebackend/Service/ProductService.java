package com.finance.financebackend.Service;

import java.util.List;

import com.finance.financebackend.Beans.Product;
import com.finance.financebackend.Beans.ProductHistory;



public interface ProductService {
	public List<Product> viewProduct();
	public Product findProduct(int prodid);
	public String addProducts(Product product);
	public List<Product> viewProductByName(String prodname);

}
