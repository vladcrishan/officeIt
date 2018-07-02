package com.vlad.officeIt.service;

import com.vlad.officeIt.dao.client.ClientDao;
import com.vlad.officeIt.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientDao clientDao;

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> getClients() throws Exception {
        return clientDao.getClients();
    }

    public Client getClient(Integer id) throws Exception{
        return clientDao.getClient(id);
    }

}
