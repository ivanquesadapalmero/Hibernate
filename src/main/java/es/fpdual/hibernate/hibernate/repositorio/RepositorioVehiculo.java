package es.fpdual.hibernate.hibernate.repositorio;

import org.hibernate.Session;

import es.fpdual.hibernate.hibernate.modelo.Vehiculo;
import es.fpdual.hibernate.hibernate.util.HibernateUtil;

public class RepositorioVehiculo {

	public static Integer crearVehiculo(final Vehiculo vehiculo) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final Integer idVehiculo = (Integer) sesion.save(vehiculo);

			sesion.getTransaction().commit();

			return idVehiculo;

		} catch (Exception e) {

			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarVehiculo(final Integer idVehiculo, final String matricula) {

		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Update Vehiculo set veh_mat = :matricula WHERE veh_id = :identificador")
					.setParameter("matricula", matricula).setParameter("identificador", idVehiculo).executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("Se ha producido un error al modificar el vehiculo: " + e.getMessage());
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

	public static void modificarVehiculo(Vehiculo vehiculo) {

		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.saveOrUpdate(vehiculo);

			sesion.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("Se ha producido un error al modificar el vehiculo: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

	public static void eliminarVehiculo(Integer idVehiculo) {

		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Vehiculo where veh_id = :identificador")
					.setParameter("identificador", idVehiculo).executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("Se ha producido un error al modificar el vehiculo: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

}
