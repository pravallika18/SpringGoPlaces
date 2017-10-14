package com.StackRoute.Goplaces.Exception;

import org.springframework.stereotype.Component;


public class PlaceNotFoundException extends Exception {
public PlaceNotFoundException(String message) {
	super(message);
}
}
