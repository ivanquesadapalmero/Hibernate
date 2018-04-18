package es.fpdual.hibernate.hibernate.pruebas;

import es.fpdual.hibernate.hibernate.modelo.EstadoCivil;
import es.fpdual.hibernate.hibernate.modelo.Persona;
import es.fpdual.hibernate.hibernate.repositorio.RepositorioPersona;

public class Pruebas {

	public static void main(String[] args) {

		System.out.println(crearPersona());
		// System.out.println(crearVehiculo());
		modificarPersona();
		eliminarPersona();
		modificarPersona2();
		// System.out.println(obtenerNombrePersona(1));

		// modificarVehiculo();
		// modificarVehiculo2(2);
		// eliminarVehiculo(2);

	}

	private static Integer crearPersona() {

		final Persona persona = new Persona();
		persona.setNombre("Iván");
		persona.setApellidos("Quesada");
		persona.setEdad(19);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setDni("00000000K");

		return RepositorioPersona.crearPersona(persona);
	}

	private static void modificarPersona() {
		RepositorioPersona.modificarPersona(1, "Iván");
	}

	private static void modificarPersona2() {
		final Persona persona2 = new Persona();
		persona2.setIdPersona(1);
		persona2.setNombre("Iván2");
		persona2.setApellidos("Quesada2");
		persona2.setEdad(192);
		persona2.setEstadoCivil(EstadoCivil.CASADO);
		persona2.setDni("00000000K");

		RepositorioPersona.modificarPersona(persona2);
	}

	private static void eliminarPersona() {
		RepositorioPersona.eliminarPersona(1);
	}

	// private static void consultaPersona(String nombre) {
	// final List<Persona> personas = RepositorioPersona.consulta(nombre);
	//
	// System.out.println();
	// }

	// private static Integer crearVehiculo() {
	//
	// final Vehiculo vehiculo = new Vehiculo();
	// vehiculo.setMatricula("0000AAA");
	// vehiculo.setPeso(1000);
	// vehiculo.setCombustible(Combustible.ELECTRICO);
	// vehiculo.setEmision('A');
	// vehiculo.setFechaMatriculacion(new Date());
	//
	// return RepositorioVehiculo.crearVehiculo(vehiculo);
	// }
	//
	// private static void modificarVehiculo() {
	// RepositorioVehiculo.modificarVehiculo(2, "2222aaa");
	// }
	//
	// private static void modificarVehiculo2(Integer idVehiculo) {
	// final Vehiculo vehiculo = new Vehiculo();
	// vehiculo.setIdVehiculo(idVehiculo);
	// vehiculo.setMatricula("0000BBB");
	// vehiculo.setPeso(2000);
	// vehiculo.setCombustible(Combustible.DIESEL);
	// vehiculo.setEmision('B');
	// vehiculo.setFechaMatriculacion(new Date());
	//
	// RepositorioVehiculo.modificarVehiculo(vehiculo);
	//
	// }
	//
	// private static void eliminarVehiculo(Integer idVehiculo) {
	//
	// RepositorioVehiculo.eliminarVehiculo(idVehiculo);
	//
	// }

}
