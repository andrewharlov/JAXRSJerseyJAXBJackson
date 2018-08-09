package com.tsystems.edu.akharlov;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;
import java.util.Collection;
import java.util.List;

@JsonRootName(value = "user_config")
@XmlRootElement(name = "user_config")
@Entity
@Table(name = "SVV_USER_CONFIG")
public class UserConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "FILTER_COCKPIT_ENABLED")
	private int filterCockpitEnabled;
	
	@Column(name = "GROUP_COCKPIT_ENABLED")
	private int groupCockpitEnabled;
	
	@OneToOne
	@JoinColumn(name = "USER_ID", updatable = false, insertable = false)
	@JsonBackReference
	private User user;
	
	@OneToMany(mappedBy = "userConfig", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<UserGroupConfig> userGroupConfig;

	@JsonGetter(value = "id")
	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@JsonGetter(value = "user_id")
	@XmlElement(name = "user_id")
	public String getUserId() {
		return userId;
	}

	@JsonGetter(value = "name")
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	@JsonGetter(value = "filter_cockpit_enabled")
	@XmlElement(name = "filter_cockpit_enabled")
	public int getFilterCockpitEnabled() {
		return filterCockpitEnabled;
	}

	@JsonGetter(value = "group_cockpit_enabled")
	@XmlElement(name = "group_cockpit_enabled")
	public int getGroupCockpitEnabled() {
		return groupCockpitEnabled;
	}
	
	public User getUser() {
		return user;
	}

	@JsonGetter(value = "user_group_config")
	@XmlElement(name = "user_group_config")
	public Collection<UserGroupConfig> getUserGroupConfig() {
		return userGroupConfig;
	}

	@Override
	public String toString() {
		return "UserConfig [id=" + id + ", user=" + user.getId() + ", name=" + name + ", filterCockpitEnabled="
				+ filterCockpitEnabled + ", groupCockpitEnabled=" + groupCockpitEnabled + "]";
	}
}
