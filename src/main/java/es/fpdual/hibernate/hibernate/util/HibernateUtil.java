package es.fpdual.hibernate.hibernate.util;

import org.hibernate.SessionFactory;

public class HibernateUtil {

	private static SessionFactory miFactoria = construirSessionFactory();

	private static final SessionFactory construirSessionFactory() {
		try {
			return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Se ha producido un error obteniendo la factoria de sesiones: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static SessionFactory getMiFactoria() {
		return miFactoria;
	}

}
