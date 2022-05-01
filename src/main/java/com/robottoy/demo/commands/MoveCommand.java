package com.robottoy.demo.commands;

 
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.robottoy.demo.model.Directions;
import com.robottoy.demo.model.Report;
import com.robottoy.demo.model.Robot;

public class MoveCommand implements Command {
    private final Logger log = LoggerFactory.getLogger(MoveCommand.class);

    @Override
    public void execute(Robot robot, Report report) {
        if (!robot.isOnTable()) {
            log.debug("Move command ignored");
        } else {
            switch (robot.getDirections()) {
                case NORTH:
                    if (robot.getYPosition() < Robot.MAX_POSITION) {
                    	
                    	log.debug("The robot is moving "+ robot.getYPosition());
                    	
                    	log.debug("The robot is moving "+ robot.getXPosition());
                        robot.increaseYPosition();
                        
                        log.debug("The robot is moving incr "+ robot.getYPosition());
                        log.debug("The robot is moving "+ Directions.NORTH);

                    } else {
                        log.debug("Move command ignored");
                    }
                    break;

                case SOUTH:
                    if (robot.getYPosition() > Robot.MIN_POSITION) {
                        robot.decreaseYPosition();
                        log.debug("The robot is moving "+Directions.SOUTH);
                    } else {
                        log.debug("Move command ignored");
                    }
                    break;

                case EAST:
                    if (robot.getXPosition() < Robot.MAX_POSITION) {
                        robot.increaseXPosition();
                        log.debug("The robot is moving "+Directions.EAST);
                    } else {
                        log.debug("Move command ignored");
                    }
                    break;

                case WEST:
                    if (robot.getXPosition() > Robot.MIN_POSITION) {
                        robot.decreaseXPosition();
                        log.debug("The robot is moving "+Directions.WEST);
                    } else {
                        log.debug("Move command ignored");
                    }
                    break;
            }

        }
    }
}
