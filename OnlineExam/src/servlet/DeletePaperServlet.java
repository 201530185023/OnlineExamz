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
 * Servlet implementation class DeletePaperServlet
 */
public class DeletePaperServlet extends HttpServlet {               //ɾ���Ծ�����ѡ���Ծ����
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePaperServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		PaperDao paperDao=new PaperDao();           //ʵ����SQL��
		ServletContext ctx=this.getServletContext();          //��ȡweb��xml�еĳ���
		String server=ctx.getInitParameter("server");
		String db=ctx.getInitParameter("db");
		String user=ctx.getInitParameter("user");
		String pwd=ctx.getInitParameter("pwd");
		String[] paperName=new String[100];
		try {
			paperDao.getConn(server, db, user, pwd);         //��ȡ����
			for(int i=0;paperDao.BrowsePaperName()[i]!=null;i++) {
				paperName[i]=paperDao.BrowsePaperName()[i];            //�����Ծ�����
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
			paperDao.closeAll();
		}
		out.print("<html>");
		out.print("<head>");
		out.print("<script type='text/javascript' language='javascript'>");
		out.print("function check() {");                 //ȷ�϶Ի���
		out.print("if(window.confirm(\"ȷ��ɾ��ѡ���Ծ�\")) {document.form1.submit();}");
		out.print("}");
		out.print("</script>");
		out.print("<title>ɾ���Ծ�</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("�Ծ����ɸѡ��");
		out.print("<form action='PaperSelectIII' method='post'>");
		out.print("<select name='select'>");
		out.print("<option value='all' selected='selected'>ȫ��</option>");
		out.print("<option value='computer'>�������</option>");
		out.print("<option value='construction'>������</option>");
		out.print("<option value='medicine'>ҽѧ��</option>");
		out.print("<option value='degree'>ѧ����</option>");
		out.print("<option value='language'>������</option>");
		out.print("<option value='finance'>�ƾ���</option>");
		out.print("<option value='foreigntrade'>��ó��</option>");
		out.print("<option value='civilservant'>����Ա��</option>");
		out.print("<option value='qualification'>�ʸ���</option>");
		out.print("<option value='law'>������</option>");
		out.print("</select> ");
		out.print("<input type='submit' value='ȷ��' /><br>");
		out.print("</form>");
		out.print("��ѡ����Ҫ�鿴���Ծ�<br>");
		out.print("<form name='form1' action='DeletePaperServletII' method='post'>");
		for(int i=0;paperName[i]!=null;i++) {          //���ֵ�ѡ��
			if(i==0) {
				out.print("<input type='radio' name='pname' value='"+paperName[i]+"' checked='true'>"+paperName[i]+"<br>");
			}
			else {
				out.print("<input type='radio' name='pname' value='"+paperName[i]+"'>"+paperName[i]+"<br>");
			}

		}
		out.print("<input type='button' value='ȷ��' onclick=\"check()\" />");
		out.print("<input type='button' value='����' onclick=\"location.href='tkmindex.jsp'\" /><br>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

}
