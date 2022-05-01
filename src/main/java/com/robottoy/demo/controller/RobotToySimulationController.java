package com.robottoy.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robottoy.demo.model.Commands;
import com.robottoy.demo.model.Report;
import com.robottoy.demo.service.RobotToySimulationService;

@RestController
public class RobotToySimulationController {
	  private final Logger log = LoggerFactory.getLogger(RobotToySimulationController.class);
		
	@Autowired
	private RobotToySimulationService roboToySimulService;

	@PostMapping("/robotoy/v1/play")
	public ResponseEntity<Report> playGame(@RequestBody Commands commands) {
		log.debug("RobotToySimulationController::play  Start");
		Report report = roboToySimulService.start(commands);
		log.debug("RobotToySimulationController::play  End");
		log.debug("\n");
		return ResponseEntity.ok(report);
	}

}
