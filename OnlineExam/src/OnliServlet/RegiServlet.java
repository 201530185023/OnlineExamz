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

public class RegiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegiServlet() {
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String driver="com.mysql.jdbc.Driver";  
		 String url = "jdbc:mysql://localhost:3307/examinationsystem?user=root&password=123";//���ݿ��Ѿ������˱��룬���ﲻ��Ҫ������
		 response.setContentType("text/html;charset=utf-8");
		 request.setCharacterEncoding("utf-8");
		 PrintWriter out=response.getWriter();
		 try{
			 //����ע�����Ϣ
			 String username=request.getParameter("no");
			 String password=request.getParameter("pwd");
			 String sname=request.getParameter("nam");
			 
			 String sex=request.getParameter("xb");
			 String xueli=request.getParameter("xueli");
			 String card=request.getParameter("sfzh");
			 String address=request.getParameter("addr");
			 String university=request.getParameter("yuanx");
			 String special=request.getParameter("spe");
			 String telephone=request.getParameter("telephone");
			 String email=request.getParameter("email");
			 Class.forName(driver); 
			 Connection conn=DriverManager.getConnection(url);
			 Statement stmt = conn.createStatement();		 
			 ResultSet rs = stmt.executeQuery("select * from student where username='"+username+"'");//��student������Ƿ����ͬ�����û���
			 if(rs.next()){//�������ͬ�����û���������ʾ"�û����Ѵ��ڣ�"
		          rs.close();
	             stmt.close();
	             conn.close();
	             out.print("�û����Ѵ��ڣ�");
	             out.print("����<a href='register.jsp'>����ע��</a>");
		       
		}
			 //��û�д���ͬ�����û��������ע����Ϣ¼�����ݿ�
			 else{
				  
				  String sql="insert into student (username, sname, sex, xueli, card, address, university, email, password, special, telephone)  values ('"+username+"','"+sname+"','"+sex+"','"+xueli+"','"+card+"','"+address+"','"+university+"','"+email+"','"+password+"','"+special+"','"+telephone+"')";

				  stmt.executeUpdate(sql);
		
			    out.print("<head><title>����ע�ᡪ�����߿���ϵͳ</title></head>");
			    out.print("ע��ɹ���");
			    out.print("<a href='login.jsp'>��¼</a>");
			 
				  }	  
			 
			
		        
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
