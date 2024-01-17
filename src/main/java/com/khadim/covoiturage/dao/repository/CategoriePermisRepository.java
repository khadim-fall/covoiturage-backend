package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.CategoriePermis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CategoriePermisRepositoryV1")
public interface CategoriePermisRepository extends JpaRepository<CategoriePermis, Long> {
    @Query("select categPermi from CategoriePermis categPermi where categPermi.supprime = "+false)
    List<CategoriePermis> getAll() ;
    @Query("SELECT categPermi FROM CategoriePermis categPermi WHERE categPermi.id = :identifier AND categPermi.supprime = false")
    CategoriePermis getById(@Param("identifier") Long identifier);
}
