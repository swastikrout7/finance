package com.finance.financebackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.financebackend.Beans.CardDetails;
import com.finance.financebackend.Beans.ProductHistory;
import com.finance.financebackend.Beans.User;
import com.finance.financebackend.Repository.CardDetailsRepository;
import com.finance.financebackend.Repository.ProductHistoryRepository;
import com.finance.financebackend.Repository.UserRepository;
@Service
@Transactional
public class FinanceServiceImpl implements FinanceService {
	 @Autowired
	 ProductHistoryRepository finRep;
	    @Autowired
	    UserRepository usRep;
	    @Autowired
	    CardDetailsRepository cRep;
	@Override
	public List<ProductHistory> getProducts(int regid) {
		// TODO Auto-generated method stub
		
		return finRep.findByRegid(regid);
	}

	@Override
	public List<User> getAllDetails() {
		// TODO Auto-generated method stub
		return usRep.findAll();
	}

	@Override
	public User getDetailsByRegId(long regid) {
		// TODO Auto-generated method stub
		return usRep.findById(regid).get();
	}

	@Override
	public String addDetails(User userDet) {
		// TODO Auto-generated method stub
		 usRep.save(userDet);
			return "Added";
	}

	@Override
	public CardDetails getCardDetailsByRegId(long regid) {
		// TODO Auto-generated method stub
		return cRep.findById(regid).get();
	}

}
