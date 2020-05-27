package OnePunchManWeb.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="heroexvideojuego")
public class HeroeXVideojuego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String fecha;
	@JoinColumn(name = "ID_Ganador", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Heroe ganador;
	@JoinColumn(name = "ID_Perdedor", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Heroe perdedor;
	@JoinColumn(name = "ID_Videojuego", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Videojuego videojuego;
	public int getId() {
		return ID;
	}
	public void setId(int iD) {
		ID = iD;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getGanador() {
		return ganador.getNombre();
	}
	public void setGanador(Heroe ganador) {
		this.ganador = ganador;
	}
	public String getPerdedor() {
		return perdedor.getNombre();
	}
	public void setPerdedor(Heroe perdedor) {
		this.perdedor = perdedor;
	}
	public int getVideojuego() {
		return videojuego.getId();
	}
	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
	public HeroeXVideojuego(String fecha, Heroe ganador, Heroe perdedor, Videojuego videojuego) {
		super();
		this.fecha = fecha;
		this.ganador = ganador;
		this.perdedor = perdedor;
		this.videojuego = videojuego;
	}
	public HeroeXVideojuego() {
		super();
	}
	
	
}
