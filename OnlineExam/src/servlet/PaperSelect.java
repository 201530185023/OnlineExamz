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
import javax.servlet.http.HttpSession;

import dao.PaperDao;

/**
 * Servlet implementation class PaperSelect
 */
public class PaperSelect extends HttpServlet {               //�鿴�Ծ����е��Ծ�ɸѡ����
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperSelect() {
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
		String pCategory=new String(request.getParameter("select"));     //��ȡ�Ծ����
		PaperDao paperDao=new PaperDao();           //ʵ����SQL��
		ServletContext ctx=this.getServletContext();          //��ȡweb��xml�еĳ���
		String server=ctx.getInitParameter("server");
		String db=ctx.getInitParameter("db");
		String user=ctx.getInitParameter("user");
		String pwd=ctx.getInitParameter("pwd");
		String[] paperName=new String[100];
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("Name");
		try {
			paperDao.getConn(server, db, user, pwd);         //��ȡ����
			for(int i=0;paperDao.BrowsePaperName(pCategory)[i]!=null;i++) {
				paperName[i]=paperDao.BrowsePaperName(pCategory)[i];            //�����Ծ�����
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
			paperDao.closeAll();                  //�ر�ȫ�����ݼ�������
		}
		out.print("<html>");
		out.print("<head><title>�鿴�Ծ�</title>");
		out.print("<style type='text/css'>");
		out.print(".top_nei { width:100%;text-align:center;height:40px;background-color:#1E90FF;line-height:40px;font-size: 18px;font-family: '΢���ź�';color:white;}");
		out.print(".menu {line-height:50px;}");
		out.print("p a:hover {color:#FF6600;}");
		out.print(".STYLE4 {font-size: 18px;font-weight: bold;font-family: '΢���ź�';}");
		out.print("a:link,a:visited {color:#000;text-decoration:none;}");
		out.print("#menu {width: 145px;margin: auto;border: 1px solid #999;left: 64px;position: absolute;font-size: 14px;top: 209px;}");
		out.print("#div1 {display: none;font-size: 12px;position: relative;left: 192px;top: 5px;background-color: White;width: 100px;height: 30px;}");
		out.print("#div2 {display: none;font-size: 16px;position: relative;left: 192px;top: 25px;background-color: White;padding: 5px 10px 0px 10px;width: 100px;}");
		out.print("#div3 {display: none;font-size: 12px;position: relative;left: 192px;top: 60px;background-color: White;padding: 5px 10px 0px 10px;width: 100px;}");
		out.print("#div4 {display: none;font-size: 12px;position: relative;left: 192px;top: 90px;background-color: White;padding: 5px 10px 0px 10px;width: 100px;}");
		out.print(".STYLE5 {color: #000000;font-weight: bold;}");
		out.print(".STYLE7 {font-size: 18px;}");
		out.print("</style>");
		out.print("<script language='javascript' type='text/javascript'>");
		out.print("function showDiv(divName) {document.getElementById(divName).style.display = 'block';}");
		out.print("function hiddenDiv(divName) {document.getElementById(divName).style.display = 'none';}");
		out.print("</script>");
		out.print("<title>�鿴�Ծ�</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<p align='right'><a href='personal-4.jsp' class='STYLE4'>��ҳ</a></p>");
		out.print("<div class='top_nei'>");
		out.print("<div align='left'>");
		out.print("��ǰ�û���");
		out.print(name);
		out.print("</div>");
		out.print("</div>");
		out.print("<p>&nbsp;</p>");
		out.print("</head>");
		out.print("<body>");
		out.print("�Ծ����ɸѡ��");
		out.print("<form action='PaperSelect' method='post'>");
		out.print("<select name='select'>");
		out.print("<option value='all'>ȫ��</option>");
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
		out.print("<form action='BrowsePaperServletII' method='post'>");
		for(int i=0;paperName[i]!=null;i++) {          //���ֵ�ѡ��
			if(i==0) {
				out.print("<input type='radio' name='pname' value='"+paperName[i]+"' checked='true'>"+paperName[i]+"<br>");
			}
			else {
				out.print("<input type='radio' name='pname' value='"+paperName[i]+"'>"+paperName[i]+"<br>");
			}

		}
		out.print("<input type='submit' value='ȷ��' /><br>");
		out.print("<input type='button' value='����' onclick=\"location.href='tkmindex.jsp'\" /><br>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

}
