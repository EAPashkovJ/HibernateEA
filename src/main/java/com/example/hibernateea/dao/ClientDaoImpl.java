package com.example.hibernateea.dao;

import com.example.hibernateea.configuration.HibernateSessionFactoryUtil;
import com.example.hibernateea.model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDaoImpl implements ClientDao {
    private final Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    @Override
    public void save(Client client) {
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
    }

    @Override
    public void update(Client client) {
        Transaction transaction = session.beginTransaction();
        Client persistentInstance = session.load(Client.class, client.getId());
        persistentInstance.setPinCode(client.getPinCode());
        session.update(persistentInstance);
        transaction.commit();
    }

    @Override
    public void delete(Long id) {

        Transaction transaction = session.beginTransaction();
        Object persistentInstance = session.load(Client.class, id);
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        transaction.commit();
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
