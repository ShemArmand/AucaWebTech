package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Course;
import util.HibernateUtil;

public class CourseDAO {
	private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
  
    public void saveOrUpdate(Course course) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
      
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(course);
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
    public boolean deleteCourse(int courseId) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);

            if (course != null) {
                session.delete(course);
                transaction.commit();
                return true;
            } else {
                return false; // Course with the given ID not found
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false; // Deletion failed
        } finally {
            session.close();
        }
    }
    
    public List<Course> getAllCourses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Course";
            Query<Course> query = session.createQuery(hql, Course.class);
            return query.getResultList();
        }
    }
    public Course getCourseById(int courseId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Course.class, courseId);
        }
    }
    

//    public List<Course> getCoursesByDepartmentAndSemester(Integer departmentId, String semesterId) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            String hql = "FROM Course c WHERE c.departmentId = :departmentId AND c.semesterId = :semesterId";
//            Query<Course> query = session.createQuery(hql, Course.class);
//            query.setParameter("departmentId", departmentId);
//            query.setParameter("semesterId", semesterId);
//            return query.getResultList();
//        }
//    }
//
//    public List<Course> getCoursesByStudent(Integer studentId) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            String hql = "SELECT FROM Course";
//            Query<Course> query = session.createQuery(hql, Course.class);
//            query.setParameter("studentId", studentId);
//            return query.getResultList();
//        }
//    }

    // Other CRUD operations for Course entity
}