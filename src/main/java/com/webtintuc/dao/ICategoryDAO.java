package com.webtintuc.dao;

import java.util.List;

import com.webtintuc.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
}
