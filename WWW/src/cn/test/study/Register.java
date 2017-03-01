package cn.test.study;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import cn.test.untl.Mysqls;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
	    String c=request.getParameter("characters");
	    System.out.println(c);
	    String characters="";
	     if(c=="1")
	     {characters="及格";}
	     else if(c=="2")
	     {characters="良";}
	     else
	     {
	    	 characters="优";
	     }
	    	System.out.println(username);
	    System.out.println(password);
	    System.out.println(email);
	    System.out.println(characters);
	   /*
		String username="张";
		String password="zhangwenbo";
		String email="65432198gh7@qq.com";
		String characters="优";
		String phone="15029357163";*/
		Mysqls mysql=new Mysqls();
		Connection conn=null;
		String result="";
	 String phone=(String) getServletContext().getAttribute("phone");
		getServletContext().setAttribute("username", username);
		getServletContext().setAttribute("characters", characters);
	    try {
			 conn=(Connection) mysql.connect();
		    } 
	    catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
	    try {
			 result=mysql.register(conn, username, password, phone, email,characters);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(result);
	   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
