package OnePunchManWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.Patrocinador;
@Repository
public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Integer> {
	Patrocinador findById(int id);
	List<Patrocinador> findByNombre(String nombre);
	
	@Query(value = "SELECT patro.* from Patrocinador patro, Heroe hero, PatrocinadorXHeroe pxh "
			+ "WHERE hero.ID= :idheroe AND hero.ID=pxh.ID_Heroe AND patro.ID=pxh.ID_Patrocinador",
			nativeQuery = true)
	List <Patrocinador> findAllPatrocinadorByHero(@Param("idheroe") int idheroe);
	
	@Query(value = "SELECT patro.* from Patrocinador patro, Monstruo mons, PatrocinadorXMonstruo pxm "
			+ "WHERE mons.ID= :idmonstruo AND mons.ID=pxm.ID_Monstruo AND patro.ID=pxm.ID_Patrocinador",
			nativeQuery = true)
	List <Patrocinador> findAllPatrocinadorByMons(@Param("idmonstruo") int idmonstruo);
	}
