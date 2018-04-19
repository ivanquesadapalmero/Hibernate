package es.fpdual.hibernate.hibernate.repositorio;

import org.hibernate.Session;

import es.fpdual.hibernate.hibernate.util.HibernateUtil;

public class RepositorioUsuario {

	public static void eliminarUsuario(Integer idUsuario) {

		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Usuario where usu_id = :identificador").setParameter("identificador", idUsuario)
					.executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("Se ha producido un error al modificar la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

}
