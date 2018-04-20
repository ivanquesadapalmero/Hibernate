package es.fpdual.hibernate.hibernate.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "A_AFI")
public class Aficion {

	@Id
	@Column(name = "AFI_ID")
	private int idAficion;

	@Column(name = "AFI_NOM", nullable = false)
	private String aficion;

	@ManyToMany(mappedBy = "aficiones")
	private List<Persona> personas;

	public Aficion() {
	}

	public int getIdAficion() {
		return idAficion;
	}

	public void setIdAficion(int idAficion) {
		this.idAficion = idAficion;
	}

	public String getAficion() {
		return aficion;
	}

	public void setAficion(String aficion) {
		this.aficion = aficion;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}
