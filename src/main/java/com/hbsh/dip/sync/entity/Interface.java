package com.hbsh.dip.sync.entity;

/***********************************************************************
 * Module:  T_Interface.java
 * Author:  lenovo
 * Purpose: Defines the Class T_Interface
 ***********************************************************************/

import java.util.*;

/** 接口
 * 
 * 
 * 业务系统下注册的接口 */
public class Interface {
   /** id */
   public java.lang.String id;
   /** 接口名称
    * 
    * 
    * 接口名称 */
   public java.lang.String name;
   /** 接口唯一标志
    * 
    * 
    * 接口唯一标志 */
   public java.lang.String code;
   
   public java.util.Collection<InterfaceSet> t_InterfaceSet;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<InterfaceSet> getT_InterfaceSet() {
      if (t_InterfaceSet == null)
         t_InterfaceSet = new java.util.HashSet<InterfaceSet>();
      return t_InterfaceSet;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorT_InterfaceSet() {
      if (t_InterfaceSet == null)
         t_InterfaceSet = new java.util.HashSet<InterfaceSet>();
      return t_InterfaceSet.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newT_InterfaceSet */
   public void setT_InterfaceSet(java.util.Collection<InterfaceSet> newT_InterfaceSet) {
      removeAllT_InterfaceSet();
      for (java.util.Iterator iter = newT_InterfaceSet.iterator(); iter.hasNext();)
         addT_InterfaceSet((InterfaceSet)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newT_InterfaceSet */
   public void addT_InterfaceSet(InterfaceSet newT_InterfaceSet) {
      if (newT_InterfaceSet == null)
         return;
      if (this.t_InterfaceSet == null)
         this.t_InterfaceSet = new java.util.HashSet<InterfaceSet>();
      if (!this.t_InterfaceSet.contains(newT_InterfaceSet))
         this.t_InterfaceSet.add(newT_InterfaceSet);
   }
   
   /** @pdGenerated default remove
     * @param oldT_InterfaceSet */
   public void removeT_InterfaceSet(InterfaceSet oldT_InterfaceSet) {
      if (oldT_InterfaceSet == null)
         return;
      if (this.t_InterfaceSet != null)
         if (this.t_InterfaceSet.contains(oldT_InterfaceSet))
            this.t_InterfaceSet.remove(oldT_InterfaceSet);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllT_InterfaceSet() {
      if (t_InterfaceSet != null)
         t_InterfaceSet.clear();
   }

}