package org.service.quickpoll.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.service.quickpoll.model.Poll;
import org.service.quickpoll.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PollRepositoryImpl implements PollRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPoll(Poll poll) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(poll);
		System.out.println("Poll Saved Successfully");
	}

	@Override
	public void updatePoll(Poll poll) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(poll);
		System.out.println("Poll Updated Successfully");
	}

	@Override
	public List<Poll> getPollList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Poll> pollList = session.createQuery("FROM Poll").list();
		return pollList;
	}

	@Override
	public Poll getPollById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Poll poll = (Poll) session.load(Poll.class, id);
		return poll;
	}

	@Override
	public void removePoll(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Poll poll = (Poll) session.load(Poll.class, id);

		if (poll != null) {
			session.delete(poll);
		}
	}
}
