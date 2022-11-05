package com.example.hibernateea.dao;

import com.example.hibernateea.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao {


    void save(Client client);

    void update(Client client);

    void delete(Client client);

    List <Client> findAll();
}
