package com.vlad.officeIt;

import com.vlad.officeIt.dao.client.ClientDao;
import com.vlad.officeIt.dao.client.DatabaseClientDao;
import com.vlad.officeIt.dao.product.CsvProductDao;
import com.vlad.officeIt.dao.product.DatabaseProductDao;
import com.vlad.officeIt.dao.product.ProductDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ClientDao clientDao() {
        return new DatabaseClientDao();
    }

    @Bean
    public ProductDao productDao() {
        return new CsvProductDao();
    }

}
