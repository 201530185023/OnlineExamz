package dao;

import java.sql.SQLException;

import entity.Paper;

public class PaperDao extends DBOperPaper{             //SQL�㣬��Ҫ��Ÿ�SQL����
	public String[] BrowsePaperName() {              //��ȡ�����Ծ���
		String sql="SELECT paperName FROM paperQuestionNum";
		String[] result=new String[100];
		int i=0;
		try {
			rs=this.getResultSet(sql);
			while(rs.next()) {
				result[i]=rs.getString(1);
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ�������
	}
	
	public String[] BrowsePaperName(String pCategory) {              //��ȡ�����Ծ�������������
		String sql;
		if(pCategory.equals("all")) {
			sql="SELECT paperName FROM paperQuestionNum";
		}
		else {
			sql="SELECT paperName FROM paperQuestionNum WHERE paperNo LIKE '"+pCategory+"%'";
		}
		String[] result=new String[100];
		int i=0;
		try {
			rs=this.getResultSet(sql);
			while(rs.next()) {
				result[i]=rs.getString(1);
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ�������
	}
	
	public String[] getChoiceQuestions(String pname) {         //��ȡָ���Ծ�����ѡ������Ŀ
		String sql="SELECT title FROM paperQuestionNum,paperAnswer WHERE paperQuestionNum.paperNo=paperAnswer.paperNo AND paperName='"+pname+"' AND type=0";
		String[] result=new String[100];
		int i=0;
		try {
			rs=this.getResultSet(sql);
			while(rs.next()) {
				result[i]=rs.getString(1);
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ�������
	}
	
	public String[] getChoiceOp1(String pname) {         //��ȡָ���Ծ�����ѡ����Aѡ��
		String sql="SELECT op1 FROM paperQuestionNum,paperAnswer WHERE paperQuestionNum.paperNo=paperAnswer.paperNo AND paperName='"+pname+"' AND type=0";
		String[] result=new String[100];
		int i=0;
		try {
			rs=this.getResultSet(sql);
			while(rs.next()) {
				result[i]=rs.getString(1);
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ�������
	}
	
	public String[] getChoiceOp2(String pname) {         //��ȡָ���Ծ�����ѡ����Bѡ��
		String sql="SELECT op2 FROM paperQuestionNum,paperAnswer WHERE paperQuestionNum.paperNo=paperAnswer.paperNo AND paperName='"+pname+"' AND type=0";
		String[] result=new String[100];
		int i=0;
		try {
			rs=this.getResultSet(sql);
			while(rs.next()) {
				result[i]=rs.getString(1);
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ�������
	}
	
	public String[] getChoiceOp3(String pname) {         //��ȡָ���Ծ�����ѡ����Cѡ��
		String sql="SELECT op3 FROM paperQuestionNum,paperAnswer WHERE paperQuestionNum.paperNo=paperAnswer.paperNo AND paperName='"+pname+"' AND type=0";
		String[] result=new String[100];
		int i=0;
		try {
			rs=this.getResultSet(sql);
			while(rs.next()) {
				result[i]=rs.getString(1);
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ�������
	}
	
	public String[] getChoiceOp4(String pname) {         //��ȡָ���Ծ�����ѡ����Dѡ��
		String sql="SELECT op4 FROM paperQuestionNum,paperAnswer WHERE paperQuestionNum.paperNo=paperAnswer.paperNo AND paperName='"+pname+"' AND type=0";
		String[] result=new String[100];
		int i=0;
		try {
			rs=this.getResultSet(sql);
			while(rs.next()) {
				result[i]=rs.getString(1);
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ�������
	}
	
	public String[] getChoiceAnswers(String pname) {         //��ȡָ���Ծ�����ѡ�����
		String sql="SELECT answer FROM paperQuestionNum,paperAnswer WHERE paperQuestionNum.paperNo=paperAnswer.paperNo AND paperName='"+pname+"' AND type=0";
		String[] result=new String[100];
		int i=0;
		try {
			rs=this.getResultSet(sql);
			while(rs.next()) {
				result[i]=rs.getString(1);
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ�������
	}
	
	public String[] getFillQuestions(String pname) {         //��ȡָ���Ծ������������Ŀ
		String sql="SELECT title FROM paperQuestionNum,paperAnswer WHERE paperQuestionNum.paperNo=paperAnswer.paperNo AND paperName='"+pname+"' AND type=1";
		String[] result=new String[100];
		int i=0;
		try {
			rs=this.getResultSet(sql);
			while(rs.next()) {
				result[i]=rs.getString(1);
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ�������
	}
	
	public String[] getFillAnswers(String pname) {         //��ȡָ���Ծ�����������
		String sql="SELECT answer FROM paperQuestionNum,paperAnswer WHERE paperQuestionNum.paperNo=paperAnswer.paperNo AND paperName='"+pname+"' AND type=1";
		String[] result=new String[100];
		int i=0;
		try {
			rs=this.getResultSet(sql);
			while(rs.next()) {
				result[i]=rs.getString(1);
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ�������
	}
	
	public String getPaperNo(String pname) {            //��ȡ�Ծ����ƶ�Ӧ���Ծ���
		String sql="SELECT paperNo FROM paperQuestionNum WHERE paperName='"+pname+"'";
		String result=null;
		try {
			rs=this.getResultSet(sql);
			rs.next();
			result=rs.getString(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ���
	}
	
	public String getChoPoi(String pname) {            //��ȡ�Ծ����ƶ�Ӧ��ѡ�����ֵ
		String sql="SELECT choicePoint FROM paperQuestionNum WHERE paperName='"+pname+"'";
		String result=null;
		try {
			rs=this.getResultSet(sql);
			rs.next();
			result=rs.getString(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ���
	}
	
	public String getFillPoi(String pname) {            //��ȡ�Ծ����ƶ�Ӧ��������ֵ
		String sql="SELECT fillPoint FROM paperQuestionNum WHERE paperName='"+pname+"'";
		String result=null;
		try {
			rs=this.getResultSet(sql);
			rs.next();
			result=rs.getString(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;             //����һ���ַ���
	}
	
	public int addQuShu(Paper paper) {         //�����ݿ�д����������
		String sql="INSERT INTO paperQuestionNum (paperNo,paperName,choiceNum,choicePoint,fillNum,fillPoint) values(?,?,?,?,?,?)";
		String paperNo=paper.getpCategory()+paper.getpNo();
		String[] params=new String[] {paperNo,paper.getpName(),paper.getpChoShu(),paper.getpChoPoi(),paper.getpFillShu(),paper.getpFillPoi()};
		int result=this.executeUpdate(sql, params);
		return result;             //�������ݿ��������
	}
	
	public int addQuShu(Paper paper,String paperNo) {         //�����ݿ�ָ���Ծ�д����������
		String sql="INSERT INTO paperQuestionNum (paperNo,paperName,choiceNum,choicePoint,fillNum,fillPoint) values(?,?,?,?,?,?)";
		String[] params=new String[] {paperNo,paper.getpName(),paper.getpChoShu(),paper.getpChoPoi(),paper.getpFillShu(),paper.getpFillPoi()};
		int result=this.executeUpdate(sql, params);
		return result;             //�������ݿ��������
	}
	
	public int addChoiceQu(Paper paper) {         //�����ݿ�д��ѡ����
		String sql="INSERT INTO paperAnswer (paperNo,num,type,title,op1,op2,op3,op4,answer) values(?,?,?,?,?,?,?,?,?)";
		String paperNo=paper.getpCategory()+paper.getpNo();
		String[] params=new String[] {paperNo,paper.getpMun(),"0",paper.getpChoQu(),paper.getOp1(),paper.getOp2(),paper.getOp3(),paper.getOp4(),paper.getpChoAn()};
		int result=this.executeUpdate(sql, params);
		return result;             //�������ݿ��������
	}
	
	public int addChoiceQu(Paper paper,String paperNo) {         //�����ݿ�ָ���Ծ�д��ѡ����
		String sql="INSERT INTO paperAnswer (paperNo,num,type,title,op1,op2,op3,op4,answer) values(?,?,?,?,?,?,?,?,?)";
		String[] params=new String[] {paperNo,paper.getpMun(),"0",paper.getpChoQu(),paper.getOp1(),paper.getOp2(),paper.getOp3(),paper.getOp4(),paper.getpChoAn()};
		int result=this.executeUpdate(sql, params);
		return result;             //�������ݿ��������
	}
	
	public int addFillQu(Paper paper) {         //�����ݿ�д�������
		String sql="INSERT INTO paperAnswer (paperNo,num,type,title,answer) values(?,?,?,?,?)";
		String paperNo=paper.getpCategory()+paper.getpNo();
		String[] params=new String[] {paperNo,paper.getpMun(),"1",paper.getpFillQu(),paper.getpFillAn()};
		int result=this.executeUpdate(sql, params);
		return result;             //�������ݿ��������
	}
	
	public int addFillQu(Paper paper,String paperNo) {         //�����ݿ�ָ���Ծ�д�������
		String sql="INSERT INTO paperAnswer (paperNo,num,type,title,answer) values(?,?,?,?,?)";
		String[] params=new String[] {paperNo,paper.getpMun(),"1",paper.getpFillQu(),paper.getpFillAn()};
		int result=this.executeUpdate(sql, params);
		return result;             //�������ݿ��������
	}
	
	public int updateChoiceQu(Paper paper,String pno,int pmun) {         //�����ݿ����ѡ����
		String sql="UPDATE paperAnswer SET title=?,op1=?,op2=?,op3=?,op4=?,answer=? WHERE paperNo='"+pno+"' AND num="+pmun+"";
		String[] params=new String[] {paper.getpChoQu(),paper.getOp1(),paper.getOp2(),paper.getOp3(),paper.getOp4(),paper.getpChoAn()};
		int result=this.executeUpdate(sql, params);
		return result;             //�������ݿ��������
	}
	
	public int updateFillQu(Paper paper,String pno,int pmun) {         //�����ݿ���������
		String sql="UPDATE paperAnswer SET title=?,answer=? WHERE paperNo='"+pno+"' AND num="+pmun+"";
		String[] params=new String[] {paper.getpFillQu(),paper.getpFillAn()};
		int result=this.executeUpdate(sql, params);
		return result;             //�������ݿ��������
	}
	
	public boolean deletePaper(String pno) {              //ɾ�����ݿ���ָ���Ծ�ȫ��������
		String sql="DELETE FROM paperAnswer WHERE paperNo='"+pno+"'";
		String sql2="DELETE FROM paperQuestionNum WHERE paperNo='"+pno+"'";
		int result=this.executeUpdate(0,sql);
		int result2=this.executeUpdate(1,sql2);
		if(result>0&&result2>0) {
			return true;              //���������ѯ��ִ�гɹ�������true
		}
		else {
			return false;             //���򣬷���false
		}
	}
	
}
