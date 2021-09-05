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

	@Override
	public CategoryModel findOne(long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> categoryModel = query(sql, new CategoryMapper(), id);
		return categoryModel.isEmpty() ? null : categoryModel.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> categoryModel = query(sql, new CategoryMapper(), code);
		return categoryModel.isEmpty() ? null : categoryModel.get(0);
	}	
	
}
