package OnePunchManWeb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.PatrocinadorXHeroe;

@Repository
public interface PatroXHeroRepository extends JpaRepository<PatrocinadorXHeroe, Integer> {
	PatrocinadorXHeroe findById(int id);
	@Query(value = "SELECT pxh.* from Patrocinador patro, PatrocinadorXHeroe pxh "
			+ "WHERE patro.ID= :idpatro AND patro.ID=pxh.ID_Patrocinador",
			nativeQuery = true)
	List <PatrocinadorXHeroe> findAllPXHByPatro(@Param("idpatro") int idpatro);
}
