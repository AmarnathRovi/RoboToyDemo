package com.robottoy.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.robottoy.demo.commands.Command;
import com.robottoy.demo.commands.CommandControlerFactory;
import com.robottoy.demo.model.Commands;
import com.robottoy.demo.model.Report;
import com.robottoy.demo.model.Robot;

@Service
public class RobotToySimulationService {
	  private final Logger log = LoggerFactory.getLogger(RobotToySimulationService.class);
	
		public Report start(Commands inputCommands) {

			Robot robot = new Robot();

			Report report = new Report();

			for (String inputCommand : inputCommands.getCommands()) {

				Command command = CommandControlerFactory.getCommand(inputCommand);

				if (command == null) {
					throw new RuntimeException(
					"Entered Wrong command " + inputCommand + " , Please enter right command!!");
				}	
				log.debug("Command Entered " + inputCommand);

				command.execute(robot, report);
			}

			return report;
		}

}
