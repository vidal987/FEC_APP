package br.com.fec.FecApp.Config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//public class DbConfig {
//
//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//                .type(com.zaxxer.hikari.HikariDataSource.class)
//                .url("jdbc:postgresql://localhost:5432/postgres")
//                .username("admin")
//                .password("admin")
//                .build();
//    }
//}