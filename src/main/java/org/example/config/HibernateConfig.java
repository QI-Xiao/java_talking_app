package org.example.config;

import org.example.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
    @Bean
    public SessionFactory getHibernateSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }
}
