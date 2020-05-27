package OnePunchManWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.Monstruo;
import OnePunchManWeb.model.Patrocinador;
@Repository
public interface MonstruoRepository extends JpaRepository<Monstruo, Integer> {
	Monstruo findById(int id);
	List<Monstruo> findByNombre(String nombre);
	
	}
