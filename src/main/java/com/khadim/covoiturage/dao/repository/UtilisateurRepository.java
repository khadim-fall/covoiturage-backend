package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UtilisateurRepositoryV1")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("select user from Utilisateur user where user.supprime = "+false)
    List<Utilisateur> getAll() ;
    @Query("SELECT user FROM Utilisateur user WHERE user.id = :identifier AND user.supprime = false")
    Utilisateur getById(@Param("identifier") Long identifier);
}
