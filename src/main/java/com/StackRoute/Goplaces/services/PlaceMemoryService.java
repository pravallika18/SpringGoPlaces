package com.StackRoute.Goplaces.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.StackRoute.Goplaces.domain.Places;

public class PlaceMemoryService{
	
	public List<Places> getAll()
	{
		return Arrays.asList(new Places(1,"kritunga","koramangala","jjhahjjdhh.png"),
				new Places(2,"truffels","koramangala","jjhsshjjdhh.png"),
				new Places(3,"Ruchi's","koramangala","jjhahjjdhh.png"));
	}
	public String save(Places place) {
		
		return "Places created successfully";
	}
	public String update(Places place)
	{
		
		return "data Updated successfully";
		
	}
	
	public String delete(Places place) {
		
		return "successfully deleted";
	}
	

}
