package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.AcademicUnit;
import model.Course;
import model.CourseDefinition;
import model.Semester;
import model.Student;
import model.StudentCourse;
import model.StudentRegistration;
import model.Teacher;

//public class HibernateUtil {
//    private static SessionFactory sessionFactory;
//
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null || sessionFactory.isClosed()) {
//            try {
//                Configuration configuration = new Configuration();
//
//                // Load the Hibernate configuration from hibernate.cfg.xml
//                configuration.configure("src/main/resources/hibernate.cfg.xml");
//
//                // Add annotated classes
//                configuration.addAnnotatedClass(AcademicUnit.class);
//                configuration.addAnnotatedClass(Course.class);
//                configuration.addAnnotatedClass(CourseDefinition.class);
//                configuration.addAnnotatedClass(StudentCourse.class);
//                configuration.addAnnotatedClass(StudentRegistration.class);
//                configuration.addAnnotatedClass(Teacher.class);
//                configuration.addAnnotatedClass(Student.class);
//                configuration.addAnnotatedClass(Semester.class);
//
//                // Build the SessionFactory
//                sessionFactory = configuration.buildSessionFactory();
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw new ExceptionInInitializerError("SessionFactory initialization failed: " + e.getMessage());
//            }
//        }
//        return sessionFactory;
//    }
//}

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            try {
                Configuration configuration = new Configuration();

                // Load the Hibernate configuration from hibernate.cfg.xml
                configuration.configure("hibernate.cfg.xml");

                // Add annotated classes
                configuration.addAnnotatedClass(AcademicUnit.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(CourseDefinition.class);
                configuration.addAnnotatedClass(StudentCourse.class);
                configuration.addAnnotatedClass(StudentRegistration.class);
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Semester.class);

                // Build the SessionFactory
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}