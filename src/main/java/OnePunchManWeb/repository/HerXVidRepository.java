package OnePunchManWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.HeroeXVideojuego;

@Repository
public interface HerXVidRepository extends JpaRepository<HeroeXVideojuego, Integer> {
	HeroeXVideojuego findById(int id);
	@Query(value = "SELECT hxv.* from  Videojuego vid, HeroeXVideojuego hxv "
			+ "WHERE vid.ID= :idvideo AND vid.ID=hxv.ID_Videojuego",
			nativeQuery = true)
	List <HeroeXVideojuego> findAllHXVByVideojuego(@Param("idvideo") int idvideo);
}
