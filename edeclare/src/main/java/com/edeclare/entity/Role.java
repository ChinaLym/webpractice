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

	private Integer id;
	
	private String description;

	private String name;

	private String status;

	public Role() {
	}
	
	public Role(Integer id, String name, String status, String description) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
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