package com.MarsRover.domain;

import java.util.ArrayList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="Details about the Rover Request  ")
public class CommandRequest {

	@ApiModelProperty(notes="upper-right coordinates of the plateau.")
    private int x;
	@ApiModelProperty(notes="upper-right coordinates of the plateau.")
    private int y;
	@ApiModelProperty(notes="Rovers Information.")
    private ArrayList<RoverRobot> roverList;

    public CommandRequest(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CommandRequest() {
        this.x = x;
        this.y = y;
    }
	public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

	public ArrayList<RoverRobot> getRoverList() {
		return roverList;
	}

	public void setRoverList(ArrayList<RoverRobot> roverList) {
		this.roverList = roverList;
	}
    
}
