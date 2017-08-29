package org.service.quickpoll.service.impl;

import org.service.quickpoll.model.Poll;
import org.service.quickpoll.repository.PollRepository;
import org.service.quickpoll.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PollServiceImpl implements PollService {

	@Autowired
	private PollRepository pollRepository;

	@Override
	@Transactional
	public void addPoll(Poll poll) {
		this.pollRepository.addPoll(poll);
	}

	@Override
	@Transactional
	public void updatePoll(Poll poll) {
		this.pollRepository.updatePoll(poll);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Poll> getPollList() {
		return this.pollRepository.getPollList();
	}

	@Override
	@Transactional(readOnly = true)
	public Poll getPollById(Long id) {
		return this.pollRepository.getPollById(id);
	}

	@Override
	@Transactional
	public void removePoll(Long id) {
		this.pollRepository.removePoll(id);
	}
}
