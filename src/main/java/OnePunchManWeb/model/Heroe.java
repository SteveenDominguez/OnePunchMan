package OnePunchManWeb.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.Nullable;

import OnePunchManWeb.model.Heroe;

@Entity
@Table(name="heroe") 
public class Heroe {
	@Id
	private int ID;
	private String nombre;
	private String rango;
	private String habilidad;
	private String residencia;
	private String telefono;
	private String tiene_celula;
	
	@JoinColumn(name = "id_Fan", nullable = true )
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@Nullable
	private  Heroe fan;

	public Heroe(int iD, String nombre, String rango, String habilidad, String residencia, String telefono,
			String tiene_celula, Heroe fan) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.rango = rango;
		this.habilidad = habilidad;
		this.residencia = residencia;
		this.telefono = telefono;
		this.tiene_celula = tiene_celula;
		this.fan = fan;
	}

	
	public Heroe() {
		super();
	}


	public int getId() {
		return ID;
	}

	public void setId(int id) {
		ID = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTiene_celula() {
		return tiene_celula;
	}

	public void setTiene_celula(String tiene_celula) {
		this.tiene_celula = tiene_celula;
	}

	public int getFan() {
		return fan.ID;
	}

	public void setFan(Heroe fan) {
		this.fan = fan;
	}
	
	
	

}