package com.robottoy.demo.commands;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.robottoy.demo.model.Report;
import com.robottoy.demo.model.Robot;

public class ReportCommand implements Command {
    private final Logger log = LoggerFactory.getLogger(ReportCommand.class);

    @Override
    public void execute(Robot robot, Report report) {
        if (!robot.isOnTable()) {
            log.debug("Missing Robot");
            report.addOutput("ROBOT MISSING");
        } else {
            report.addOutput(robot.getCurrentStatus());
        }
    }
}
