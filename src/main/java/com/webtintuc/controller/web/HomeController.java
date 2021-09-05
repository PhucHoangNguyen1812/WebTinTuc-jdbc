package com.webtintuc.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webtintuc.model.UserModel;
//import com.webtintuc.model.NewModel;
import com.webtintuc.service.ICategoryService;
import com.webtintuc.service.IUserService;
//import com.webtintuc.service.INewService;
import com.webtintuc.utils.FormUtil;
import com.webtintuc.utils.SessionUtil;



@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet {
	
	@Inject
	private ICategoryService categoryService;
	
	/*@Inject
	private INewService newService;*/
	
	@Inject
	private IUserService userService;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	private static final long serialVersionUID = -3713221121227713118L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("login")) {
			String alert = request.getParameter("alert");
			String message = request.getParameter("message");
			if (message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd =  request.getRequestDispatcher("view/login.jsp");
			rd.forward(request, response);
		} else if(action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath()+"/trang-chu");
		} else {
			/*String title = "bai viet 1";
			String content = "bai viet 1";
			Long categoryId = 1L;
			NewModel newModel = new NewModel();
			newModel.setTitle(title);
			newModel.setContent(content);
			newModel.setCategoryId(categoryId);
			newService.save(newModel);*/
			request.setAttribute("categories", categoryService.findAll());
			RequestDispatcher rd =  request.getRequestDispatcher("view/web/home.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, request);
			model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
			if(model != null)
			{
				SessionUtil.getInstance().putValue(request, "USERMODEL", model);
				if(model.getRole().getCode().equals("USER"))
				{
					response.sendRedirect(request.getContextPath()+ "/trang-chu");
					
				} else if (model.getRole().getCode().equals("ADMIN")) {
					
					response.sendRedirect(request.getContextPath()+ "/admin-home");
					
				}
			} else {
				response.sendRedirect(request.getContextPath()+ "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		}
	}

}
