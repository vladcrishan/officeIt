package com.vlad.officeIt.dao.client.implementations;

import com.vlad.officeIt.Utils.CsvFileHelperClient;
import com.vlad.officeIt.dao.client.ClientDao;
import com.vlad.officeIt.model.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/*
    The csv file is stored in the resource folder and it's name is set in the application.properties file.
    In a production environment the csv storage path would be defined in the application.properties!
 */
@Controller
@Scope
public class CsvClientDao implements ClientDao {

    @Value("${clientdao.csv.filename}")
    private String csvFileName;
    private CsvFileHelperClient csvFileHelper;

    public CsvClientDao() {
        csvFileHelper = new CsvFileHelperClient(getClass().getClassLoader().getResource("clients.csv").getFile());
    }

    @Override
    public void save(Client client) {
        csvFileHelper.writeClientsToFile(new ArrayList<Client>() {{
            add(client);
        }});
    }

    @Override
    public void save(List<Client> clients) {
        csvFileHelper.writeClientsToFile(clients);
    }

    @Override
    public List<Client> getClients() {
        return csvFileHelper.parseClients();
    }

}
