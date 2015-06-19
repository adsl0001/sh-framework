package com.hbsh.dip.core.entity;

import java.util.List;

public class Menu {
	//id
	String id;
	//	菜单名称
	String name;
	//子菜单列表
	List<Menu> subMeunList;
	//排序号
	Long orderNo ;
	//资源列表
	List<Resource> resourceList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Menu> getSubMeunList() {
		return subMeunList;
	}
	public void setSubMeunList(List<Menu> subMeunList) {
		this.subMeunList = subMeunList;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public List<Resource> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}
	 
}
