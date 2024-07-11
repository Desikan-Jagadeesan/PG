package com.palani.PoultryAssist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palani.PoultryAssist.Model.BuyerDetails;

@Repository
public interface BuyerRepository extends JpaRepository<BuyerDetails, Long> {

	BuyerDetails findByBuyerName(String username);

}
