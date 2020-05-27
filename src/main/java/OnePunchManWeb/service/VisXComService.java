package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.VisitaXComida;
import OnePunchManWeb.repository.VisXComRepository;

@Service
public class VisXComService implements IVisXComService {
	@Autowired
	VisXComRepository vxc;
	
	@Override
	public List<VisitaXComida> listarVisXCom() {
		// TODO Auto-generated method stub
		return vxc.findAll();
	}

	@Override
	public VisitaXComida encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return vxc.findById(id);
	}

	@Override
	public void guardar(VisitaXComida visxcom) {
		// TODO Auto-generated method stub
		vxc.save(visxcom);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		vxc.deleteById(id);
	}

	@Override
	public List<VisitaXComida> listarVXCPorComida(int id_comida) {
		// TODO Auto-generated method stub
		return vxc.findAllVXCByComida(id_comida);
	}

	@Override
	public List<VisitaXComida> listarVXCPorVisita(int id_visita) {
		// TODO Auto-generated method stub
		return vxc.findAllVXCByVisita(id_visita);
	}
}
