package OnePunchManWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.Combate;
import OnePunchManWeb.model.Patrocinador;

@Repository
public interface CombateRepository extends JpaRepository<Combate, Integer> {
	Combate findById(int id);
	List<Combate> findByFecha(String fecha);
	
	@Query(value = "SELECT comba.* from Combate comba, Heroe hero, CombateXHeroe cxh "
			+ "WHERE hero.ID= :idheroe AND hero.ID=cxh.ID_Heroe AND comba.ID=cxh.ID_Combate",
			nativeQuery = true)
	List <Combate> findAllCombateByHero(@Param("idheroe") int idheroe);
	
	@Query(value = "SELECT comba.* from Combate comba, Monstruo mons, CombateXMonstruo cxm "
			+ "WHERE mons.ID= :idmonstruo AND mons.ID=cxm.ID_Monstruo AND comba.ID=cxm.ID_Combate",
			nativeQuery = true)
	List <Combate> findAllCombateByMons(@Param("idmonstruo") int idmonstruo);
	
	}
