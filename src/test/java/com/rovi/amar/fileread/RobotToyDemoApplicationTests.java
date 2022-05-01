package com.rovi.amar.fileread;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.robottoy.demo.RobotToyDemoApplication;
import com.robottoy.demo.model.Commands;
import com.robottoy.demo.model.Report;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = RobotToyDemoApplication.class)
public class RobotToyDemoApplicationTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	public void roboToyReportAsExpectedTest() {

		Report report = new Report();
		report.addOutput("0,1,NORTH");

		Commands round = new Commands();
		round.addCommand("PLACE 0,0,NORTH");
		round.addCommand("LEFT");
		round.addCommand("RIGHT");
		round.addCommand("MOVE");
		round.addCommand("REPORT");

		HttpEntity<Object> commands = getHttpEntity(round);

		ResponseEntity<Report> resultAsset = template.postForEntity("/robotoy/v1/play", commands, Report.class);
		Assert.assertEquals(resultAsset.getBody(), report);
	}

	@Test
	public void roboToyMissingTest() {

		Report report = new Report();
		report.addOutput("ROBOT MISSING");

		Commands round = new Commands();
		round.addCommand("MOVE");
		round.addCommand("REPORT");

		HttpEntity<Object> commands = getHttpEntity(round);
		ResponseEntity<Report> resultAsset = template.postForEntity("/robotoy/v1/play", commands, Report.class);
		Assert.assertEquals(resultAsset.getBody(), report);
	}

	@Test
	public void roboToyNorthReportAsExpectedTest() {

		Report report = new Report();
		report.addOutput("0,1,NORTH");

		Commands round = new Commands();
		round.addCommand("PLACE 0,0,NORTH");
		round.addCommand("MOVE");
		round.addCommand("REPORT");

		HttpEntity<Object> commands = getHttpEntity(round);

		ResponseEntity<Report> resultAsset = template.postForEntity("/robotoy/v1/play", commands, Report.class);
		Assert.assertEquals(resultAsset.getBody(), report);
	}
	@Test
	public void roboToyNorthToLefthMoveAsExpectedTest() {

		Report report = new Report();
		report.addOutput("0,0,EAST");

		Commands round = new Commands();
		round.addCommand("PLACE 0,0,NORTH");
		round.addCommand("LEFT");
		round.addCommand("REPORT");

		HttpEntity<Object> commands = getHttpEntity(round);

		ResponseEntity<Report> resultAsset = template.postForEntity("/robotoy/v1/play", commands, Report.class);
		Assert.assertEquals(resultAsset.getBody(), report);
	}
	
	@Test
	public void roboToyignoringCommandThatCausesFailTest() {

		Report report = new Report();
		report.addOutput("0,0,SOUTH");

		Commands round = new Commands();
		round.addCommand("PLACE 0,0,SOUTH");
		round.addCommand("MOVE");
		round.addCommand("REPORT");

		HttpEntity<Object> commands = getHttpEntity(round);

		ResponseEntity<Report> resultAsset = template.postForEntity("/robotoy/v1/play", commands, Report.class);
		Assert.assertEquals(resultAsset.getBody(), report);
	}
	@Test
	public void roboToyWithoutReportTest() {

		Report report = new Report();

		Commands round = new Commands();
		round.addCommand("PLACE 1,2,EAST");
		round.addCommand("MOVE");
		round.addCommand("MOVE");
		round.addCommand("LEFT");

		HttpEntity<Object> commands = getHttpEntity(round);

		ResponseEntity<Report> resultAsset = template.postForEntity("/robotoy/v1/play", commands, Report.class);
		
		Assert.assertEquals(resultAsset.getBody(), report);
	}

	private HttpEntity<Object> getHttpEntity(Object body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(body, headers);
	}

}