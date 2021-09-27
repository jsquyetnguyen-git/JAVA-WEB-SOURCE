package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.User;
import database.Account;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			InitialContext initContext = new InitialContext();

			Context env = (Context) initContext.lookup("java:comp/env");

			ds = (DataSource) env.lookup("jdbc/js");

		} catch (NamingException e) {
			throw new ServletException();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");

		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (action.equals("login")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");

			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else if (action.equals("createaccount")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("repassword", "");
			request.setAttribute("message", "");

			request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
		} else {
			out.println("unrecognised action");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// use connection
		PrintWriter out = response.getWriter();
		request.setAttribute("message", "");

		String action = request.getParameter("action");

		if (action == null) {
			out.println("unrecognised action");
			return;
		}

		Connection conn = null;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServletException();
		}

		if (action.equals("dologin")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			// User user = new User(email, password);

			request.setAttribute("email", email);
			request.setAttribute("password", "");

			Account account = new Account(conn);

			try {
				if (account.login(email, password)) {
					request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "email address or password not recognised");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} catch (SQLException | ServletException | IOException e) {
				// Do something sensible here -- forward to error.jsp etc.
				e.printStackTrace();
			}

		} else if (action.equals("createaccount")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repassword");

			request.setAttribute("email", email);
			request.setAttribute("password", "");
			request.setAttribute("repassword", "");

			if (!password.equals(repassword)) {
				request.setAttribute("message", "Passwords do not match.");
				request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
			} else {

				User user = new User(email, password);

				if (!user.validate()) {
					request.setAttribute("message", user.getMessage());
					request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
				} else {
					Account account = new Account(conn);

					try {
						if (account.exists(email)) {
							request.setAttribute("message", "An account with this email address already exists.");
							request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
						} else {
							account.create(email, password);
							request.getRequestDispatcher("/createsuccess.jsp").forward(request, response);
						}
					} catch (SQLException | ServletException | IOException e) {
						request.getRequestDispatcher("/error.jsp").forward(request, response);
					}
				}
			}
		} else {
			out.println("unrecoginised action");
			return;
		}

	}
}
