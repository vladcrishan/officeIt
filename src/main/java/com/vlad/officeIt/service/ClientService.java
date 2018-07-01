package com.vlad.officeIt.service;

import com.vlad.officeIt.dao.client.ClientDao;
import com.vlad.officeIt.dao.client.ClientDaoFactory;
import com.vlad.officeIt.dao.client.ClientDaoType;
import com.vlad.officeIt.model.Client;

import java.util.List;

public class ClientService {

    private ClientDao clientDao;

    public ClientService() {
        ClientDaoFactory clientDaoFactory = new ClientDaoFactory();
        clientDao = clientDaoFactory.getClientDao(ClientDaoType.DATABASE);
    }

    public List<Client> getClients() {
        return clientDao.getClients();
    }

    public void createClient() {
    }
}
