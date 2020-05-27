package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.Visita;
import OnePunchManWeb.repository.VisitaRepository;

@Service
public class VisitaService implements IVisitaService {
	@Autowired
	VisitaRepository vis;
	
	@Override
	public List<Visita> listarVisitas() {
		// TODO Auto-generated method stub
		return vis.findAll();
	}

	@Override
	public Visita encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return vis.findById(id);
	}

	@Override
	public void guardar(Visita visita) {
		// TODO Auto-generated method stub
		vis.save(visita);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		vis.deleteById(id);
	}

	@Override
	public List<Visita> listarVisitasYComida() {
		// TODO Auto-generated method stub
		return vis.findAllFoodInVisit();
	}

	@Override
	public List<Visita> listarVisitasYHeroe() {
		// TODO Auto-generated method stub
		return vis.findAllHeroInVisit();
	}

}
