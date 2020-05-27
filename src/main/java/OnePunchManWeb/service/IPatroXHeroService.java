package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.PatrocinadorXHeroe;

public interface IPatroXHeroService {
	List<PatrocinadorXHeroe> listarPatroXHero();
	PatrocinadorXHeroe encontrarPorId(int id);
	void guardar(PatrocinadorXHeroe patroxhero);
	void eliminar(int id);
	List<PatrocinadorXHeroe> listarPXHPorPatrocinador(int idpatro);
}
