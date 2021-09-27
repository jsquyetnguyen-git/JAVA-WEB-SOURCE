package connect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			out.println("Da tai driver");
		} catch (Exception e) {
			out.println("Khong the tai driver");
		}
	}

//		Connection conn = null;
//		
//		try {
//			conn = DriverManager.getConnection(
//					"jdbc:sqlserver://DESKTOP-OTNGK8O\SQLEXPRESS:1433;databaseName=testJDBC;integratedSecurity=true");
//		} catch (SQLException e) {
//			out.println("Khong ket noi duoc");
//			return;
//		}
//		
//		out.println("Da ket noi thanh cong.");
//		
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			
//		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
