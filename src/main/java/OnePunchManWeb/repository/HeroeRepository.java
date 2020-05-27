package OnePunchManWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.Heroe;

@Repository
public interface HeroeRepository extends JpaRepository<Heroe, Integer> {
	Heroe findById(int id);
	List<Heroe> findByNombre(String nombre);
	
	@Query("select hero from Heroe hero, Visita vis, HeroeXVisita hxv where hero.ID=hxv.heroe and vis.ID=hxv.visita")
    List<Heroe> findAllHeroInVisit();
}