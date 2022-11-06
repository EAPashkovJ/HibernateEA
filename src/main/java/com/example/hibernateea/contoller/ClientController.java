package com.example.hibernateea.contoller;

import com.example.hibernateea.model.Client;
import com.example.hibernateea.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Show list of Clients
     */
    @GetMapping("/show")
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }

    /**
     * Create new Client of Bank
     *
     * @param name       name
     * @param surname    surname
     * @param cardNumber card number client
     * @param pinCode    pin code of card
     */
    @PostMapping("/save")
    public void clientSavetoDB(@RequestParam(value = "name") String name,
                               @RequestParam(value = "surname") String surname,
                               @RequestParam(value = "cardNumber") Integer cardNumber,
                               @RequestParam(value = "pinCode") Integer pinCode) {

        clientService.saveClient(name, surname, cardNumber, pinCode);
    }

    /**
     * Delete client of bank by ID
     */
    @PostMapping("/delete/{id}")
    public void deleteClientById(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    /**
     * Update client param
     */
    @PostMapping("/update/{id}")
    public void updateClientPinCode(@PathVariable("id") Long id,
                                    @RequestParam(value = "pinCode") int pinCode) {

        clientService.updateClient(id, pinCode);

    }

    /**
     * Find client by ID
     *
     * @param id id client for search
     * @return Client
     */
    @GetMapping("/show/{id}")
    public Client findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

}

