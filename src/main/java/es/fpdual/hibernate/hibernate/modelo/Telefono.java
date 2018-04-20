package es.fpdual.hibernate.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "Telefono")
public class Telefono {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miSecuencia")
	@SequenceGenerator(name = "miSecuencia", sequenceName = "miSecuenciaBBDD", initialValue = 1, allocationSize = 5)
	@Column(name = "TEL_ID")
	private long id;

	@Column(name = "numero")
	private String numero;

	@ManyToOne
	private Persona persona;

	public Telefono() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
