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
import javax.servlet.http.HttpSession;

import model.dao.CategoryDAO;
import model.dao.StatusDAO;
import model.dao.TaskListDAO;
import model.dao.UserDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskListBean;
import model.entity.UserBean;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/TaskDetail2Servlet")
public class TaskDetail2Servlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// 選択したタスクのタスクIDを取得
		int taskId = Integer.parseInt(request.getParameter("task_id"));
		// タスクIDをセッションに設定
		session.setAttribute("taskId", taskId);

		List<CategoryBean> categoryList = new ArrayList<>();
		List<StatusBean> statusList = new ArrayList<>();
		List<UserBean> userList = new ArrayList<>();
		
		TaskListBean taskDetail = null;

		try {

			TaskListDAO taskListDAO = new TaskListDAO();
			CategoryDAO cateDAO = new CategoryDAO();
			StatusDAO statDAO = new StatusDAO();
			UserDAO userDAO = new UserDAO();
			
			taskDetail = taskListDAO.selectTask(taskId);//タスクIDで指定したタスクを取得

			categoryList = cateDAO.selectAll();
			statusList = statDAO.selectAll();
			userList = userDAO.selectAll();

			request.setAttribute("categoryList", categoryList);
			request.setAttribute("statusList", statusList);
			request.setAttribute("userList", userList);
			

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// タスクの詳細情報をセッションに設定
		session.setAttribute("taskDetail", taskDetail);

		RequestDispatcher rd = request.getRequestDispatcher("task-alter-form.jsp");
		rd.forward(request, response);
	}

	/*
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		
		//		//ここから
		//		
		//		// リクエストのエンコーディング方式を指定
		//		request.setCharacterEncoding("UTF-8");
		//
		//		TaskListDAO dao = new TaskListDAO();
		//		TaskListBean taskDetail2 = null;
		//		//List<TaskListBean> taskList = null;
		//
		//		// 選択したタスクのタスクIDを取得
		//		//int taskId = Integer.parseInt(request.getParameter("task_id"));
		//		
		//		// セッションオブジェクトの取得
		//				HttpSession session = request.getSession();
		//				int taskId = (int) session.getAttribute("taskId");
		//
		//		try {
		//			taskDetail2 = dao.selectTask(taskId);//タスク詳細取得
		//		} catch (SQLException | ClassNotFoundException e) {
		//			e.printStackTrace();
		//		}
		//
		//		
		//		
		//		
		//		// タスクの詳細情報をセッションに設定
		//		session.setAttribute("taskDetail2", taskDetail2);
		//		//session.setAttribute("taskId", taskId);
		//		// タスク詳細画面に遷移
		//		RequestDispatcher rd = request.getRequestDispatcher("task-alter-form.jsp");
		//		rd.forward(request, response);
	}
}
