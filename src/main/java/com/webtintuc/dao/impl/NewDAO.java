package com.webtintuc.dao.impl;

import java.util.List;

import com.webtintuc.dao.INewDAO;
import com.webtintuc.mapper.NewMapper;
import com.webtintuc.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		
		String sql = "INSERT INTO news (title, content, categoryid) VALUES(?,?,?)";
		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryId());
	}

}
