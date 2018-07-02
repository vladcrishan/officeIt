package com.vlad.officeIt.dao.client;

import com.vlad.officeIt.utils.FileHelper;
import com.vlad.officeIt.model.Client;
import com.vlad.officeIt.strategy.rebate.RebateType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
    The csv file is stored in the resource folder and it's name is set in the application.properties file.
    In a production environment the csv storage path would be defined in the application.properties!
 */
@Component
public class CsvClientDao implements ClientDao {

    @Override
    public void save(Client client) throws Exception {
        writeClientsToFile(new ArrayList<Client>() {{
            add(client);
        }});
    }

    @Override
    public void save(List<Client> clients) throws Exception {
        writeClientsToFile(clients);
    }

    @Override
    public List<Client> getClients() throws Exception {
        return parseClients();
    }

    private String getFileName() {
        return getClass().getClassLoader().getResource("storage/clients.csv").getFile();
    }

    private List<Client> parseClients() throws Exception {
        List<Client> clients = new ArrayList<>();
        List<String> lines = FileHelper.read(getFileName());
        for (String cursor : lines) {
            String[] split = cursor.split(FileHelper.COMMA_DELIMITER);
            clients.add(new Client(
                    Integer.parseInt(split[0]),
                    split[1],
                    Objects.requireNonNull(RebateType.getRebateByName(split[2]))));
        }
        return clients;
    }

    private void writeClientsToFile(List<Client> clients) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        for (Client cursor : clients) {
            stringBuilder.append(String.valueOf(cursor.getId()));
            stringBuilder.append(FileHelper.COMMA_DELIMITER);
            stringBuilder.append(cursor.getName());
            stringBuilder.append(FileHelper.COMMA_DELIMITER);
            stringBuilder.append(cursor.getRebateType().name());
        }
        FileHelper.write(getFileName(), stringBuilder.toString());
    }
}
