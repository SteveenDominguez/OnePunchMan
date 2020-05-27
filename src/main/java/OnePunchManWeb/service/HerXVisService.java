package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.HeroeXVisita;
import OnePunchManWeb.repository.HerXVisRepository;

@Service
public class HerXVisService implements IHerXVisService {
	@Autowired
	HerXVisRepository hxv;
	
	@Override
	public List<HeroeXVisita> listarHXV() {
		// TODO Auto-generated method stub
		return hxv.findAll();
	}

	@Override
	public HeroeXVisita encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return hxv.findById(id);
	}

	@Override
	public void guardar(HeroeXVisita herxvis) {
		// TODO Auto-generated method stub
		hxv.save(herxvis);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		hxv.deleteById(id);
	}

	@Override
	public List<HeroeXVisita> listarHXVPorHeroe(int id_heroe) {
		// TODO Auto-generated method stub
		return hxv.findAllHXVByHeroe(id_heroe);
	}

	@Override
	public List<HeroeXVisita> listarHXVPorVisita(int id_visita) {
		// TODO Auto-generated method stub
		return hxv.findAllHXVByVisita(id_visita);
	}

}
