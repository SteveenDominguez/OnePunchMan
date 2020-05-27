package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.HeroeXVideojuego;

public interface IHerXVidService {
	List<HeroeXVideojuego> listarPartidas();
	HeroeXVideojuego encontrarPorId(int id);
	void guardar(HeroeXVideojuego herxpar);
	void eliminar(int id);
	List<HeroeXVideojuego> listarHXVPorVideojuego(int id_videojuego);
}
