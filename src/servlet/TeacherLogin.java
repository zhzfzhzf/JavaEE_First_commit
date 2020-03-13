package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.Mario;


public class TeacherLogin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Mario mario=new Mario();
		HttpSession session = null;

		request.setCharacterEncoding("UTF-8");
	     String Ausername=(String)request.getParameter("username");
	     
	   //�޸ı��ַ���
	   	String username = new String(Ausername.getBytes("ISO-8859-1"),"UTF-8");
	     
	   //���ݿ����
	     String sql="select * from teacher";//�����ѯ���
	     ResultSet rs=mario.executeQuery(sql);//ִ��sql���
	     //ֻ�ж�һ������
	     try {
			if(rs.next())
			 {
			     if(username.equals(rs.getObject("teacherNum"))){
			    	 //����session
			    	 session.setAttribute("myState","teacher");
			     }
			     else{
			    	 response.sendRedirect(request.getContextPath()+"/jsp/success.jsp?");
			     }
			 }else{
				 //���ݿ�û����ʱ
			 }
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			
	     mario.closeConnection();
	}

}
