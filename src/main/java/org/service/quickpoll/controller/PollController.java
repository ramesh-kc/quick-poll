package org.service.quickpoll.controller;

import org.service.quickpoll.model.Poll;
import org.service.quickpoll.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PollController {

	@Autowired
	private PollService pollService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome() {
		return "Welcome to Poll Quick Application";
	}

	@RequestMapping(value = "/polls", method = RequestMethod.GET)
	public ResponseEntity<Poll> getAllPolls() {
		List<Poll> pollList = this.pollService.getPollList();
		return new ResponseEntity(pollList, HttpStatus.OK);
	}

	@RequestMapping(value = "/polls", method = RequestMethod.POST)
	public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
		this.pollService.addPoll(poll);

		/* Set the location header for newly created resource */
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newPollURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(poll.getId())
				.toUri();
		responseHeaders.setLocation(newPollURI);
		return new ResponseEntity(null,  responseHeaders, HttpStatus.CREATED);
	}
}
