package es.fpdual.hibernate.hibernate.pruebas;

import java.util.List;

import es.fpdual.hibernate.hibernate.modelo.Aficion;
import es.fpdual.hibernate.hibernate.repositorio.RepositorioAficion;

public class PruebaCache {

	public static void main(String[] args) {

		consultarAficiones();
		consultarAficiones();
	}

	private static void consultarAficiones() {
		final List<Aficion> aficiones = RepositorioAficion.consultaAficiones();
		aficiones.stream().map(Aficion::getAficion).forEach(System.out::println);
	}

}
