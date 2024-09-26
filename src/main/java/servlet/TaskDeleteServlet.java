package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskListDAO;

/**
 * @author Shoko Shimada
 * Servlet implementation class ItemDeleteServlet
 */
@WebServlet("/TaskDeleteServlet")
public class TaskDeleteServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		TaskListDAO dao = new TaskListDAO();
		int processingNumber = 0; //処理件数
		try {
			// 削除処理
			processingNumber = dao.deleteItem(Integer.parseInt(request.getParameter("task_id")));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 処理件数をリクエストスコープに設定
		request.setAttribute("processingNumber", processingNumber);
		// 削除結果画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("task-delete-result.jsp");
		rd.forward(request, response);
	}
}
