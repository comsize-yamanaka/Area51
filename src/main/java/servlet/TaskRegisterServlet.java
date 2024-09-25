package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dao.StatusDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;

/**
 * Servlet implementation class TaskRegisterServlet
 */
@WebServlet("/TaskRegisterServlet")
public class TaskRegisterServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		List<CategoryBean> categoryList = new ArrayList<>();
		List<StatusBean> statusList = new ArrayList<>();
		
		try {
			
			CategoryDAO cateDAO = new CategoryDAO();
			StatusDAO statDAO = new StatusDAO();
			
			categoryList = cateDAO.selectAll();
			statusList = statDAO.selectAll();
			
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("statusList", statusList);
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("task-register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
