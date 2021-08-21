package com.webtintuc.dao;

import java.util.List;

import com.webtintuc.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
}
