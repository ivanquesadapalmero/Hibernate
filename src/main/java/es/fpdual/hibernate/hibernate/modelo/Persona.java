package es.fpdual.hibernate.hibernate.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import es.fpdual.hibernate.hibernate.modelo.conversores.ConversorGenero;

@Entity
@Table(name = "A_PER")
public class Persona extends Usuario {

	@ManyToMany(cascade = { CascadeType.ALL })
	private List<Direccion> direcciones = new ArrayList<Direccion>();

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("numero")
	private List<Telefono> telefonos = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	private List<Aficion> aficiones = new ArrayList<>();

	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private DetallePersona detalle;

	@Column(name = "PER_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "PER_APE", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "PER_EDA", nullable = false)
	private Integer edad;

	@Column(name = "PER_ECV", nullable = false)
	@Enumerated
	private EstadoCivil estadoCivil;

	@Column(name = "PER_GEN", nullable = false)
	@Convert(converter = ConversorGenero.class)
	private Genero genero;

	public Persona() {
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public DetallePersona getDetalles() {
		return detalle;
	}

	public List<Aficion> getAficiones() {
		return aficiones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void añadirDireccion(Direccion direccion) {
		direcciones.add(direccion);
		direccion.getPersonas().add(this);
	}

	public void borrarDireccion(Direccion direccion) {
		direcciones.remove(direccion);
		direccion.getPersonas().remove(this);
	}

	public void añadirTelefono(Telefono telefono) {
		telefonos.add(telefono);
		telefono.setPersona(this);
	}

	public void eliminarTelefono(Telefono telefono) {
		telefonos.remove(telefono);
		telefono.setPersona(null);
	}

	public void añadirDetalle(DetallePersona detalle) {
		detalle.setPersona(this);
		this.detalle = detalle;
	}

	public void eliminarDetalle() {
		if (detalle != null) {
			detalle.setPersona(null);
			this.detalle = null;
		}
	}
}
