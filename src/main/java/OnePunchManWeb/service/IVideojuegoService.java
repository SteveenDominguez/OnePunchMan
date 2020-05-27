package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.Videojuego;

public interface IVideojuegoService {
	List<Videojuego> listarVideojuegos();
	Videojuego encontrarPorId(int id);
	void guardar(Videojuego videojuego);
	void eliminar(int id);
}
