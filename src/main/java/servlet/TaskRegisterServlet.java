package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import model.dao.TaskListDAO;
import model.dao.UserDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskBean;
import model.entity.UserBean;

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
		List<UserBean> userList = new ArrayList<>();
		
		try {
			
			CategoryDAO cateDAO = new CategoryDAO();
			StatusDAO statDAO = new StatusDAO();
			UserDAO userDAO = new UserDAO();
			
			categoryList = cateDAO.selectAll();
			statusList = statDAO.selectAll();
			userList = userDAO.selectAll();
			
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("statusList", statusList);
			request.setAttribute("userList", userList);
			
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
		request.setCharacterEncoding("UTF-8");
		
		String taskName = (String)request.getParameter("taskName");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		LocalDate limitDate = LocalDate.parse(request.getParameter("limitDate"), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		String userId = request.getParameter("userId");
		String statusCode = request.getParameter("statusCode");
		String memo = request.getParameter("memo");
		
		int count = 0;
		String Path = "task-register-failure.jsp";
		
		TaskBean taskBean = new TaskBean();
		
		taskBean.setTaskName(taskName);
		taskBean.setCategoryId(categoryId);
		taskBean.setLimitDate(limitDate);
		taskBean.setUserId(userId);
		taskBean.setStatusCode(statusCode);
		taskBean.setMemo(memo);
		
		try {
			
			TaskListDAO dao = new TaskListDAO();
			
			count = dao.taskRegister(taskBean);
			
			//登録成功ならタスク登録完了画面へ遷移
			if(count != 0) {
				Path = "task-register-success";
				
				request.setAttribute("taskBean", taskBean);
				
			}else {
				//登録失敗処理
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(Path);
		rd.forward(request, response);
	}

}
