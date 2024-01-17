package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.TypeTrajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TypeTrajetRepositoryV1")
public interface TypeTrajetRepository extends JpaRepository<TypeTrajet, Long> {
    @Query("select typTrajet from TypeTrajet typTrajet where typTrajet.supprime = "+false)
    List<TypeTrajet> getAll() ;
    @Query("SELECT typTrajet FROM TypeTrajet typTrajet WHERE typTrajet.id = :identifier AND typTrajet.supprime = false")
    TypeTrajet getById(@Param("identifier") Long identifier);
}
