package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class DeleteServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	StudentDao dao=new StudentDao();
	Student student=dao.deleteStudent(id);
	PrintWriter printWriter=resp.getWriter();
	if(student!=null) {
		printWriter.print("DATA DELETED SUCCESSFULLY");
	}else {
		printWriter.print("SORRY ID IS NOT PRESENT");
	}
	
	
	
	
}
}
