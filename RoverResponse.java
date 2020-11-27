package com.MarsRover.domain;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
public class RoverResponse {

private ArrayList<String> roversPath;
private String errorDescription;

public ArrayList<String> getRoversPath() {
	return roversPath;
}
public void setRoversPath(ArrayList<String> roversPath) {
	this.roversPath = roversPath;
}
public String getErrorDescription() {
	return errorDescription;
}
public void setErrorDescription(String errorDescription) {
	this.errorDescription = errorDescription;
}
}
