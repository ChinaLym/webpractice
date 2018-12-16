package com.edeclare.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_role database table.
 * 
 */
@Entity
@Table(name="tb_role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	private String name;

	private String status;

	public Role() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}