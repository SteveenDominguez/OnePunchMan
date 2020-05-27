package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.HeroeXVisita;

public interface IHerXVisService {
	List<HeroeXVisita> listarHXV();
	HeroeXVisita encontrarPorId(int id);
	void guardar(HeroeXVisita herxvis);
	void eliminar(int id);
	List<HeroeXVisita> listarHXVPorHeroe(int id_heroe);
	List<HeroeXVisita> listarHXVPorVisita(int id_visita);
}
