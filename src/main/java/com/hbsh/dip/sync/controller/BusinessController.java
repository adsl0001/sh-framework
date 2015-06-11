package com.hbsh.dip.sync.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hbsh.dip.sync.service.BusinessService;

@Controller
@Scope("prototype")
@RequestMapping("/sync/business")
public class BusinessController {
	@Resource
	BusinessService businessService;

	@RequestMapping(value = "list")
	public String list() {
		businessService.save();
		return "sync/business/businessList";
	}
}
