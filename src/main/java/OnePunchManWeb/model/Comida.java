package OnePunchManWeb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comida")
public class Comida {
	@Id
	private int ID;
	private String nombre;
	
	public int getId() {
		return ID;
	}
	public void setId(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Comida(int iD, String nombre) {
		super();
		ID = iD;
		this.nombre = nombre;
	}
	public Comida() {
		super();
	}
	
	
	
}
