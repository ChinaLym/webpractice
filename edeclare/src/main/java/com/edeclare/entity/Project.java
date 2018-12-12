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
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pk_id")
	private int pkId;

	private String domain;

	@Column(name="idx_activity_id")
	private int idxActivityId;

	@Column(name="idx_director")
	private int idxDirector;

	private String level;

	private String name;

	private String promise;

	private String remarks;

	private int score;

	private String status;

	private String text;

	public Project() {
	}

	public int getPkId() {
		return this.pkId;
	}

	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getIdxActivityId() {
		return this.idxActivityId;
	}

	public void setIdxActivityId(int idxActivityId) {
		this.idxActivityId = idxActivityId;
	}

	public int getIdxDirector() {
		return this.idxDirector;
	}

	public void setIdxDirector(int idxDirector) {
		this.idxDirector = idxDirector;
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

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
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