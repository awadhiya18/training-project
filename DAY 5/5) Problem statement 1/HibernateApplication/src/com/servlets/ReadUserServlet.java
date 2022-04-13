package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.User;
import com.util.HibernateUtil;

/**
 * Servlet implementation class ReadStudentServlet
 */
@WebServlet("/read-student")
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadUserServlet() {
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

		SessionFactory sf = HibernateUtil.buildSessionFactory();

		Session session = sf.openSession();

		List<User> users = session.createQuery(" from Student").list();
		

		out.print("<h1> Student List :- </h1>");
		out.print("<style> table, td, th {border:2px solid red; padding:10px;}</style>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> Student Id </th>");
		out.print("<th> Student First Name </th>");
		out.print("<th> Student Last Name </th>");
		out.print("<th> Student PhoneNumbers </th>");
		out.print("<th> Student Courses </th>");
		out.print("<th> Student Address </th>");
		out.print("</tr>");

		for (User user : users) {
			out.print("<tr>");
			out.print("<td>" + user.getStudentId() + "</td>");
			out.print("<td>" + user.getFname() + "</td>");
			out.print("<td>" + user.getLname() + "</td>");
			out.print("<td>" + user.getPhoneNumbers() + "</td>");
			out.print("<td>" + user.getCourses() + "</td>");
			out.print("<td>" + user.getAddress() + "</td>");
			out.print("</tr>");
		}
		session.close();
		out.print("</table> </body> </html>");
	}

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
