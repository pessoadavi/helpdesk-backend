/*package com.projeto.backend.helpdesk.data;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jbdc.Driver"); // DEfine o caminho da classe do drive do MySQL que importei (pom.xml)
        dataSource.setUrl("jdbc:mysql://localhost:3306/dbhelpdesk"); // Define a URL do banco (eventoapp é o nome do banco)
        dataSource.setUsername("root"); // login de acesso do banco de dados 
        dataSource.setPassword("123123"); // senha de acesso ao bando de dados
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL); // Define qual banco de dados usaremos
        adapter.setShowSql(true); // Mostra todas a etapas de modificação dos dados
        adapter.setGenerateDdl(true); // Permite que o hibernate crie as tabelas automaticamente
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect"); // Define o dialeto a ser usado
        adapter.setPrepareConnection(true); // Permite que o hibernate preparar e se conectar automaticamente
        return adapter;
        
    }

}*/