package es.fpdual.hibernate.hibernate.modelo;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class DetallePersona {

	@Id
	@GeneratedValue
	private long id;

	private Boolean hijos;

	private Boolean deporte;

	private Boolean mascota;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona")
	private Persona persona;

	public DetallePersona() {
	}

	public Boolean getHijos() {
		return hijos;
	}

	public void setHijos(Boolean hijos) {
		this.hijos = hijos;
	}

	public Boolean getDeporte() {
		return deporte;
	}

	public void setDeporte(Boolean deporte) {
		this.deporte = deporte;
	}

	public Boolean getMascota() {
		return mascota;
	}

	public void setMascota(Boolean mascota) {
		this.mascota = mascota;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona phone) {
		this.persona = phone;
	}
}
