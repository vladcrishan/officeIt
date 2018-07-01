package com.vlad.officeIt.Utils;

import com.vlad.officeIt.model.Client;
import com.vlad.officeIt.strategy.rebate.RebateType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CsvFileHelperClient extends CsvFileHelper {

    public CsvFileHelperClient(String filePath) {
        super(filePath);
    }

    public List<Client> parseClients() {
        List<Client> clients = new ArrayList<>();
        List<String> lines = read();
        for (String cursor : lines) {
            String[] split = cursor.split(CsvFileHelper.COMMA_DELIMITER);
            clients.add(new Client(
                    Integer.parseInt(split[0]),
                    split[1],
                    Objects.requireNonNull(RebateType.getRebateByName(split[2]))));
        }
        return clients;
    }

    public void writeClientsToFile(List<Client> clients) {
        StringBuilder stringBuffer = new StringBuilder();
        for (Client cursor : clients) {
            stringBuffer.append(String.valueOf(cursor.getId()));
            stringBuffer.append(CsvFileHelper.COMMA_DELIMITER);
            stringBuffer.append(cursor.getName());
            stringBuffer.append(CsvFileHelper.COMMA_DELIMITER);
            stringBuffer.append(cursor.getRebateType().name());
        }

        write(stringBuffer.toString());
    }
}
