package com.palani.PoultryAssist.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palani.PoultryAssist.Model.HatchingDetails;

@Repository
public interface HatchingDetailsRepository extends JpaRepository<HatchingDetails, Long> {
	List<HatchingDetails> findByLoaderEndDate(Date loaderEndDate );
	List<HatchingDetails> findByHatchingDate(Date hatchingDate );
	

}
