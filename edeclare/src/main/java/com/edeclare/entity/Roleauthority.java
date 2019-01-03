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
public class Roleauthority extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="authority_id")
	private Integer authorityId;

	@Column(name="role_id")
	private Integer roleId;

	public Roleauthority() {
	}

	public Integer getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}