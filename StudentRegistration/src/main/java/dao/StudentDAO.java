package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Student;
import util.HibernateUtil;
import org.hibernate.query.Query;

public class StudentDAO {
    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public void saveOrUpdate(Student student) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(student);
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
    public boolean deleteStudent(int studentId) {
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
                transaction.commit();
                return true;
            } else {
                return false; // Student with the given ID not found
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
    public Student getStudentById(int studentId) {
        try (Session session = getSession()) {
            return session.get(Student.class, studentId);
        }
    }

    public List<Student> getStudentsBySemester(String semesterId) {
        try (Session session = getSession()) {
            String hql = "FROM Student s WHERE s.semester = :semesterId";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        }
    }
    
    public List<Student> getAllStudents() {
        try (Session session = getSession()) {
            String hql = "FROM Student";
            Query<Student> query = session.createQuery(hql, Student.class);
            return query.getResultList();
        }
    }

	public List<Student> getStudentsByDepartmentAndSemester(Integer departmentId, String semesterId) {
		// TODO Auto-generated method stub
		try (Session session = getSession()) {
            String hql = "FROM Student s WHERE s.department = :departmentId AND s.semester.id = :semesterId";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("departmentId", departmentId);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        }
    
	}

	public List<Student> getStudentsByCourseAndSemester(String courseId, String semesterId) {
		// TODO Auto-generated method stub
		try (Session session = getSession()) {
            String hql = "SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("courseId", courseId);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        }
    
	}
}