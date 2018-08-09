package com.tsystems.edu.akharlov;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName(value = "user_group_config")
@XmlRootElement(name = "user_group_config")
@Entity
@Table(name = "SVV_USER_GROUP_CONFIG")
public class UserGroupConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "GROUP_CONFIG_ID")
	private int groupConfigId;
	
	@Column(name = "USER_CONFIG_ID")
	private String userConfigId;
	
	@OneToOne
	@JoinColumn(name = "GROUP_CONFIG_ID", updatable = false, insertable = false)
	@JsonManagedReference
	private GroupConfig groupConfig;
	
	@ManyToOne
	@JoinColumn(name = "USER_CONFIG_ID", updatable = false, insertable = false)
	@JsonBackReference
	private UserConfig userConfig;

	@JsonGetter(value = "id")
	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@JsonGetter(value = "group_config_id")
	@XmlElement(name = "group_config_id")
	public int getGroupConfigId() {
		return groupConfigId;
	}

	@JsonGetter(value = "user_config_id")
	@XmlElement(name = "user_config_id")
	public String getUserConfigId() {
		return userConfigId;
	}

	public UserConfig getUserConfig() {
		return userConfig;
	}

	@JsonGetter(value = "group_config")
	@XmlElement(name = "group_config")
	public GroupConfig getGroupConfig() {
		return groupConfig;
	}

	@Override
	public String toString() {
		return "UserGroupConfig [id=" + id + ", groupConfigId=" + groupConfig.getId() + ", userConfig=" + userConfig + "]";
	}
}
