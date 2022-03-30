package com.finance.financebackend.Service;

import java.util.List;

import com.finance.financebackend.Beans.EmiCard;

public interface EmiCardService {
	public List<EmiCard> getAllEmiCard();
	public boolean addEmiCard(EmiCard emiCard);

}
