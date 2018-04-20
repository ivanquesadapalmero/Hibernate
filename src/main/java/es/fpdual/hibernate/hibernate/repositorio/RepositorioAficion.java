package es.fpdual.hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.fpdual.hibernate.hibernate.modelo.Aficion;
import es.fpdual.hibernate.hibernate.util.HibernateUtil;

public class RepositorioAficion {

	public static List<Aficion> consultaAficiones() {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			return sesion.createQuery("from Aficion").setCacheable(true).list();

		} catch (Exception e) {
			System.out.println("Se ha producido un error" + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

}
