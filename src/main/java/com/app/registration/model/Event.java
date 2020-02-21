package com.app.registration.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_event")
	private long idEvent;
	
	@Column(name="code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "event_start")
	private Date eventStart;
	
	@Column(name = "event_end")
	private Date eventEnd;
	
	@ManyToMany
	@JoinColumn(name="id_reward", nullable = false, insertable = false, updatable = false)
	private List<Reward>rewards;
	
//	@ManyToMany 
//	@JoinTable(name = "event", joinColumns = { @JoinColumn(name = "id_reward", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_event", nullable = false) })
//	private List<Reward> reward;
//	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(long idEvent, String code, String name, String description, Date eventStart, Date eventEnd,
			List<Reward> rewards) {
		super();
		this.idEvent = idEvent;
		this.code = code;
		this.name = name;
		this.description = description;
		this.eventStart = eventStart;
		this.eventEnd = eventEnd;
		this.rewards = rewards;
	}

		
	
	
}
