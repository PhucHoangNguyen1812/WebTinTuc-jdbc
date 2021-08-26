package com.webtintuc.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.webtintuc.dao.INewDAO;
import com.webtintuc.model.NewModel;
import com.webtintuc.service.INewService;

public class NewService implements INewService {

	@Inject 
	private INewDAO newDao;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		Long newId = newDao.save(newModel);
		System.out.print(newId);
		return null;
	}

	

	
}
