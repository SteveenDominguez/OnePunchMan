package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.Heroe;


public interface IHeroeService {
	List<Heroe> listarHeroes();
	Heroe encontrarPorId(int id);
	List<Heroe> listarPorNombre(String nombre);
	void guardar(Heroe heroe);
	void eliminar(int id);
	List<Heroe> listarHeroesPorVisita();
}