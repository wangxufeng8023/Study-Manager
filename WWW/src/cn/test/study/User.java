package cn.test.study;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import cn.test.untl.Mysqls;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
		 request.setCharacterEncoding("UTF-8");
		 Mysqls my=new Mysqls();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String flag=request.getParameter("history");
		 String username=request.getParameter("username");
	
	     System.out.println(flag);
	     System.out.println(username);

	 


		
		
 
	
		String[] history=null;
	
			
		 int a=0;
		try {
			a = my.counth(username);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				history = new String [a+1];
				try {
					history=my.history(username);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(a+1);
				for(int i=0;i<history.length;i++)
				{
					response.getWriter().append(history[i]);
					System.out.println(history[i]);
				}
		
	}
			
	
	/*
	else{
		
	
	}
	
	
	
 
	
	
//response.getWriter().append(rs+"").append(request.getContextPath()); 
    
	

	

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void sends(HttpServletResponse response,String[]a) throws IOException
	{
		for(int i=0;i<a.length;i++)
		{
			response.getWriter().append(a[i]+"");
			System.out.println(a[i]);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
