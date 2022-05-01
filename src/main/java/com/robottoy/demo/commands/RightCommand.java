package com.robottoy.demo.commands;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.robottoy.demo.model.Directions;
import com.robottoy.demo.model.Report;
import com.robottoy.demo.model.Robot;

public class RightCommand implements Command {
    private final Logger log = LoggerFactory.getLogger(RightCommand.class);

    @Override
    public void execute(Robot robot, Report report) {
        if (!robot.isOnTable()) {
            log.debug("Right command ignored");
        } else {
            switch (robot.getDirections()) {
                case NORTH:
                    robot.setDirections(Directions.WEST);
                    break;
                case SOUTH:
                    robot.setDirections(Directions.EAST);
                    break;
                case EAST:
                    robot.setDirections(Directions.NORTH);
                    break;
                case WEST:
                    robot.setDirections(Directions.SOUTH);
                    break;
            }
            log.debug("The robot is rotating 90 degree to " + robot.getDirections());

        }
    }
}
