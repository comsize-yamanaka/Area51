package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskListDAO;
import model.entity.TaskListBean;

/**
 * Servlet implementation class TaskListServlet
 */
@WebServlet("/TaskListServlet")
public class TaskListServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		List<TaskListBean> taskList = null;
		// DAO????
		TaskListDAO dao = new TaskListDAO();

		try {
			//
			taskList = dao.selectAll();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// sessionに格納
		HttpSession session = request.getSession();
		session.setAttribute("taskList", taskList);

		//リクエスト送信
		RequestDispatcher rd = request.getRequestDispatcher("task-list.jsp");
		rd.forward(request, response);
		
	}

}