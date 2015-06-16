package com.hbsh.dip.sync.entity;

/***********************************************************************
 * Module:  T_InterfaceSet.java
 * Author:  lenovo
 * Purpose: Defines the Class T_InterfaceSet
 ***********************************************************************/

import java.util.*;

/** 接口设置
 * 
 * 
 * 存储接口对应的kettle转换 */
public class InterfaceSet {
   /** id */
   public java.lang.String id;
   /** 名称
    * 
    * 
    * 接口设置的名称 */
   public java.lang.String name;
   /** kettle转换名称 */
   public java.lang.String transformationName;
   /** kettle转换id */
   public int transformationId;
   /** 提醒手机号
    * 
    * 
    * 提醒手机号，多个号码使用逗号间隔 */
   public java.lang.String phone;
   /** 提醒邮件
    * 
    * 
    * 提醒人的邮件，多个邮件用逗号分隔 */
   public java.lang.String email;
   /** 出错重试次数
    * 
    * 
    * 出错重试次数
    * 大于等于0的整数
    * 等于0时不重试 */
   public int errorRepeatCount;
   /** 出错重试时间间隔
    * 
    * 
    * 出错重试时间间隔
    * 单位 分钟
    * 大于0的整数 */
   public int errorRepeatInterval;

}