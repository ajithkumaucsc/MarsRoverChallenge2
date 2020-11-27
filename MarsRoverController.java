package com.MarsRover.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarsRover.domain.CommandRequest;
import com.MarsRover.domain.RoverResponse;
import com.MarsRover.domain.RoverRobot;
import com.MarsRover.service.MarsRoverService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MarsRoverController {
	@Autowired
	private MarsRoverService marsRoverService;

	@RequestMapping(value = "/getRoverCordination", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value="Get Rover Direction",
	notes="The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation."
	,response=RoverResponse.class)
	public ResponseEntity<RoverResponse> getRoverCordination(@RequestBody CommandRequest commandRequest)
			throws Exception {
		RoverResponse response = marsRoverService.findRovers(commandRequest);
		return ResponseEntity.ok(response);
	}

}
