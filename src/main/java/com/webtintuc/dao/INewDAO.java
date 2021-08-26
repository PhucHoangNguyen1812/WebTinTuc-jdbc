package com.webtintuc.dao;

import java.util.List;

import com.webtintuc.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
}
