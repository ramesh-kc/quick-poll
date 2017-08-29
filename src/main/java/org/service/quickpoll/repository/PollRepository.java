package org.service.quickpoll.repository;

import org.service.quickpoll.model.Poll;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository {
	void addPoll(Poll poll);

	void updatePoll(Poll poll);

	List<Poll> getPollList();

	Poll getPollById(Long id);

	void removePoll(Long id);

}
