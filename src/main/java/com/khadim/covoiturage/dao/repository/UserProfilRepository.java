package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.Profil;
import com.khadim.covoiturage.dao.model.UserProfil;
import com.khadim.covoiturage.dao.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserProfilRepositoryV1")
public interface UserProfilRepository extends JpaRepository<UserProfil, Long> {
    @Query("select usrPrf from UserProfil usrPrf where usrPrf.user.id = :#{#usr.id} and usrPrf.supprime = "+false)
    List<UserProfil> getUserProfilByUserRef(@Param("usr") Utilisateur usr);

    @Modifying
    @Query("UPDATE UserProfil usrPrf SET usrPrf.supprime = "+false +" WHERE usrPrf.user.id = :#{#usr.id} AND usrPrf.profil.id = :#{#prof.id}")
    void deleteByProfilAndUser(@Param("usr") Utilisateur usr, @Param("prof") Profil prof);

    @Query("select usrPrf from UserProfil usrPrf where usrPrf.supprime = "+false)
    List<UserProfil> getAll() ;
    @Query("SELECT usrPrf FROM UserProfil usrPrf WHERE usrPrf.id = :identifier AND usrPrf.supprime = false")
    UserProfil getById(@Param("identifier") Long identifier);
}
