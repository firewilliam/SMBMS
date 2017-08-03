package com.jbit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbit.dao.ProviderMapper;
import com.jbit.entity.Provider;
import com.jbit.service.ProviderService;
@Service("providerService")
public class ProviderServiceImpl implements ProviderService{
	@Autowired
	private ProviderMapper providerMapper;
	
	@Override
	public List<Provider> getProviderList() {
		// TODO Auto-generated method stub
		return providerMapper.getProviderList();
	}

	public ProviderMapper getProviderMapper() {
		return providerMapper;
	}

	public void setProviderMapper(ProviderMapper providerMapper) {
		this.providerMapper = providerMapper;
	}
	
}
