package com.hbsh.dip.sync.entity;

/***********************************************************************
 * Module:  T_InterfaceLog.java
 * Author:  lenovo
 * Purpose: Defines the Class T_InterfaceLog
 ***********************************************************************/

import java.util.*;

/** webservice接口执行日志 */
public class InterfaceLog {
   /** 开始执行时间
    * 
    * 
    * 开始执行时间
    * 记录本次接口调用第一次计划执行的时间
    * 与webservice调用日志中的调用开始时间应该一致 */
   public java.util.Date startTime;
   /** 执行结束时间
    * 
    * 
    * 记录本次调用最后一次执行结束的时间 */
   public java.util.Date endTime;
   /** 接口Id */
   public java.lang.String interfaceId;
   /** 接口名称 */
   public java.lang.String interfaceName;
   /** 接口设置id
    * 
    * 
    * 接口设置id */
   public java.lang.String interfaceSetId;
   /** 接口设置的名称
    * 
    * 
    * 接口设置的名称 */
   public java.lang.String interfaceSetName;
   /** kettle转换id
    * 
    * 
    * kettle转换id */
   public int transformationId;
   /** kettle转换的名称
    * 
    * 
    * kettle转换的名称 */
   public java.lang.String transformationName;
   /** 执行次数
    * 
    * 
    * 执行次数，记录这个接口设置的转换是第几次执行 */
   public int executeCount;
   /** 执行状态
    * 
    * 
    * 记录这个转换的最后一次执行状态
    * 1执行成功
    * 0执行失败
    * 2等待上一次接口调用执行成功 */
   public java.lang.String status;
   /** 错误日志
    * 
    * 
    * 记录这个转换最后一次执行的日志 */
   public java.lang.String errorLog;
   
   public java.util.Collection<ExecuteLog> t_ExecuteLog;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<ExecuteLog> getT_ExecuteLog() {
      if (t_ExecuteLog == null)
         t_ExecuteLog = new java.util.HashSet<ExecuteLog>();
      return t_ExecuteLog;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorT_ExecuteLog() {
      if (t_ExecuteLog == null)
         t_ExecuteLog = new java.util.HashSet<ExecuteLog>();
      return t_ExecuteLog.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newT_ExecuteLog */
   public void setT_ExecuteLog(java.util.Collection<ExecuteLog> newT_ExecuteLog) {
      removeAllT_ExecuteLog();
      for (java.util.Iterator iter = newT_ExecuteLog.iterator(); iter.hasNext();)
         addT_ExecuteLog((ExecuteLog)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newT_ExecuteLog */
   public void addT_ExecuteLog(ExecuteLog newT_ExecuteLog) {
      if (newT_ExecuteLog == null)
         return;
      if (this.t_ExecuteLog == null)
         this.t_ExecuteLog = new java.util.HashSet<ExecuteLog>();
      if (!this.t_ExecuteLog.contains(newT_ExecuteLog))
         this.t_ExecuteLog.add(newT_ExecuteLog);
   }
   
   /** @pdGenerated default remove
     * @param oldT_ExecuteLog */
   public void removeT_ExecuteLog(ExecuteLog oldT_ExecuteLog) {
      if (oldT_ExecuteLog == null)
         return;
      if (this.t_ExecuteLog != null)
         if (this.t_ExecuteLog.contains(oldT_ExecuteLog))
            this.t_ExecuteLog.remove(oldT_ExecuteLog);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllT_ExecuteLog() {
      if (t_ExecuteLog != null)
         t_ExecuteLog.clear();
   }

}