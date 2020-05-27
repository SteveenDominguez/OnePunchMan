package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.Comida;
import OnePunchManWeb.repository.ComidaRepository;

@Service
public class ComidaService implements IComidaService {
	@Autowired
	ComidaRepository com;
	@Override
	public List<Comida> listarComidas() {
		// TODO Auto-generated method stub
		return com.findAll();
	}

	@Override
	public Comida encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return com.findById(id);
	}

	@Override
	public void guardar(Comida comida) {
		// TODO Auto-generated method stub
		com.save(comida);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		com.deleteById(id);
	}

	@Override
	public List<Comida> listarComidasPorVisita() {
		// TODO Auto-generated method stub
		return com.findAllFoodInVisit();
	}

}
