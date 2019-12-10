package com.espotify.utilidades;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utilidades {
	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			System.out.println("Configuracion de Hibernate Cargada");
			System.out.println("Servicio de registro de Hibernate Realizado");
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Fallo la creacion de la factoria de sesiones inicial." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}
}