package es.fpdual.hibernate.hibernate.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEH")
public class Vehiculo implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "VEH_ID")
	private int idVehiculo;

	@Column(name = "VEH_MAT", nullable = false, length = 7, unique = true)
	private String matricula;

	@Column(name = "VEH_FMA", nullable = false)
	private Date fechaMatriculacion;

	@Column(name = "VEH_PES", nullable = false)
	private int peso;

	@Column(name = "VEH_EMI", nullable = false, length = 1)
	private char emision;

	@Column(name = "VEH_COM", nullable = false)
	private Combustible combustible;

	public Vehiculo() {
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	public void setFechaMatriculacion(Date fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public char getEmision() {
		return emision;
	}

	public void setEmision(char emision) {
		this.emision = emision;
	}

	public Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}

}
