package com.project.endterm.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;


@Configuration
public class ConnectionConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driverClassName}")
    private String className;

    @Bean
    public EntityManagerFactory entityManagerFactory() throws URISyntaxException{
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.afterPropertiesSet();
        entityManagerFactoryBean.setPackagesToScan("com.project.endterm.model");
        entityManagerFactoryBean.setPersistenceUnitName("Persistence-generic-name");
        return entityManagerFactoryBean.getObject();
    }
    @Bean
    public DataSource dataSource() throws URISyntaxException {
        URI dbURI = new URI(System.getenv("DATABASE_URL"));
        String username = dbURI.getUserInfo().split(":")[0];
        String password = dbURI.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbURI.getHost() + ':' + dbURI.getPort() + dbURI.getPath();

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName("org.postgresql.Driver");
        return new HikariDataSource(config);
    }
}
