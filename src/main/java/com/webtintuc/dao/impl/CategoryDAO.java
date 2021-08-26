package com.webtintuc.dao.impl;

import java.util.List;

import com.webtintuc.dao.ICategoryDAO;
import com.webtintuc.mapper.CategoryMapper;
import com.webtintuc.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}	
	
}
