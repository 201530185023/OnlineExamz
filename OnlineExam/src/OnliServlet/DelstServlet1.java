package OnliServlet;

import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StInfo;

public class DelstServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelstServlet1() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driver="com.mysql.jdbc.Driver";  
		String url = "jdbc:mysql://localhost:3307/examinationsystem?user=root&password=123";
		 response.setContentType("text/html;charset=utf-8");
		 request.setCharacterEncoding("utf-8");
		 PrintWriter out=response.getWriter();
		 try{ 
			 String username=request.getParameter("username");	
		     Class.forName(driver); 
			 Connection conn=DriverManager.getConnection(url);
			 Statement stmt = conn.createStatement();
			 String sql="delete from student where username='"+username+"'";//ɾ����Ϣ
			  stmt.executeUpdate(sql);
             stmt.close();
             conn.close(); 
             out.print("<head><title>��������Ա--ɾ��������Ϣ</title></head>");
			 out.print("��ɾ���û���Ϊ  "+username+"  �Ŀ�����Ϣ");	
			
		 }
		 catch(ClassNotFoundException e){
		 e.printStackTrace();
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);	
	}

}
