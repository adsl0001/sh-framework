package com.hbsh.dip.sync.entity;

/***********************************************************************
 * Module:  T_webservviceLog.java
 * Author:  lenovo
 * Purpose: Defines the Class T_webservviceLog
 ***********************************************************************/

import java.util.*;

/**
 * webservice调用日志
 */
public class WebserviceLog {
	/** id */
	public java.lang.String id;
	/**
	 * 调用开始时间
	 * 
	 * webservice调用开始时间
	 */
	public java.util.Date startTime;
	/**
	 * 
	 * 
	 * 调用结束时间
	 */
	public java.util.Date endTime;
	/**
	 * 名称
	 * 
	 * 
	 */
	public java.lang.String name;
	/**
	 * 调用端ip地址
	 * 
	 * 
	 * 调用端ip地址
	 */
	public java.lang.String ip;
	/**
	 * 业务系统唯一标志符
	 * 
	 * 
	 * 唯一标志符
	 */
	public java.lang.String businessCode;
	/** 业务系统名称 */
	public java.lang.String businessName;
	/** 接口唯一标志 */
	public java.lang.String interfaceCode;
	/** 接口名称 */
	public java.lang.String interfaceName;
	/**
	 * 调用参数
	 * 
	 * 
	 * 存储调用webservice的参数值
	 */
	public java.lang.String parameter;
	/**
	 * 调用日志信息
	 * 
	 * 
	 * 记录调用日志信息 成功记录ok 失败记录失败的错误信息
	 */
	public java.lang.String log;
	/**
	 * 状态
	 * 
	 * 
	 * 调用状态 1成功 0失败
	 */
	public java.lang.String status;

	public java.util.Collection<InterfaceLog> interfaceLogList;

 

}