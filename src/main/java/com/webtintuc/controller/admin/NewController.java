package com.webtintuc.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webtintuc.constant.SystemConstant;
import com.webtintuc.model.NewModel;
import com.webtintuc.paging.PageRequest;
import com.webtintuc.paging.Pageble;
import com.webtintuc.service.ICategoryService;
import com.webtintuc.service.INewService;
import com.webtintuc.sort.Sorter;
import com.webtintuc.utils.FormUtil;
import com.webtintuc.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {

	private static final long serialVersionUID = -3713221121227713118L;
	
	@Inject
	private INewService newService;
	
	@Inject
	private ICategoryService categoryService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewModel model = FormUtil.toModel(NewModel.class, request);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST))
		{
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
			model.setLists(newService.findAll(pageble));
			model.setTotalItem(newService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view ="view/admin/new/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			
			if(model.getId() != null)
			{
				model = newService.findOne(model.getId());
			} else {
				
			}
			request.setAttribute("categories", categoryService.findAll());
			view ="view/admin/new/edit.jsp";	
		}
		MessageUtil.showMessage(request);
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd =  request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
