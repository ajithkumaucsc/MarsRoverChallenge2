package com.MarsRover.service;

import com.MarsRover.domain.CommandRequest;
import com.MarsRover.domain.RoverResponse;

public interface MarsRoverService {

	RoverResponse findRovers(CommandRequest commandRequest) throws Exception;

}
