package org.example;

import org.example.dao.StudentDaoImpl;
import org.example.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.example.dao")
public class AppConfig {

    private final Environment env;

    public AppConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {
        System.out.println("DB Driver: " + env.getProperty("db.driver"));
        System.out.println("DB URL: " + env.getProperty("db.url"));
        System.out.println("DB User: " + env.getProperty("db.username"));
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(Objects.requireNonNull(env.getProperty("db.driver")));
        ds.setUrl(env.getProperty("db.url"));
        ds.setUsername(env.getProperty("db.username"));
        ds.setPassword(env.getProperty("db.password"));
        return ds;
    }

    @Bean
    public SessionFactory sessionFactory() {
        Properties props = new Properties();
        props.put("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "true");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(props)
                .applySetting("hibernate.connection.datasource", dataSource())
                .build();

        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Student.class)
                .getMetadataBuilder()
                .build();

        return metadata.getSessionFactoryBuilder().build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public StudentDaoImpl studentDao(SessionFactory sessionFactory) {
        return new StudentDaoImpl(sessionFactory);
    }
}
