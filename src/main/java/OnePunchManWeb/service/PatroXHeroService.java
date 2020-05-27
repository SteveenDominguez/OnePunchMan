package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.PatrocinadorXHeroe;
import OnePunchManWeb.repository.PatroXHeroRepository;
import OnePunchManWeb.repository.PatrocinadorRepository;

@Service
public class PatroXHeroService implements IPatroXHeroService {
	@Autowired
	PatroXHeroRepository pxh;
	
	@Override
	public List<PatrocinadorXHeroe> listarPatroXHero() {
		// TODO Auto-generated method stub
		return pxh.findAll();
	}

	@Override
	public PatrocinadorXHeroe encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return pxh.findById(id);
	}

	@Override
	public void guardar(PatrocinadorXHeroe patroxhero) {
		// TODO Auto-generated method stub
		pxh.save(patroxhero);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		pxh.deleteById(id);
	}

	@Override
	public List<PatrocinadorXHeroe> listarPXHPorPatrocinador(int idpatro) {
		// TODO Auto-generated method stub
		return pxh.findAllPXHByPatro(idpatro);
	}
}
