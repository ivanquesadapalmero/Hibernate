package es.fpdual.hibernate.hibernate.pruebas;

import java.util.Date;
import java.util.List;

import es.fpdual.hibernate.hibernate.modelo.Cliente;
import es.fpdual.hibernate.hibernate.modelo.DetallePersona;
import es.fpdual.hibernate.hibernate.modelo.Direccion;
import es.fpdual.hibernate.hibernate.modelo.EstadoCivil;
import es.fpdual.hibernate.hibernate.modelo.Genero;
import es.fpdual.hibernate.hibernate.modelo.Persona;
import es.fpdual.hibernate.hibernate.modelo.Telefono;
import es.fpdual.hibernate.hibernate.repositorio.RepositorioCliente;
import es.fpdual.hibernate.hibernate.repositorio.RepositorioPersona;
import es.fpdual.hibernate.hibernate.repositorio.RepositorioUsuario;

public class Pruebas {

	public static void main(String[] args) {
		//
		crearPersona("00000000A", "persona");

		Persona persona = consultarPorCodigo(1);
		System.out.println(persona.getGenero());
		System.out.println(persona.getTelefonos());

		// crearCliente("11111111B", "cliente");

		// crearCliente("33333333B", "cliente2");
		//
		// modificarPersona(1, "PersonaModificada");
		// // modificarCliente();
		//
		// // consultaCliente("Iván", "Quesada", "%000%", EstadoCivil.CASADO,
		// "persona");
		// // consultaPersona("Iván", "Quesada", "%111%", EstadoCivil.CASADO,
		// "cliente");
		//
		// eliminarUsuario(1);
		// eliminarUsuario(2);
	}

	private static Integer crearPersona(String dni, String login) {

		final Persona persona = new Persona();
		persona.setNombre("Iván");
		persona.setApellidos("Quesada");
		persona.setEdad(19);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setDni(dni);
		persona.setLogin(login);
		persona.setFechaAlta(new Date());
		persona.setPassword("ivan");
		persona.setGenero(Genero.MASCULINO);

		final Direccion direccion1 = new Direccion();
		direccion1.setProvincia("Sevilla");
		direccion1.setCiudad("Écija");
		direccion1.setCodigoPostal("41420");
		direccion1.setCalle("Calle Metalurgia");
		direccion1.setNumero(2);
		// direccion1.setPersonas(Arrays.asList(persona));

		final Telefono telefono1 = new Telefono();
		telefono1.setNumero("999999999");
		telefono1.setPersona(persona);

		final Telefono telefono2 = new Telefono();
		telefono2.setNumero("888888888");
		telefono2.setPersona(persona);

		persona.añadirTelefono(telefono1);
		persona.añadirTelefono(telefono2);

		DetallePersona detalle1 = new DetallePersona();
		detalle1.setHijos(false);
		detalle1.setDeporte(true);
		detalle1.setMascota(true);

		persona.añadirTelefono(telefono1);
		persona.añadirDireccion(direccion1);
		persona.añadirTelefono(telefono2);

		persona.añadirDetalle(detalle1);

		return RepositorioPersona.crearPersona(persona);
	}

	private static Persona consultarPorCodigo(Integer codigo) {
		return RepositorioPersona.consultaPorCodigo(codigo);
	}

	private static Integer crearCliente(String dni, String login) {

		final Cliente cliente = new Cliente();
		cliente.setNombre("Iván");
		cliente.setApellidos("Quesada");
		cliente.setEdad(19);
		cliente.setEstadoCivil(EstadoCivil.CASADO);
		cliente.setDni(dni);
		cliente.setLogin(login);
		cliente.setFechaAlta(new Date());
		cliente.setPassword("ivan");

		return RepositorioCliente.crearCliente(cliente);
	}

	private static void modificarPersona(Integer idPersona, String nombre) {
		RepositorioPersona.modificarPersona(idPersona, nombre);
	}

	private static void modificarCliente() {
		RepositorioPersona.modificarPersona(2, "ClienteModificado");
	}

	// private static void modificarPersona2() {
	// final Persona persona2 = new Persona();
	// persona2.setIdPersona(1);
	// persona2.setNombre("Iván2");
	// persona2.setApellidos("Quesada2");
	// persona2.setEdad(192);
	// persona2.setEstadoCivil(EstadoCivil.CASADO);
	// persona2.setDni("00000000K");
	//
	// RepositorioPersona.modificarPersona(persona2);
	// }
	//
	private static void eliminarPersona() {
		RepositorioPersona.eliminarPersona(1);
	}

	private static void eliminarCliente() {
		RepositorioCliente.eliminarCliente(2);
	}

	private static void eliminarUsuario(Integer idUsuario) {
		RepositorioUsuario.eliminarUsuario(idUsuario);
	}

	private static void consultaPersona(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
			String login) {
		final List<Persona> personas = RepositorioPersona.consulta(nombre, apellidos, dni, estadoCivil, login);

		System.out.println(personas.size());
	}

	private static void consultaCliente(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
			String login) {
		final List<Persona> personas = RepositorioPersona.consulta(nombre, apellidos, dni, estadoCivil, login);

		System.out.println(personas.size());
	}

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
