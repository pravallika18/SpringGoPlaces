package com.StackRoute.Goplaces.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.StackRoute.Goplaces.domain.Places;

@Repository
public interface PlacesRepository  extends CrudRepository<Places,Integer>{
	
	
}
