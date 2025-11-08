package com.dao;

import com.entity.Player;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlayerDAO {
    public void savePlayer(Player player) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(player);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Player getPlayerByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Player WHERE name = :name", Player.class)
                          .setParameter("name", name)
                          .uniqueResult();
        }
    }

    public void updatePlayer(Player player) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(player);
            transaction.commit();
        }
    }

    public void deletePlayer(Player player) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(player);
            transaction.commit();
        }
    }
}
