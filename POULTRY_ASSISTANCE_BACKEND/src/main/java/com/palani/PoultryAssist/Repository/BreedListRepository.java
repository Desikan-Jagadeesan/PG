package com.palani.PoultryAssist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palani.PoultryAssist.Model.PoultryBreeds;

@Repository
public interface BreedListRepository extends JpaRepository<PoultryBreeds, Long> {
	PoultryBreeds findByBreedNameIgnoreCase(String breedName);

}
