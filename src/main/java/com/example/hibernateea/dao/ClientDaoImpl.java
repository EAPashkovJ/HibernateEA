package com.example.hibernateea.dao;

import com.example.hibernateea.configuration.HibernateSessionFactoryUtil;
import com.example.hibernateea.model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    @Override
    public void save(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        // load cоздает proxy объект и тут то я с ним работаю
        // я победил баг с обновлением пинкода, я молодец
        Client persistentInstance = session.load(Client.class, client.getId());
        persistentInstance.setPinCode(client.getPinCode());
        session.update(persistentInstance);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Object persistentInstance = session.load(Client.class, id);
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        transaction.commit();
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
