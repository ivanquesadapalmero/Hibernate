package es.fpdual.hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.fpdual.hibernate.hibernate.modelo.Cliente;
import es.fpdual.hibernate.hibernate.modelo.EstadoCivil;
import es.fpdual.hibernate.hibernate.modelo.Persona;
import es.fpdual.hibernate.hibernate.util.HibernateUtil;

public class RepositorioCliente {

	public static Integer crearCliente(final Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(cliente);

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

	public static void modificarCliente(final Integer idCliente, final String nombre) {

		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Update Cliente set cli_nom = :nombre WHERE usu_id = :identificador")
					.setParameter("nombre", nombre).setParameter("identificador", idCliente).executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("Se ha producido un error al modificar el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

	public static void modificarCliente(Cliente cliente) {

		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.saveOrUpdate(cliente);

			sesion.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("Se ha producido un error al modificar el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

	public static void eliminarCliente(Integer idCliente) {

		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Cliente where cli_id = :identificador").setParameter("identificador", idCliente)
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

	public static Persona consultaNombreCompleto(Integer idCliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			return (Persona) sesion.createQuery("from Cliente where cli_id = :idCliente")
					.setParameter("idCliente", idCliente).uniqueResult();

		} catch (Exception e) {
			System.out.println("Se ha producido un error" + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

	public static List<Cliente> consulta(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
			String login) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Cliente Where 1=1");
			if (!nombre.isEmpty()) {
				sb.append("and CLI_NOM like :nombre");
			}
			if (!apellidos.isEmpty()) {
				sb.append("and CLI_APE like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append("and CLI_NOM like :nombre");
			}
			if (estadoCivil != null) {
				sb.append("and CLI_ECV = estadoCivil");
			}
			if (!login.isEmpty()) {
				sb.append("and PER_LOG like :login");
			}

			final org.hibernate.query.Query<Cliente> consulta = sesion.createQuery(sb.toString());

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
			System.out.println("Se ha producido un error al obtener el cliente" + e.getMessage());
			sesion.getTransaction();
			throw new RuntimeException(e);
		} finally {
			sesion.close();

		}
	}

}
