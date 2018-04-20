package es.fpdual.hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.fpdual.hibernate.hibernate.modelo.EstadoCivil;
import es.fpdual.hibernate.hibernate.modelo.Persona;
import es.fpdual.hibernate.hibernate.util.HibernateUtil;

public class RepositorioPersona {

	public static Integer crearPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(persona);

			sesion.getTransaction().commit();

			return idPersona;

		} catch (Exception e) {

			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(final Integer idPersona, final String nombre) {

		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Persona personaBBDD = (Persona) sesion
					.createQuery("from Usuario usuario where usuario.idUsuario = :identificador")
					.setParameter("identificador", idPersona).uniqueResult();

			personaBBDD.setNombre(nombre);

			sesion.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("Se ha producido un error al modificar la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

	// public static void modificarPersona(final Integer idPersona, final String
	// nombre) {
	//
	// final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
	//
	// try {
	// sesion.beginTransaction();
	//
	//
	// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
	// PER_ID = :identificador")
	// .setParameter("identificador", idPersona).uniqueResult();
	//
	// personaBBDD.setNombre(nombre);
	//
	// sesion.getTransaction().commit();
	//
	// } catch (Exception e) {
	//
	// System.out.println("Se ha producido un error al modificar la persona: " +
	// e.getMessage());
	// e.printStackTrace();
	// throw new RuntimeException(e);
	// } finally {
	// sesion.close();
	// }
	// }

	public static void modificarPersona(Persona persona) {

		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.saveOrUpdate(persona);

			sesion.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("Se ha producido un error al modificar la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

	public static void eliminarPersona(Integer idUsuario) {

		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Persona where usu_id = :identificador").setParameter("identificador", idUsuario)
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

	public static Persona consultaPorCodigo(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			return (Persona) sesion.createQuery("from Persona ").uniqueResult();

		} catch (Exception e) {
			System.out.println("Se ha producido un error" + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

	public static List<Persona> consulta(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
			String login) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Persona Where 1=1");
			if (!nombre.isEmpty()) {
				sb.append("and PER_NOM like :nombre");
			}
			if (!apellidos.isEmpty()) {
				sb.append("and PER_APE like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append("and PER_NOM like :nombre");
			}
			if (estadoCivil != null) {
				sb.append("and PER_ECV = estadoCivil");
			}
			if (!login.isEmpty()) {
				sb.append("and PER_LOG like :login");
			}

			final org.hibernate.query.Query<Persona> consulta = sesion.createQuery(sb.toString());

			if (!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}
			if (!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}
			if (!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}
			if (estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil.ordinal());
			}
			if (!login.isEmpty()) {
				consulta.setParameter("login", login);
			}

			return consulta.list();

		} catch (Exception e) {
			System.out.println("Se ha producido un error al obtener a la persona" + e.getMessage());
			sesion.getTransaction();
			throw new RuntimeException(e);
		} finally {
			sesion.close();

		}
	}

}
