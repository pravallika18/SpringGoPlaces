package com.StackRoute.Goplaces.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.StackRoute.Goplaces.Exception.PlaceAlredyExist;
import com.StackRoute.Goplaces.Exception.PlaceNameIsRequiredException;
import com.StackRoute.Goplaces.Exception.PlaceNotFoundException;
import com.StackRoute.Goplaces.domain.Places;

import com.StackRoute.Goplaces.services.PlacesService;

@RestController
@RequestMapping("/v0.1/PlaceSearch/places")
public class PlaceController {
	
  @Autowired
  PlacesService placesService;
  
  @RequestMapping(method=RequestMethod.GET)
   public ResponseEntity<List<Places>> getAllPlaces()
	{
	  	List<Places> places=placesService.getAll();
		return ResponseEntity.ok(places);
	}
  
  
/*  @RequestMapping(method=RequestMethod.POST,produces = "text/plain")
  public ResponseEntity<String> addPlace(@RequestBody Places place) throws  PlaceAlredyExist 
  {
//	  place.setName("AAA");
	  String status="";
	  if(place.getName().isEmpty())
	  {
		  try {
		  status="Place Name is Required";
		  throw new PlaceNameIsRequiredException(status);
		  }
		  catch(PlaceNameIsRequiredException ex)
		  {
			  return ResponseEntity.ok(status);
		  }
		 
	  }
	  else {
		  
		  status=placesService.save(place);
		  if(status.equals("Place Already Exist"))
		  {
			  status="Place Already Exist";
			  throw new PlaceAlredyExist("Place Already Exist");
		  }
		  return ResponseEntity.ok(status);
	  }  
  	} */
  @RequestMapping(method=RequestMethod.POST)
  public ResponseEntity<Places> addPlace(@RequestBody Places place) throws  PlaceAlredyExist 
  {
       Places place1=placesService.save(place);
        return ResponseEntity.ok(place1);
	 
  	}
  
  @RequestMapping(method=RequestMethod.PUT)
  public ResponseEntity<String> updateExist(@RequestBody Places places)  {
   try {
//	    places.setId(5);
	    if(placesService.update(places).equals("data Updated successfully")){
	    return ResponseEntity.ok("updated successfully");
	    		}
	    else {
	    	throw new PlaceNotFoundException("Place not Found to update");
	    }
   } catch (PlaceNotFoundException e) {
    return ResponseEntity.ok("Place not Found to update");
   }
 }
  
  
  @RequestMapping(method=RequestMethod.DELETE)
  public ResponseEntity<String> deleteById(@RequestBody Places places)  {
   try {
//	    places.setId(5);
	    if(placesService.delete(places).equals("Deleted succesfully")){
	    return ResponseEntity.ok("data deleted successfully");
	    		}
	    else {
	    	throw new PlaceNotFoundException("Place not Found to delete");
	    }
   } catch (PlaceNotFoundException e) {
    return ResponseEntity.ok("Place not Found to delete");
   }
  }

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	/** @PathVariable,(/id?id=1)
	getById(@Requestparam int id) (/1) **/
	
	public ResponseEntity<Places> getById(@PathVariable int id)  {
		Places place=placesService.findById(id);
		
		return ResponseEntity.ok(place);
	
	}
}
