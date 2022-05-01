package com.robottoy.demo.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.robottoy.demo.model.Directions;
import com.robottoy.demo.model.Report;
import com.robottoy.demo.model.Robot;

public class LeftCommand implements Command {

	  private final Logger log = LoggerFactory.getLogger(LeftCommand.class);

    public void execute(Robot robot, Report report) {

        if (!robot.isOnTable()) {

        	log.debug("Left command ignored");
        } else {
            switch (robot.getDirections()) {
                case NORTH:
                    robot.setDirections(Directions.EAST);
                    break;
                case SOUTH:
                    robot.setDirections(Directions.WEST);
                    break;
                case EAST:
                    robot.setDirections(Directions.SOUTH);
                    break;
                case WEST:
                    robot.setDirections(Directions.NORTH);
                    break;
            }
            log.debug("The robot is rotating 90 degree to " + robot.getDirections());
        }

    }
}
