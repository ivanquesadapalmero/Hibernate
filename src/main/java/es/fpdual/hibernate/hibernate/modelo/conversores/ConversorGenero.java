package es.fpdual.hibernate.hibernate.modelo.conversores;

import javax.persistence.AttributeConverter;

import es.fpdual.hibernate.hibernate.modelo.Genero;

public class ConversorGenero implements AttributeConverter<Genero, String> {

	@Override
	public String convertToDatabaseColumn(Genero genero) {
		return genero.getCodigo();
	}

	@Override
	public Genero convertToEntityAttribute(String generoBBDD) {

		return Genero.getEnumerado(generoBBDD);
	}

}
