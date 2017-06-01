package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PaperDao;
import entity.Paper;

/**
 * Servlet implementation class NewPaperServletII
 */
public class NewPaperServletII extends HttpServlet {          //�½��Ծ����������������
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPaperServletII() {
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
		int j=0;
		String pCategory=new String(request.getParameter("pcategory"));     //��ȡ�Ծ����
		String pNo=new String(request.getParameter("pno"));                 //��ȡ�Ծ���
		String pName=new String(request.getParameter("pname"));             //��ȡ�Ծ�����
		String pChoShu=new String(request.getParameter("pcshu"));           //��ȡѡ�������
		String pFillShu=new String(request.getParameter("pfshu"));          //��ȡ��������
		int _pChoShu=Integer.parseInt(pChoShu);
		int _pFillShu=Integer.parseInt(pFillShu);
		Paper paper=new Paper();           //ʵ�������ݲ�
		paper.setpCategory(pCategory);           //���ø���ֵ
		paper.setpNo(pNo);
		paper.setpName(pName);
		paper.setpChoShu(pChoShu);
		paper.setpFillShu(pFillShu);
		ServletContext ctx=this.getServletContext();          //��ȡweb��xml�еĳ���
		String server=ctx.getInitParameter("server");
		String db=ctx.getInitParameter("db");
		String user=ctx.getInitParameter("user");
		String pwd=ctx.getInitParameter("pwd");
		PaperDao paperDao=new PaperDao();           //ʵ����SQL��
		out.print("<form action='BrowsePaperServletII' method='post'>");
		for(int i=0;i<_pChoShu;i++) {
			String pChoQu=new String(request.getParameter("pcq"+i));           //��ȡѡ������Ŀ
			String op1=new String(request.getParameter("op1"+i));              //��ȡAѡ��
			String op2=new String(request.getParameter("op2"+i));              //��ȡBѡ��
			String op3=new String(request.getParameter("op3"+i));              //��ȡCѡ��
			String op4=new String(request.getParameter("op4"+i));              //��ȡDѡ��
			String pChoAn=new String(request.getParameter("pca"+i));           //��ȡѡ�����
			paper.setpMun((i+1)+"");
			paper.setpChoQu(pChoQu);           //���ø���ֵ
			paper.setOp1(op1);
			paper.setOp2(op2);
			paper.setOp3(op3);
			paper.setOp4(op4);
			paper.setpChoAn(pChoAn);
			j++;
			try {
				paperDao.getConn(server, db, user, pwd);
				if(paperDao.addChoiceQu(paper)==1) {                //�����ݿ�д��ѡ����
					out.print("���ѡ�����"+(i+1)+"��ɹ���<br/>");
				}
				else {
					out.print("���ѡ�����"+(i+1)+"��ʧ�ܣ�<br/>");
				}
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				paperDao.closeAll();                 //�ر�ȫ�����ݼ�������
			}
		}
		for(int i=0;i<_pFillShu;i++) {
			j++;
			paper.setpMun(j+"");
			String pFillQu=new String(request.getParameter("pfq"+i));           //��ȡ�������Ŀ
			String pFillAn=new String(request.getParameter("pfa"+i));           //��ȡ������
			paper.setpFillQu(pFillQu);           //���ø���ֵ
			paper.setpFillAn(pFillAn);
			try {
				paperDao.getConn(server, db, user, pwd);
				if(paperDao.addFillQu(paper)==1) {                //�����ݿ�д�������
					out.print("���������"+(i+1)+"��ɹ���<br/>");
				}
				else {
					out.print("���������"+(i+1)+"��ʧ�ܣ�<br/>");
				}
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				paperDao.closeAll();                 //�ر�ȫ�����ݼ�������
			}
		}
		out.print("<input type='hidden' name='pname' value='"+pName+"' />");
		out.print("<input type='submit' value='����½��Ծ�'  />");
		out.print("<input type='button' value='����˵�' onclick=\"location.href='tkmindex.jsp'\" /><br>");
		out.print("</form>");
	}

}
