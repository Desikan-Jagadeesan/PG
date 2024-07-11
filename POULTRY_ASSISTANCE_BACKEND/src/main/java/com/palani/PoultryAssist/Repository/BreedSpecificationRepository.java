package com.palani.PoultryAssist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palani.PoultryAssist.Model.BreedSpecification;

@Repository
public interface BreedSpecificationRepository extends JpaRepository<BreedSpecification, Long>{

}
