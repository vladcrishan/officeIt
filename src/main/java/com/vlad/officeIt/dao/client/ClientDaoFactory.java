package com.vlad.officeIt.dao.client;

import com.vlad.officeIt.dao.client.implementations.CsvClientDao;
import com.vlad.officeIt.dao.client.implementations.DatabaseClientDao;

public class ClientDaoFactory {

    public ClientDao getClientDao(ClientDaoType clientDaoType) {

        if (clientDaoType == null) {
            return null;
        }

        switch (clientDaoType) {
            case DATABASE:
                return new DatabaseClientDao();
            case CSV:
                return new CsvClientDao();
        }

        return null;
    }
}
