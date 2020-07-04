package org.jpm.deco.app;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.OracleDriver");
        dataSourceBuilder.url("jdbc:oracle:thin:@//localhost:1521/PRODDB");
        dataSourceBuilder.username("hrdb");
        dataSourceBuilder.password("hrdb");
        return dataSourceBuilder.build();
    }

}
