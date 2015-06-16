package com.hbsh.dip.sync.entity;

/***********************************************************************
 * Module:  T_ExecuteLog.java
 * Author:  lenovo
 * Purpose: Defines the Class T_ExecuteLog
 ***********************************************************************/

import java.util.*;

/** 转换执行日志
 * 
 * 
 * 转换执行日志
 * 记录每次转换的执行情况 */
public class ExecuteLog {
   /** id */
   public java.lang.String id;
   /** 接口名称 */
   public java.lang.String interfaceName;
   /** 接口设置名称 */
   public java.lang.String interfaceSetName;
   /** kettle转换id */
   public int transformationId;
   /** kettle转换名称 */
   public java.lang.String transformationName;
   /** 开始执行时间 */
   public java.util.Date startTime;
   /** 执行结束时间 */
   public java.util.Date endTime;
   /** 状态 */
   public java.lang.String status;
   /** 执行日志 */
   public java.lang.String errorLog;

}