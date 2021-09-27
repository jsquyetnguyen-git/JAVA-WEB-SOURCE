package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			//collect data from a login form
			String userID = request.getParameter("username");
			String password = request.getParameter("password");
			//read information of account in web.xml
			String uid = getServletContext().getInitParameter("username");
			String pwd = getServletContext().getInitParameter("password");
			//check account - user validate code in assignment 1 to valid user
			if (userID != null && password.equals(pwd) && userID.equalsIgnoreCase(uid)) {
				response.sendRedirect("home.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				response.getWriter().println("<font color='red'>Username or password is invalid</font>");
				rd.include(request, response);
			}
		} catch (Exception e) {
			response.getWriter().println(e);
		}
	}

}
