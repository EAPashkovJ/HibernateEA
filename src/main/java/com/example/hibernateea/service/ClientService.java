package com.example.hibernateea.service;

import com.example.hibernateea.dao.ClientDaoImpl;
import com.example.hibernateea.model.Client;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Objects;

@Service
public class ClientService {

    public ClientService() {
    }
    private ClientDaoImpl clientDao = new ClientDaoImpl();


    public void saveClient(String name, String surname, int cardNumber, int pinCode) {
        Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        client.setCardNumber(cardNumber);
        client.setPinCode(pinCode);
        clientDao.save(client);

    }

    public void deleteClient(Long id) {
        clientDao.delete(id);
    }

    public void updateClient(Long id, int pinCode) {
        Client clientBeUpdated = findById(id);
        clientBeUpdated.setPinCode(pinCode);
        clientDao.update(clientBeUpdated);
    }

    public List<Client> findAllClients() {
        return clientDao.findAll();
    }

    public Client findById(Long id) {

        return clientDao.findAll().stream()
                .filter(client1 -> Objects.equals(client1.getId(), id))
                .findAny()
                .orElse(null);
    }
}
