package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.AcademicUnit;
import model.AcademicUnit.AcademicEnum;
import model.Semester;
import util.HibernateUtil;

public class AcademicUnitDAO {
	
	private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
  
  
    public void saveOrUpdate(AcademicUnit academicUnit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
      
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(academicUnit);
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
    
    
    public List<AcademicUnit> getAllAcademicUnits() {
        try (Session session = getSession()) {
            String hql = "FROM AcademicUnit";
            Query<AcademicUnit> query = session.createQuery(hql, AcademicUnit.class);
            return query.getResultList();
        }
    }
    public AcademicUnit getAcademicUnitById(int id) {
        try (Session session = getSession()) {
            return session.get(AcademicUnit.class, id);
        }
    }
    public boolean deleteAcademicUnit(int academicUnitId) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            AcademicUnit academicUnit = session.get(AcademicUnit.class, academicUnitId);
            if (academicUnit != null) {
                session.delete(academicUnit);
                transaction.commit();
                return true;
            } else {
                return false; // Academic unit with the given ID not found
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
    
    public void setAcademicType(int academicUnitId, AcademicEnum academicType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            AcademicUnit academicUnit = session.get(AcademicUnit.class, academicUnitId);

            if (academicUnit != null) {
                academicUnit.setAcademicType(academicType);
                session.update(academicUnit);

                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
    // Other CRUD operations for AcademicUnit entity
}
    public List<AcademicUnit> getAllParentUnits() {
        try (Session session = getSession()) {
            // Query to retrieve all academic units with no parent (i.e., parentUnit is null)
            String hql = "FROM AcademicUnit WHERE parentUnit IS NULL";
            Query<AcademicUnit> query = session.createQuery(hql, AcademicUnit.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateCoursesByDepartmentAndSemester(int departmentId, int semesterId, List<AcademicUnit> courses) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Delete existing entries for the department and semester
            String deleteQuery = "DELETE FROM coursesByDepartmentAndSemester WHERE departmentId = :departmentId AND semesterId = :semesterId";
            Query<?> deleteStatement = session.createQuery(deleteQuery)
                    .setParameter("departmentId", departmentId)
                    .setParameter("semesterId", semesterId);
            deleteStatement.executeUpdate();

            // Insert new entries for the department and semester
            String insertQuery = "INSERT INTO coursesByDepartmentAndSemester (departmentId, semesterId, courseId) VALUES (:departmentId, :semesterId, :courseId)";
            Query<?> insertStatement = session.createNativeQuery(insertQuery);
            for (AcademicUnit course : courses) {
                insertStatement.setParameter("departmentId", departmentId)
                        .setParameter("semesterId", semesterId)
                        .setParameter("courseId", course.getId());
                insertStatement.executeUpdate();
            }

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
    public List<AcademicUnit> getAllStudents() {
        try (Session session = getSession()) {
            String hql = "FROM AcademicUnit a WHERE a.academicType = :studentType";
            Query<AcademicUnit> query = session.createQuery(hql, AcademicUnit.class);
            query.setParameter("studentType", AcademicEnum.PROGRAMME); // Assuming 'PROGRAMME' represents the student type
            return query.getResultList();
        }
    }
    
}
