package com.edeclare.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_project database table.
 * 
 */
@Entity
@Table(name="tb_project")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String domain;

	@Column(name="idx_activity_id")
	private Integer activityId;

	@Column(name="idx_director")
	private Integer director;

	private String level;

	private String name;

	private String promise;

	private String remarks;

	private Integer score;

	private String status;

	private String text;

	public Project() {
	}

	public Project(String domain, Integer activityId, Integer director, String level, String name, String promise,
			String remarks, Integer score, String status, String text) {
		super();
		this.domain = domain;
		this.activityId = activityId;
		this.director = director;
		this.level = level;
		this.name = name;
		this.promise = promise;
		this.remarks = remarks;
		this.score = score;
		this.status = status;
		this.text = text;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getDirector() {
		return director;
	}

	public void setDirector(Integer director) {
		this.director = director;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPromise() {
		return this.promise;
	}

	public void setPromise(String promise) {
		this.promise = promise;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}