package com.MarsRover.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.MarsRover.domain.CommandRequest;
import com.MarsRover.domain.RoverResponse;
import com.MarsRover.domain.RoverRobot;

@Service
public class MarsRoverServiceImpl implements MarsRoverService {
	RoverResponse roverResponse;

	@Override
	public RoverResponse findRovers(CommandRequest commandRequest) throws Exception {
		roverResponse=new RoverResponse();
		ArrayList<String> roverResult = new ArrayList<>();
		if (commandValidationPlateau(commandRequest.getX(), commandRequest.getY())) {

			if (!commandRequest.getRoverList().isEmpty()) {
				RoverRobot roverRobot;
				for (int i = 0; i < commandRequest.getRoverList().size(); i++) {
					if (commandValidationRover(commandRequest.getRoverList().get(i))) {

						roverRobot = followInstructions(commandRequest.getRoverList().get(i), commandRequest.getX(),
								commandRequest.getY());
						roverResult.add(String.valueOf(roverRobot.getRoverX()) + " "
								+ String.valueOf(roverRobot.getRoverY() + " " + roverRobot.getDirection()));

					}
					else{
						break;
					}

				}if(roverResult.size()==2){
					roverResponse.setRoversPath(roverResult);
					roverResponse.setErrorDescription("success");
				}
			} else {
				roverResponse.setErrorDescription("RoverCommands are empty.");
			}

		} else {
			roverResponse.setErrorDescription("Plateau Commands are wrong.");
		}
		return roverResponse;
	}

	/**
	 * Rover command validation method
	 * 
	 */
	public boolean commandValidationRover(RoverRobot roverRobot)throws Exception {
		if (roverRobot.getRoverX() < 0 || roverRobot.getRoverY() < 0) {
			roverResponse.setErrorDescription("RoverCommands can not be Negative.");
			return false;
		} else if (roverRobot.getDirection() != 'N' && roverRobot.getDirection() != 'E'
				&& roverRobot.getDirection() != 'S' && roverRobot.getDirection() != 'W') {
			roverResponse.setErrorDescription("Rover Direction must be 'N', 'E', 'S' or 'W' ");
			return false;
		}
		return true;
	}

	/**
	 * Plateau command validation method
	 * 
	 */
	public boolean commandValidationPlateau(int x, int y) {
		if (x < 0 || y < 0) {
			return false;
		}
		return true;
	}

	/**
	 * Follow given instructions
	 * 
	 */
	private RoverRobot followInstructions(RoverRobot roverRobot, int x, int y) throws Exception {
		for (int i = 0; i < roverRobot.getRoverCommand().length(); i++) {
			if (roverRobot.getRoverCommand().charAt(i) == 'M') {
				if (canGo(roverRobot, x, y)) {
					roverRobot = move(roverRobot);
				}
			} else {
				roverRobot = rotate(roverRobot, roverRobot.getRoverCommand().charAt(i));
			}
		}
		return roverRobot;
	}

	/**
	 * Check moving option
	 * 
	 */
	public boolean canGo(RoverRobot roverRobot, int pX, int pY) {
		if (roverRobot.getDirection() == 'N' && roverRobot.getRoverY() + 1 > pY)
			return false;
		else if (roverRobot.getDirection() == 'E' && roverRobot.getRoverX() + 1 > pX)
			return false;
		else if (roverRobot.getDirection() == 'S' && roverRobot.getRoverY() - 1 < 0)
			return false;
		else if (roverRobot.getDirection() == 'W' && roverRobot.getRoverX() + 1 < 0)
			return false;
		return true;
	}

	/**
	 * update moving path
	 * 
	 */
	public RoverRobot move(RoverRobot roverRobot) {
		switch (roverRobot.getDirection()) {
		case 'N':
			roverRobot.setRoverY(roverRobot.getRoverY() + 1);
			break;
		case 'E':
			roverRobot.setRoverX(roverRobot.getRoverX() + 1);
			break;
		case 'S':
			roverRobot.setRoverY(roverRobot.getRoverY() - 1);
			break;
		case 'W':
			roverRobot.setRoverX(roverRobot.getRoverX() - 1);
			break;
		}
		return roverRobot;
	}

	/**
	 * Check rotate option
	 * 
	 */
	public RoverRobot rotate(RoverRobot roverRobot, char rotation) throws Exception {
		if (rotation == 'L') {
			roverRobot.setDirection(goToLeft(roverRobot.getDirection()));
		} else if (rotation == 'R') {
			roverRobot.setDirection(goToRight(roverRobot.getDirection()));
		} else {
			roverResponse.setErrorDescription("Rotation must be 'R' or 'L'.");
		}
		return roverRobot;
	}

	/**
	 * Move rover to left
	 * 
	 */
	public static char goToLeft(char direction) {
		if (direction == 'N')
			return 'W';
		if (direction == 'W')
			return 'S';
		if (direction == 'S')
			return 'E';
		return 'N';
	}

	/**
	 * Move rover to right
	 * 
	 */
	public static char goToRight(char direction) {
		if (direction == 'N')
			return 'E';
		if (direction == 'E')
			return 'S';
		if (direction == 'S')
			return 'W';
		return 'N';
	}
}
