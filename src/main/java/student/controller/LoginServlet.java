package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class LoginServlet extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
//	first im going to check whether this email is present in the database or not
//	to check  you want entire table here
	StudentDao dao=new StudentDao();
	List<Student> students=dao.getAllStudents();
	
//	now you are havoing entire table wioth you
//	now you want to check whether this email is present in the database
	
	boolean value=false;
	String dbpassword=null;
	
	for(Student student:students) {
		if(student.getEmail().equals(email)) {
			value=true;
			dbpassword=student.getPassword();
			break;
		}
	}
	if(value) {
//		value=true when email is present in the database
		if(password.equals(dbpassword)) {
//			perfect password
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("LOGIN SUCCESS");
		}else {
//			Invalid password 
//			login failed
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("Sorry Invalid Password");
		}	
	}else {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Sorry Invalid EMail");
	}

	
	
	
	
	
	
	
	
	
	
}

}
