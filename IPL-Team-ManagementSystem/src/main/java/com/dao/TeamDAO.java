package com.dao;

import com.entity.Team;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TeamDAO {
    public void saveTeam(Team team) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(team);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Team getTeam(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Team.class, name);
        }
    }

    public List<Team> getAllTeams() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Team", Team.class).list();
        }
    }
}
