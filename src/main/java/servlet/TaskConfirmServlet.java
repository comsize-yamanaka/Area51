package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskListDAO;
import model.entity.TaskBean;
import model.entity.TaskListBean;

/**
 * Servlet implementation class ItemConfirmServlet
 */
@WebServlet("/TaskConfirmServlet")
public class TaskConfirmServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//文字コードセット
		request.setCharacterEncoding("UTF-8");

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// TaskDetail2Servletで設定したタスクIDをセッションから取得
		int taskId = (int) session.getAttribute("taskId");
		//int taskId = Integer.parseInt(taskId2);

		//入力されたものを取得
		String taskName = (String) request.getParameter("taskName");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));

		LocalDate limitDate = null;
		System.out.println(request.getParameter("limitDate"));
		if (!request.getParameter("limitDate").equals("")) {
			limitDate = LocalDate.parse(request.getParameter("limitDate"));
		}

		String userId = request.getParameter("userId");
		String statusCode = request.getParameter("statusCode");
		String memo = request.getParameter("memo");

		int count = 0;//count:編集成功件数
		String Path = "task-alter-failure.jsp";//失敗画面のURL

		TaskBean taskBean2 = new TaskBean();

		taskBean2.setTaskName(taskName);
		taskBean2.setCategoryId(categoryId);
		taskBean2.setLimitDate(limitDate);
		taskBean2.setUserId(userId);
		taskBean2.setStatusCode(statusCode);
		taskBean2.setMemo(memo);
		taskBean2.setTaskId(taskId);

		TaskListBean taskDetail = null;
		try {

			TaskListDAO dao = new TaskListDAO();

			//登録メソッドの利用
			count = dao.updateTask(taskBean2, taskId);

			//編集成功ならタスク編集完了画面へ遷移
			if (count != 0) {
				taskDetail = dao.selectTask(taskId);//タスクIDで指定したタスクを取得
				Path = "task-alter-result.jsp";

				request.setAttribute("taskBean", taskBean2);

			} else {
				//登録失敗処理
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// タスク詳細をセッションスコープに設定

		session.setAttribute("taskDetail", taskDetail);

		RequestDispatcher rd = request.getRequestDispatcher(Path);
		rd.forward(request, response);
	}

}
