package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.StudentCourse;
import util.HibernateUtil;
import org.hibernate.query.Query;


public class StudentCourseDAO {
	private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
  
    public void saveOrUpdate(StudentCourse studentCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
      
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(studentCourse);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public List<StudentCourse> getAllStudentCourses() {
        try (Session session = getSession()) {
            String hql = "FROM StudentCourse";
            Query<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
            return query.getResultList();
        }
    }
  
    // Other CRUD operations for StudentCourse entity
}