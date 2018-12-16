package com.edeclare.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_authority database table.
 * 
 */
@Entity
@Table(name="tb_authority")
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String describe;

	private String name;

	@Column(name="parent_id")
	private int parentId;

	private String status;

	private String url;

	public Authority() {
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}