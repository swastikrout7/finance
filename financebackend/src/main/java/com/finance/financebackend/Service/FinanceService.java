package com.finance.financebackend.Service;

import java.util.List;

import com.finance.financebackend.Beans.CardDetails;
import com.finance.financebackend.Beans.ProductHistory;
import com.finance.financebackend.Beans.User;

public interface FinanceService {
	public List<ProductHistory> getProducts(int regid);
	public List<User> getAllDetails();
	public User getDetailsByRegId(long regid);
	public String addDetails(User userDet);
	public CardDetails getCardDetailsByRegId(long regid);

}
