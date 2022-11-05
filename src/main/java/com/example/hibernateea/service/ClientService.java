package com.example.hibernateea.service;

import com.example.hibernateea.dao.ClientDaoImpl;
import com.example.hibernateea.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    public ClientService() {
    }

    private ClientDaoImpl clientDao = new ClientDaoImpl();


    public void saveClient(Client client) {
        clientDao.save(client);
    }

    public void deleteClient(Client client) {
        clientDao.delete(client);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public List<Client> findAllClients() {
        return clientDao.findAll();
    }
}
