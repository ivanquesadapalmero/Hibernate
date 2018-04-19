package es.fpdual.hibernate.hibernate.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "A_USU")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "USU_ID")
	private int idUsuario;

	@Column(name = "USU_LOG", nullable = false, unique = true)
	private String login;

	@Column(name = "USU_PAS", nullable = false)
	private String password;

	@Column(name = "USU_FEC", nullable = false)
	private Date fechaAlta;

	public Usuario() {
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}
