package Project;

import java.io.IOException;
import Project.ConnectionProvider;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addStudent
 */
@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String course = request.getParameter("course");
		String branch = request.getParameter("branch");
		String rollNo = request.getParameter("rollNo");
		String name = request.getParameter("name");
		String fatherName = request.getParameter("fatherName");
		String gender = request.getParameter("gender");

		try
		{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("Insert into student values('"+course+"', '"+branch+"', '"+rollNo+"', '"+name+"', '"+fatherName+"', '"+gender+"')");
			response.sendRedirect("adminHome.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
