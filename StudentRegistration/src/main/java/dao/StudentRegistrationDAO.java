package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.AcademicUnit;
import model.Course;
import model.Student;
import model.StudentRegistration;

import util.HibernateUtil;

public class StudentRegistrationDAO {
	private Session getSession() {
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    return sessionFactory.openSession();
	}
  
    public void saveOrUpdate(StudentRegistration studentRegistration) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
      
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(studentRegistration);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<StudentRegistration> getStudentRegistrationsBySemester(Integer semesterId) {
        try (Session session = getSession()) {
            String hql = "FROM StudentRegistration s WHERE s.semester.id = :semesterId";
            Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        }
    }
    public boolean deleteStudentRegistration(int studentRegistrationId) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            StudentRegistration studentRegistration = session.get(StudentRegistration.class, studentRegistrationId);
            if (studentRegistration != null) {
                session.delete(studentRegistration);
                transaction.commit();
                return true;
            } else {
                return false; // Student registration with the given ID not found
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
    
    public List<StudentRegistration> getAllStudentRegistrations() {
        try (Session session = getSession()) {
            String hql = "FROM StudentRegistration";
            Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
          
            return query.getResultList();
        }
    }

	public List<StudentRegistration> getStudentsByDepartmentAndSemester(Integer departmentId, Integer semesterId) {
		// TODO Auto-generated method stub
		try (Session session = getSession()) {
            String hql = "FROM StudentRegistration s WHERE s.academicUnit.id = :departmentId AND s.semester.id = :semesterId";
            Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
            query.setParameter("departmentId", departmentId);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        }
    
	}
	public List<StudentRegistration> getStudentsByCourseAndSemester(Integer courseId, Integer semesterId) {
	    try (Session session = getSession()) {
	        String hql = "SELECT sr FROM StudentRegistration sr JOIN FETCH sr.academicUnit au JOIN FETCH sr.semester s WHERE au.id = :courseId AND s.id = :semesterId";
	        Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
	        query.setParameter("courseId", courseId.intValue());
	        query.setParameter("semesterId", semesterId.intValue());
	        return query.getResultList();
	    }
	}
	public List<AcademicUnit> getCoursesByDepartmentAndSemester(int departmentId, int semesterId) {
	    try (Session session = getSession()) {
	        String hql = "SELECT DISTINCT sr.academicUnit FROM StudentRegistration sr " +
	                     "WHERE sr.academicUnit.academicType = :departmentType " +
	                     "AND sr.semester.id = :semesterId";

	        Query<AcademicUnit> query = session.createQuery(hql, AcademicUnit.class);
	        query.setParameter("departmentType", AcademicUnit.AcademicEnum.DEPARTMENT);
	        query.setParameter("semesterId", semesterId);

	        return query.getResultList();
	    }
	}
	
//	public List<StudentRegistration> getStudentsByCourseAndSemester(Long courseId, Long semesterId) {
//	    Session session = sessionFactory.getCurrentSession();
//	    String hql = "FROM StudentRegistration sr JOIN sr.academicUnit au JOIN sr.semester s WHERE au.id = :courseId AND s.id = :semesterId";
//	    Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
//	    query.setParameter("courseId", courseId);
//	    query.setParameter("semesterId", semesterId);
//	    return query.getResultList();
//	}
	
//	public List<StudentRegistration> getStudentsByCourseAndSemester(Integer courseId, Integer semesterId) {
//		// TODO Auto-generated method stub
//		try (Session session = getSession()) {
////			SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId
//            String hql = "FROM StudentRegistration sr JOIN sr.course c JOIN sr.semester s WHERE c.id = :courseId AND s.id = :semesterId";
//            Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
//            query.setParameter("courseId", courseId);
//            query.setParameter("semesterId", semesterId);
//            return query.getResultList();
//        }
//    
//	}
	public StudentRegistration getStudentRegistrationById(Integer studentRegistrationId) {
        try (Session session = getSession()) {
            return session.get(StudentRegistration.class, studentRegistrationId);
        }
    }

	public List<AcademicUnit> getAllCourses() {
        try (Session session = getSession()) {
            String hql = "FROM AcademicUnit";
            Query<AcademicUnit> query = session.createQuery(hql, AcademicUnit.class);
            return query.getResultList();
        }
    }
	public List<Course> getStudentCourses(int studentId) {
	    try (Session session = getSession()) {
	        String hql = "SELECT sr.course FROM StudentRegistration sr WHERE sr.student.id = :studentId";
	        Query<Course> query = session.createQuery(hql, Course.class);
	        query.setParameter("studentId", studentId);
	        return query.getResultList();
	    }
	}
}
