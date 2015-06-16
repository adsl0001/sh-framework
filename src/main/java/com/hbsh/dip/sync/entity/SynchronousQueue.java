package com.hbsh.dip.sync.entity;

/***********************************************************************
 * Module:  SynchronousQueue.java
 * Author:  lenovo
 * Purpose: Defines the Class SynchronousQueue
 ***********************************************************************/

import java.util.*;

/** 执行队列
 * 
 * 
 * 存储未执行的接口设置 */
public class SynchronousQueue {
   /** id */
   public java.lang.String id;
   /** webservice调用日志id */
   public java.lang.String webserviceLogId;
   /** 接口设置id */
   public java.lang.String interfaceSetId;
   /** kettle转换id */
   public int transformationId;
   /** 进入队列时间 */
   public java.util.Date inputTime;
   /** 接口唯一标志 */
   public java.lang.String interfaceCode;
   /** 业务系统唯一标志 */
   public java.lang.String businessCode;
   /** 状态
    * 
    * 
    * 1未进入执行队列
    * 2已进入执行队列未执行
    * 3已执行成功（待删除）
    * 4已执行失败（阻塞队列） */
   public java.lang.String status;
   /** 执行次数
    * 
    * 
    * 记录是第几次执行 */
   public int executeCount;
   /** 下一次执行时间
    * 
    * 
    * 记录任务下一次执行时间
    * 系统重新启动时使用这个时间来计划下一次重试
    * 如果下一次执行时间小于当前时间，任务立即执行 */
   public java.util.Date lastExecuteTime;

}