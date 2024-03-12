package student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.w3c.dom.ElementTraversal;

import student.dto.Student;

public class StudentDao {
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("vinod").createEntityManager();
}

public void saveStudent(Student student) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
}

public List<Student> getAllStudents() {
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("Select s from Student s");
	return query.getResultList();
}

public Student getStudentByEmail(String email) {
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("Select s from Student s where s.email=?1");
	query.setParameter(1, email);
	 Student student=(Student) query.getSingleResult();
	 return student;
	
}

public Student findStudentById(int id) {
	EntityManager entityManager=getEntityManager();
	Student student=entityManager.find(Student.class, id);
	return student;
}

public Student deleteStudent(int id) {
	EntityManager entityManager=getEntityManager();
	Student student=entityManager.find(Student.class, id);
	if(student!=null) {
//		id is present so i can delete the data
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return  student;
	}else {
		return null;
	}
}

public Student updateStudent(int id, Student stu) {
	EntityManager entityManager=getEntityManager();
	Student dbStudent=entityManager.find(Student.class, id);
	if(dbStudent!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		stu.setId(id);
		entityManager.merge(stu);
		entityTransaction.commit();
		return stu;
		
	}else {
		return null;
	}
}

}
