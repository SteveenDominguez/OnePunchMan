package OnePunchManWeb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visita")
public class Visita {
	
	@Id
	private int ID;
	private String descripcion;
	private String Fecha;
	public int getId() {
		return ID;
	}
	public void setId(int iD) {
		ID = iD;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public Visita(int iD, String descripcion, String fecha) {
		super();
		ID = iD;
		this.descripcion = descripcion;
		Fecha = fecha;
	}
	public Visita() {
		super();
	}
	
	
	
		
}
