package com.example.hibernateea.dao;

import com.example.hibernateea.component.HibernateSessionFactoryUtil;
import com.example.hibernateea.model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao{


    @Override
    public void save(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }


    @Override
    public void update(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Client client) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.delete(client);
    session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> findAll() {
        return (List<Client>)
                HibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("From Client ").list();
    }
}