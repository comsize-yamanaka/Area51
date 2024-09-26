package servlet;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/TaskDetailServlet")
public class TaskDetailServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		TaskListDAO dao = new TaskListDAO();
		TaskListBean taskDetail = null;
		//List<TaskListBean> taskList = null;

		// 選択したタスクのタスクIDを取得
		int taskId = Integer.parseInt(request.getParameter("task_id"));

		try {
			taskDetail = dao.selectTask(taskId);//タスク詳細取得
			//categoryList = dao.selectCategory();//プルダウン用の商品カテゴリ取得
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// タスクの詳細情報をセッションに設定
		session.setAttribute("taskDetail", taskDetail);
		// プルダウン用の商品カテゴリをセッションに設定
		//session.setAttribute("categoryList", categoryList);
		// タスク詳細画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("task-detail.jsp");
		rd.forward(request, response);
	}
}
