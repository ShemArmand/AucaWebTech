package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Semester;
import model.Student;
import model.StudentRegistration;
import util.HibernateUtil;

public class SemesterDAO {
	
	private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
  
    public void saveOrUpdate(Semester semester) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
      
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(semester);
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
  
    
    public List<Semester> getAllSemesters() {
        try (Session session = getSession()) {
            String hql = "FROM Semester";
            Query<Semester> query = session.createQuery(hql, Semester.class);
            return query.getResultList();
        }
    }
    public Semester getSemesterById(int id) {
        try (Session session = getSession()) {
            return session.get(Semester.class, id);
        }
    }

    public boolean deleteSemester(int semesterId) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Semester semester = session.get(Semester.class, semesterId);
            if (semester != null) {
                session.delete(semester);
                transaction.commit();
                return true;
            } else {
                return false; // Semester with the given ID not found
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
    // Other CRUD operations for Semester entity
}
