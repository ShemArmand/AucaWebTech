package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import model.CourseDefinition;
import util.HibernateUtil;

public class CourseDefinitionDAO {

	private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
  
    public void saveOrUpdate(CourseDefinition courseDefinition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
      
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(courseDefinition);
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
    public boolean deleteCourseDefinition(int id) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            CourseDefinition courseDefinition = session.get(CourseDefinition.class, id);

            if (courseDefinition != null) {
                session.delete(courseDefinition);
                transaction.commit();
                return true; // Deletion successful
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return false; // Deletion failed
    }
    public CourseDefinition getCourseDefinitionById(int id) {
        try (Session session = getSession()) {
            return session.get(CourseDefinition.class, id);
        }
    }
    public List<CourseDefinition> getAllCourseDefinitions() {
        try (Session session = getSession()) {
            String hql = "FROM CourseDefinition";
            Query<CourseDefinition> query = session.createQuery(hql, CourseDefinition.class);
            return query.list();
        }
    }
    
  
    
    // Other CRUD operations for CourseDefinition entity
}
