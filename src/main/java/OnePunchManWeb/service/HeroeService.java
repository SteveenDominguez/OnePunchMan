package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.Heroe;
import OnePunchManWeb.repository.HeroeRepository;
@Service
public class HeroeService implements IHeroeService {
	@Autowired
	HeroeRepository hero;
	@Override
	public List<Heroe> listarHeroes() {
		// TODO Auto-generated method stub
		return hero.findAll();
	}

	@Override
	public Heroe encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return hero.findById(id);
	}

	@Override
	public List<Heroe> listarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return hero.findByNombre(nombre);
	}

	@Override
	public void guardar(Heroe heroe) {
		// TODO Auto-generated method stub
		hero.save(heroe);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		hero.deleteById(id);
	}

	@Override
	public List<Heroe> listarHeroesPorVisita() {
		// TODO Auto-generated method stub
		return hero.findAllHeroInVisit();
	}

}