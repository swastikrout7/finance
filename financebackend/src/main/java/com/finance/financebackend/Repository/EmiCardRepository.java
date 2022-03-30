package com.finance.financebackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.financebackend.Beans.EmiCard;

@Repository
public interface EmiCardRepository extends JpaRepository<EmiCard, String>{

}