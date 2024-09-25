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

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * @author Yuta Yamanaka
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//文字コードセット
		request.setCharacterEncoding("UTF-8");
		
		//ユーザID受け取り
		String userId = request.getParameter("userId");
		
		//パスワード受け取り(ハッシュ化したい)
		String password = request.getParameter("password");
		
		//フォワード先のパス(初期パス:ログイン画面)
		String Path = "login.jsp";
		
		//UserBeanインスタンス作成
		UserBean userBean = new UserBean();
		
		try {
			//UserDAOインスタンス作成
			UserDAO dao = new UserDAO();
			
			//ログイン判定
			userBean = dao.loginJudge(userId, password);
			
			//userBeanが存在すればログイン成功
			if(userBean != null) {
				//遷移先パス指定
				Path = "menu.jsp";
				
				//ユーザ情報をセッションで保持
				HttpSession session = request.getSession();
				session.setAttribute("userBean", userBean);
			}else {
				//失敗処理
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(Path);
		rd.forward(request, response);
	}

}
