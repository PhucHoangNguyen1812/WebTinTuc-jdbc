package com.webtintuc.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.webtintuc.dao.ICategoryDAO;
import com.webtintuc.model.CategoryModel;
import com.webtintuc.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<CategoryModel> findAll() {
		
		return categoryDao.findAll();
	}

	
}
