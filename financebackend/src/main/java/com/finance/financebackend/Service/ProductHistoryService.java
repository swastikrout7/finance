package com.finance.financebackend.Service;

import java.util.List;

import com.finance.financebackend.Beans.Product;
import com.finance.financebackend.Beans.ProductHistory;

public interface ProductHistoryService {
	
	public boolean addProduct(ProductHistory prodhist);
	public List<ProductHistory> viewProduct();
	

}
