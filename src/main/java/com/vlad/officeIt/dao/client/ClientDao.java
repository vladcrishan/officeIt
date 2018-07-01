package com.vlad.officeIt.dao.client;

import com.vlad.officeIt.model.Client;

import java.util.List;

public interface ClientDao {
    void save(Client client);

    void save(List<Client> client);

    List<Client> getClients();
}
