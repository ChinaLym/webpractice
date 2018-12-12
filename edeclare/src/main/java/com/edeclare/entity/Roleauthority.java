package com.edeclare.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_role_authority database table.
 * 
 */
@Entity
@Table(name="tb_role_authority")
@NamedQuery(name="Roleauthority.findAll", query="SELECT r FROM Roleauthority r")
public class Roleauthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pk_id")
	private int pkId;

	@Column(name="authority_id")
	private int authorityId;

	@Column(name="role_id")
	private int roleId;

	public Roleauthority() {
	}

	public int getPkId() {
		return this.pkId;
	}

	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

	public int getauthorityId() {
		return this.authorityId;
	}

	public void setauthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}