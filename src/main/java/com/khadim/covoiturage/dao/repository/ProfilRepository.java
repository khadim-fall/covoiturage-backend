package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProfilRepositoryV1")
public interface ProfilRepository extends JpaRepository<Profil, Long> {
    @Query("select prf from Profil prf where prf.supprime = "+false)
    List<Profil> getAll() ;
    @Query("SELECT prf FROM Profil prf WHERE prf.id = :identifier AND prf.supprime = false")
    Profil getById(@Param("identifier") Long identifier);
}
