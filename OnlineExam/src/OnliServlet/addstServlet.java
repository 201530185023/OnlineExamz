package OnliServlet;

import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addstServlet() {
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String driver="com.mysql.jdbc.Driver";  
		 String url = "jdbc:mysql://localhost:3307/examinationsystem?user=root&password=123&Unicode=true&amp;characterEncoding=utf8&useSSL=false";//���ݿ��Ѿ������˱��룬���ﲻ��Ҫ������
		 response.setContentType("text/html;charset=utf-8");
		 request.setCharacterEncoding("utf-8");
		 PrintWriter out=response.getWriter();
		 try{

			 String username=request.getParameter("no");
			 String password=request.getParameter("pwd");
			 String telephone=request.getParameter("telephone");
			 String sname=request.getParameter("nam");		 
			 String sex=request.getParameter("xb");
			 String xueli=request.getParameter("xueli");
			 String card=request.getParameter("sfzh");
			 String address=request.getParameter("addr");
			 String university=request.getParameter("yuanx");
			 String special=request.getParameter("spe");			 
			 String email=request.getParameter("email");
			 Class.forName(driver); 
			 Connection conn=DriverManager.getConnection(url);
			 Statement stmt = conn.createStatement();	
		
			 String sql="update student set sname= '"+sname+"',xueli= '"+xueli+"',sex= '"+sex+"',card= '"+card+"',address= '"+address+"',university= '"+university+"',email= '"+email+"',password= '"+password+"',special= '"+special+"',telephone= '"+telephone+"' where username= '"+username+"'";//�������
				int a = stmt.executeUpdate(sql);
				if(a>0){
					 out.print("<head><title>��������Ա--��ӿ�����Ϣ</title></head>");
			    out.print("������Ϣ�ѳɹ���ӣ�");	
				}
				else{
				out.print("������Ϣ���ʧ�ܣ�");	}

				 stmt.close();
	             conn.close(); 
			   			   
	        
		 }
		 catch(ClassNotFoundException e){
		 e.printStackTrace();
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
			}

}
