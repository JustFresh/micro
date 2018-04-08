package com.xiudoua.study.micro.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ssh_user")
public class SshUser{

	@Id
	@Column(name = "u_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uId;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "nickname")
    private String nickname;
    
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "create_time")
    private Date createTime;
    
    @Column(name = "u_status")
    private int uStatus;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "description")
    private String description;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getuStatus() {
		return uStatus;
	}

	public void setuStatus(int uStatus) {
		this.uStatus = uStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    

	
}
