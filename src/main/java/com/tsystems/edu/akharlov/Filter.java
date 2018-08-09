package com.tsystems.edu.akharlov;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.GenerationType;

@JsonRootName(value = "filter")
@XmlRootElement(name = "filter")
@Entity
@Table(name = "SVV_FILTERS")
public class Filter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "SQL_QUERY")
	private String sqlQuery;
	
	@Column(name = "GROUP_CONFIG_ID")
	private int groupConfigId;
	
	@ManyToOne
	@JoinColumn(name = "GROUP_CONFIG_ID", updatable = false, insertable = false )
	@JsonBackReference
	private GroupConfig groupConfig;

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

	@JsonIgnore
	//@XmlElement(name = "sql_query")
	public String getSqlQuery() {
		return sqlQuery;
	}

	@JsonGetter(value = "group_config_id")
	@XmlElement(name = "group_config_id")
	public int getGroupConfigId() {
		return groupConfigId;
	}

	public GroupConfig getGroupConfig() {
		return groupConfig;
	}

	@Override
	public String toString() {
		return "Filter [id=" + id + ", name=" + name + ", sqlQuery=" + sqlQuery + ", groupConfig=" + groupConfig.getId() + "]";
	}
}
