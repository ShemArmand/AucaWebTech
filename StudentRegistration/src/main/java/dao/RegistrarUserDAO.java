package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import model.RegistrarUser;
import util.HibernateUtil;

public class RegistrarUserDAO {

    public void createRegistrarUser(RegistrarUser registrarUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(registrarUser);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public RegistrarUser getRegistrarUserById(int registrarId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        RegistrarUser registrarUser = session.get(RegistrarUser.class, registrarId);
        session.close();
        return registrarUser;
    }

    public void updateRegistrarUser(RegistrarUser registrarUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(registrarUser);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteRegistrarUser(RegistrarUser registrarUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(registrarUser);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
