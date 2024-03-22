package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import model.Teacher;
import util.HibernateUtil;

public class TeacherDAO {
	private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
  
    public void saveOrUpdate(Teacher teacher) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
      
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(teacher);
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
    public boolean deleteTeacher(int teacherCode) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, teacherCode);
            if (teacher != null) {
                session.delete(teacher);
                transaction.commit();
                return true;
            }else {
                return false; // Teacher with the given ID not found
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
    public Teacher getTeacherByCode(int teacherCode) {
        try (Session session = getSession()) {
            return session.get(Teacher.class, teacherCode);
        }
    }
    

    public List<Teacher> getAllTeachers() {
        try (Session session = getSession()) {
            String hql = "FROM Teacher";
            Query<Teacher> query = session.createQuery(hql, Teacher.class);
            return query.getResultList();
        }
    }
    public String getAssistantTutorName(int teacherCode) {
        try (Session session = getSession()) {
            Teacher teacher = session.get(Teacher.class, teacherCode);
            if (teacher != null) {
                return teacher.getAssistantTutorName();
            } else {
                return ""; // Teacher with the given code not found
            }
        }
    }
    

    
  
    // Other CRUD operations for Teacher entity
}
