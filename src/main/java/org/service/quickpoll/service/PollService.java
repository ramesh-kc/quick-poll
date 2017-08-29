package org.service.quickpoll.service;

import org.service.quickpoll.model.Poll;

import java.util.List;

public interface PollService {
	void addPoll(Poll poll);

	void updatePoll(Poll poll);

	List<Poll> getPollList();

	Poll getPollById(Long id);

	void removePoll(Long id);
}
