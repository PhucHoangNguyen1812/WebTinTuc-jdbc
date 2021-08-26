package com.webtintuc.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webtintuc.model.NewModel;
import com.webtintuc.service.ICategoryService;
import com.webtintuc.service.INewService;



@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewService newService;

	private static final long serialVersionUID = -3713221121227713118L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = "bai viet 1";
		String content = "bai viet 1";
		Long categoryId = 1L;
		NewModel newModel = new NewModel();
		newModel.setTitle(title);
		newModel.setContent(content);
		newModel.setCategoryId(categoryId);
		newService.save(newModel);
		request.setAttribute("categories", categoryService.findAll());
		RequestDispatcher rd =  request.getRequestDispatcher("view/web/home.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
