package com.StackRoute.Goplaces.services;

import java.util.Arrays;
import java.util.List;

import com.StackRoute.Goplaces.domain.Places;

public interface PlacesService {
	public List<Places> getAll();
    public Places save(Places place);
    public String update(Places place);
	public String delete(Places place);
	public Places findById(int id);
}
