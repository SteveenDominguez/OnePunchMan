package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.Visita;

public interface IVisitaService {
	List<Visita> listarVisitas();
	Visita encontrarPorId(int id);
	void guardar(Visita visita);
	void eliminar(int id);
	List<Visita> listarVisitasYComida();
	List<Visita> listarVisitasYHeroe();
}
