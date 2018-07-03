package com.vlad.officeIt.dao.client;

import com.vlad.officeIt.model.Client;

import java.util.List;
import java.util.Objects;

public interface ClientDao {
    void save(Client client) throws Exception;

    void save(List<Client> client) throws Exception;

    List<Client> getClients() throws Exception;

    default Client getClient(Integer id) throws Exception {
        List<Client> clients = getClients();
        for (Client cursor : clients) {
            if (Objects.equals(cursor.getId(), id)) {
                return cursor;
            }
        }

        throw new Exception("No Client with that id");
    }
}
