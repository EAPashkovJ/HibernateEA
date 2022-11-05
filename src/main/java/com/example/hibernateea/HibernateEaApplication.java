package com.example.hibernateea;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateEaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateEaApplication.class, args);

		SessionFactory sessionFactory = new Configuration()
				.configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.close();
		sessionFactory.close();
	}

}
