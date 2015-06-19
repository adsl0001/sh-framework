package com.hbsh.dip.index.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbsh.dip.core.entity.Menu;

@Controller
@Scope("prototype")
@RequestMapping("/")
public class MainController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/getMenu", method = RequestMethod.POST)
	@ResponseBody
	public String getMenu() {
		List<Menu> menuList = new ArrayList<>();
		Menu menu = new Menu();
		menu.setId(UUID.randomUUID().toString());
		menu.setName("同步数据");
		menu.setOrderNo(0l);
		menuList.add(menu);
		Menu subMenu = new Menu();
		subMenu.setId(UUID.randomUUID().toString());
		subMenu.setName("同步接口设置");
		subMenu.setOrderNo(0l);
		Menu m1 = new Menu();
		
		List<Menu> subMenuList = new ArrayList<>();
		subMenuList.add(subMenu);
		menu = new Menu();
		menu.setId(UUID.randomUUID().toString());
		menu.setName("异步数据");
		menu.setOrderNo(1l);
		menuList.add(menu);

		return "index";
	}
}
