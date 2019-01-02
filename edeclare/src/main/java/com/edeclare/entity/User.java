package com.edeclare.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_user database table.
 * 
 */
@Entity
@Table(name="tb_user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private String department;

	@Column(name="idx_phone")
	private String phone;

	private String name;

	private String password;

	@Column(name="role_id")
	private Integer roleId;

	private String sex;

	private String status;

	private String text;

	@Column(name="uk_account")
	private String account;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public User() {
	}
	
	public User(String account, String password, String name, String sex, String phone, String department,
			Integer roleId, Date createTime, Date updateTime, String status, String text) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.department = department;
		this.roleId = roleId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.text = text;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "User [" + super.toString() + ",createTime=" + createTime + ", department=" + department + ", phone=" + phone + ", name=" + name
				+ ", password=" + password + ", roleId=" + roleId + ", sex=" + sex + ", status=" + status + ", text="
				+ text + ", account=" + account + ", updateTime=" + updateTime + "]";
	}

	
}