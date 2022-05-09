package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegPage
 */
@WebServlet("/RegPage")
public class RegPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 Connection scon=DbConnector.getConnection();
		 try {
			Statement st=scon.createStatement();
			String sql="select * from student";
			ResultSet rt=st.executeQuery(sql);
			out.println("<!DOCTYPE Html>");
			out.println("<head><title>Student Information</title></head>");
			out.println("<body>");
			out.println("<table border='3'>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>Age</th>");
			out.println("<th>fees</th>");
			out.println("<th>Password</th>");
			out.println("</tr>");
			while(rt.next())
			{
				out.println("<tr>");
				out.println("<td>"+rt.getString("sid")+"</td>");
				out.println("<td>"+rt.getString("sname")+"</td>");
				out.println("<td>"+rt.getString("sage")+"</td>");
				out.println("<td>"+rt.getString("sfees")+"</td>");
			    out.println("<td>"+rt.getString("spass")+"</td>");
			    out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
		 }catch(Exception e)
		 {
			e.printStackTrace();
		 }
	}
	}


