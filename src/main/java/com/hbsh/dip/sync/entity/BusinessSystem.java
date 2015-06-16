package com.hbsh.dip.sync.entity;

/***********************************************************************
 * Module:  T_BusinessSystem.java
 * Author:  lenovo
 * Purpose: Defines the Class T_BusinessSystem
 ***********************************************************************/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 业务系统
 * 
 * 
 * 业务系统
 */
@Entity
@Table(name = "T_BusinessSystem")
public class BusinessSystem {
	/** id */
	@Id
	@Column(length = 36)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	public java.lang.String id;
	/**
	 * 名称
 	 * 
	 */
	public java.lang.String name;
	/**
	 * ip地址
	 * 
	 */
	public java.lang.String ip;
	/**
	 * 唯一标志符
	 * 
	 */
	public java.lang.String code;
	
	@Transient
	public java.util.Collection<Interface> interfaceList;

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getIp() {
		return ip;
	}

	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}

	public java.lang.String getCode() {
		return code;
	}

	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.util.Collection<Interface> getInterfaceList() {
		return interfaceList;
	}

	public void setInterfaceList(java.util.Collection<Interface> interfaceList) {
		this.interfaceList = interfaceList;
	}
	
}