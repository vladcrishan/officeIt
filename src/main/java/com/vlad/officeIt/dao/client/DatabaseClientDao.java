package com.vlad.officeIt.dao.client;

import com.vlad.officeIt.model.Client;
import com.vlad.officeIt.strategy.rebate.RebateType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseClientDao implements ClientDao {

    // Hardcoded values
    List<Client> clients = new ArrayList<Client>() {{
        add(new Client(1, "Visma", RebateType.VOLUME));
        add(new Client(2, "Continental", RebateType.TIME_OF_YEAR));
        add(new Client(3, "E-spres-oh", RebateType.VOLUME));
        add(new Client(4, "Azets", RebateType.VOLUME));
        add(new Client(5, "New Haircut", RebateType.SPECIAL_DEAL));
        add(new Client(6, "Bluematrix", RebateType.SPECIAL_DEAL));
        add(new Client(7, "Everseen", RebateType.VOLUME));
        add(new Client(8, "Ness", RebateType.SPECIAL_DEAL));
        add(new Client(9, "Cmed", RebateType.VOLUME));
        add(new Client(10, "Deventure", RebateType.TIME_OF_YEAR));
    }};

    @Override
    public void save(Client client) throws Exception {
        // Simulate connection to database and execute insert query
        clients.add(client);
    }

    @Override
    public void save(List<Client> clients) throws Exception {
        // Simulate connection to database and execute insert query
        this.clients.addAll(clients);
    }

    @Override
    public List<Client> getClients() throws Exception {
        // Simulate connection to database and execute select query
        return clients;
    }
}
