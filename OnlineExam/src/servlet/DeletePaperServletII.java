package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PaperDao;

/**
 * Servlet implementation class DeletePaperServletII
 */
public class DeletePaperServletII extends HttpServlet {               //ɾ���Ծ������ύ���Ľ���
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePaperServletII() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		PaperDao paperDao=new PaperDao();           //ʵ����SQL��
		ServletContext ctx=this.getServletContext();          //��ȡweb��xml�еĳ���
		String server=ctx.getInitParameter("server");
		String db=ctx.getInitParameter("db");
		String user=ctx.getInitParameter("user");
		String pwd=ctx.getInitParameter("pwd");
		String pName=new String(request.getParameter("pname"));       //��ȡ�Ծ�����
		String pNo=null;
		try {
			paperDao.getConn(server, db, user, pwd);         //��ȡ����
			pNo=paperDao.getPaperNo(pName);           //��ȡ�Ծ���
			if(paperDao.deletePaper(pNo)) {           //ɾ�����ݿ���ָ���Ծ�ȫ��������
				out.print("ɾ���Ծ�ɹ�<br>");
			}
			else {
				out.print("ɾ���Ծ�ʧ��<br>");
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		} 
		catch (InstantiationException e) {
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		finally {
			paperDao.closeAll();                 //�ر�ȫ�����ݼ�������
		}
		out.print("<input type='button' value='����˵�' onclick=\"location.href='tkmindex.jsp'\" /><br>");
	}

}
