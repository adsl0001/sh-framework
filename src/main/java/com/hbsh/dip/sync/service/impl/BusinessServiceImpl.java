package com.hbsh.dip.sync.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hbsh.dip.sync.service.BusinessService;

@Service("businessService")
@Transactional
public class BusinessServiceImpl implements BusinessService {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("sssssssssssssssssssssss");
	}

}
