package org.service.quickpoll.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "polls")
public class Poll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POLL_ID")
	private Long id;

	@Column(name = "QUESTION")
	private String question;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "options_polls",
			joinColumns = @JoinColumn(name = "POLL_ID"),
			inverseJoinColumns = @JoinColumn(name = "OPTION_ID")
			)
	@OrderBy
	private List<Option> options;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
}
