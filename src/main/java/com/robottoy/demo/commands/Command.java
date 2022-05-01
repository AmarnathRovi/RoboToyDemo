package com.robottoy.demo.commands;

import com.robottoy.demo.model.Report;
import com.robottoy.demo.model.Robot;

public interface Command {

    public void execute(Robot robot, Report report);
}
