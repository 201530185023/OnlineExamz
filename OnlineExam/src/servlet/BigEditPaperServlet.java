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
 * Servlet implementation class BigEditPaperServlet
 */
public class BigEditPaperServlet extends HttpServlet {               //������޸��Ծ����������Ծ����Խ���
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BigEditPaperServlet() {
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
		String pname=new String(request.getParameter("pname"));       //��ȡ�Ծ�����
		String pChoShu=new String(request.getParameter("pcshu"));           //��ȡѡ�������
		String pFillShu=new String(request.getParameter("pfshu"));          //��ȡ��������
		String pChoPoi=null;
		String pFillPoi=null;
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("Name");
		try {
			paperDao.getConn(server, db, user, pwd);         //��ȡ����
			pChoPoi=paperDao.getChoPoi(pname);               //��ȡѡ���⡢������ֵ
			pFillPoi=paperDao.getFillPoi(pname);
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
			paperDao.closeAll();              //�ر�ȫ�����ݼ�������
		}
		out.print("<html>");
		out.print("<head>");
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
		out.print("<script type='text/javascript' language='javascript'>");
		out.print("function check() {");            //��麯�������ڼ������Ƿ�ǿ�
		out.print("if(document.form1.pcshu.value==\"\") {alert(\"������ѡ��������\");}");
		out.print("else if(document.form1.pcpoint.value==\"\") {alert(\"������ѡ��������\");}");
		out.print("else if(document.form1.pfshu.value==\"\") {alert(\"������ѡ��������\");}");
		out.print("else if(document.form1.pfpoint.value==\"\") {alert(\"������ѡ��������\");}");
		out.print("else {document.form1.submit();}");
		out.print("}");
		out.print("</script>");
		out.print("<title>�༭�Ծ�</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("�Ծ�����"+pname+"<br>");
		out.print("<form name='form1' action='BigEditPaperServletII' method='post'>");
		out.print("ѡ��������"+"<input type='text' name='pcshu' value='"+pChoShu+"' /><br>");
		out.print("ѡ�����ֵ��"+"<input type='text' name='pcpoint' value='"+pChoPoi+"' /><br>");
		out.print("���������"+"<input type='text' name='pfshu' value='"+pFillShu+"' /><br>");
		out.print("������ֵ��"+"<input type='text' name='pfpoint' value='"+pFillPoi+"' /><br>");
		out.print("<input type='hidden' name='pname' value='"+pname+"' />");            //���ر���
		out.print("<input type='hidden' name='pcshu' value='"+pChoShu+"' />");
		out.print("<input type='hidden' name='pcpoint' value='"+pChoPoi+"' />");
		out.print("<input type='hidden' name='pfshu' value='"+pFillShu+"' />");
		out.print("<input type='hidden' name='pfpoint' value='"+pFillPoi+"' />");
		out.print("<input type='button' value='ȷ��' onclick=\"check()\" />");
		out.print("<input type='button' value='����' onclick=\"window.location.href='/OnlineExam/EditPaperServlet'\" />");
		out.print("<input type='button' value='����˵�' onclick=\"location.href='PaperSetting.jsp'\" /><br>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

}
