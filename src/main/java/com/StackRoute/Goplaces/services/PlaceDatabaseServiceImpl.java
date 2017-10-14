package com.StackRoute.Goplaces.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.StackRoute.Goplaces.domain.Places;
import com.StackRoute.Goplaces.repositories.PlacesRepository;

@Service
public class PlaceDatabaseServiceImpl implements PlacesService  {
	
	@Autowired
	PlacesRepository placesRepository;

	public void setPlacesRepository(PlacesRepository placesRepository) {
		this.placesRepository = placesRepository;
	}
	
	@Override
	public List<Places> getAll() {
		List<Places> places=new ArrayList<>();
		places=(List<Places>) placesRepository.findAll();
		return places;
	}

	

	@Override
	public Places save(Places place) {
		Places placesaved=placesRepository.save(place);
		return placesaved;
	}

	@Override
	public String update(Places place) {
		placesRepository.save(place);
		return "data Updated successfully";
	}

	@Override
	public String delete(Places place) {
		placesRepository.delete(place);
		return "Deleted succesfully";
	}

	@Override
	public Places findById(int id) {
		Places pl=placesRepository.findOne(id);
		return pl;

}
}
