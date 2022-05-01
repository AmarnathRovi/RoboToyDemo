package com.robottoy.demo.commands;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.robottoy.demo.model.Directions;
import com.robottoy.demo.model.Report;
import com.robottoy.demo.model.Robot;

public class PlaceCommand implements Command {
    private final Logger log = LoggerFactory.getLogger(PlaceCommand.class);

    private String command;

    PlaceCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute(Robot robot, Report report) {
        String placementArgs = StringUtils.substringAfter(command, CommandType.PLACE.name());
        String[] args = StringUtils.split(placementArgs, ",");

        Integer initialX = Integer.parseInt(args[0].trim());
        Integer initialY = Integer.parseInt(args[1].trim());

        if (initialX <= Robot.MAX_POSITION && initialX >= Robot.MIN_POSITION
                && initialY <= Robot.MAX_POSITION && initialY >= Robot.MIN_POSITION) {
            robot.setXPosition(initialX);
            robot.setYPosition(initialY);
            robot.setDirections(Directions.valueOf(args[2].trim()));
            log.debug("Robot is placed at " + robot.getCurrentStatus());
        } else {
            log.debug("Place command ignored");
        }
    }
}
