package com.tsystems.edu.akharlov;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

@JsonRootName(value = "user")
@XmlRootElement(name = "user")
@Entity
@Table(name = "SVV_USER")
public class   User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "USERNAME")
	private String name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "ROLE_ID")
	private int roleId;
	
	@Column(name = "MAIN_ASSIGNEE_GROUP_ID")
	private int mainAssigneeGroupId;
	
	@Column(name = "COMPANY")
	private String company;
	
	@Column(name = "TIMEZONE_ID")
	private int timezoneId;
	
	@Column(name = "LOCKED")
	private int locked;
	
	@OneToOne(mappedBy = "user")
	@JsonManagedReference
	private UserConfig userConfig;

	@JsonGetter(value = "id")
	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@JsonGetter(value = "name")
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	@JsonGetter(value = "password")
	@XmlElement(name = "password")
	public String getPassword() {
		return password;
	}

	@JsonGetter(value = "email")
	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}

	@JsonGetter(value = "country")
	@XmlElement(name = "country")
	public String getCountry() {
		return country;
	}

	@JsonGetter(value = "full_name")
	@XmlElement(name = "full_name")
	public String getFullName() {
		return fullName;
	}

	@JsonGetter(value = "role_id")
	@XmlElement(name = "role_id")
	public int getRoleId() {
		return roleId;
	}

	@JsonGetter(value = "main_assignee_groupId")
	@XmlElement(name = "main_assignee_groupId")
	public int getMainAssigneeGroupId() {
		return mainAssigneeGroupId;
	}

	@JsonGetter(value = "company")
	@XmlElement(name = "company")
	public String getCompany() {
		return company;
	}

	@JsonGetter(value = "timezone_id")
	@XmlElement(name = "timezone_id")
	public int getTimezoneId() {
		return timezoneId;
	}

	@JsonGetter(value = "locked")
	@XmlElement(name = "locked")
	public int getLocked() {
		return locked;
	}

	@JsonGetter(value = "user_config")
	@XmlElement(name = "user_config")
	public UserConfig getUserConfig() {
		return userConfig;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", country="
				+ country + ", fullName=" + fullName + ", roleId=" + roleId + ", mainAssigneeGroupId="
				+ mainAssigneeGroupId + ", company=" + company + ", timezoneId=" + timezoneId + ", locked=" + locked
				+ ", userConfig=" + userConfig + "]";
	}
}
