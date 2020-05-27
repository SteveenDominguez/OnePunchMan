package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.CombateXHeroe;
import OnePunchManWeb.repository.CombaXHeroRepository;


@Service
public class CombaXHeroService implements ICombaXHeroService {
	@Autowired
	CombaXHeroRepository cxh;
	
	@Override
	public List<CombateXHeroe> listarCombateXHeroes() {
		// TODO Auto-generated method stub
		return cxh.findAll();
	}

	@Override
	public CombateXHeroe encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return cxh.findById(id);
	}

	@Override
	public void guardar(CombateXHeroe combaxhero) {
		// TODO Auto-generated method stub
		cxh.save(combaxhero);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		cxh.deleteById(id);
	}

	@Override
	public List<CombateXHeroe> listarCXHPorCombate(int idcomba) {
		// TODO Auto-generated method stub
		return cxh.findAllCXHByCombate(idcomba);
	}
}
