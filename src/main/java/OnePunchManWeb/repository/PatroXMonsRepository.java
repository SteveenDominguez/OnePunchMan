package OnePunchManWeb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.PatrocinadorXHeroe;
import OnePunchManWeb.model.PatrocinadorXMonstruo;

@Repository
public interface PatroXMonsRepository extends JpaRepository<PatrocinadorXMonstruo, Integer> {
	PatrocinadorXMonstruo findById(int id);
	@Query(value = "SELECT pxm.* from Patrocinador patro, PatrocinadorXMonstruo pxm "
			+ "WHERE patro.ID= :idpatro AND patro.ID=pxh.ID_Monstruo",
			nativeQuery = true)
	List <PatrocinadorXMonstruo> findAllPXHByPatro(@Param("idpatro") int idpatro);
}
