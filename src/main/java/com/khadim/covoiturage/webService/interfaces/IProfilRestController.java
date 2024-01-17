package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.ProfilDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/profils")
public interface IProfilRestController {
    @PostMapping(path = Constants.APP_ROOT + "/profils/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un profil", notes = "Cette API permet d'enregistrer un profil", response = ProfilDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Profil est enregistrée")
    })
    public ProfilDTO save(@RequestBody ProfilDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/profils/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un profil", notes = "Cette API permet de mettre à jour un profil", response = ProfilDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Profil est mise à jours")
    })
    public ProfilDTO update(@RequestBody ProfilDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/profils/all")
    @ApiOperation(value = "Lister les profils", notes = "Cette API permet de lister les profils existants dans la BD", responseContainer = "List<ProfilDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des profils / Liste vide")
    })
    public List<ProfilDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/profils/findById/{id}")
    @ApiOperation(value = "Charger un profil par son ID", notes = "Cette API permet de charger un profil par son ID", response = ProfilDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance profil existe dans la BD")
    })
    public ProfilDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/profils/delete/{id}")
    @ApiOperation(value = "Supprimer un profil", notes = "Cette API permet de supprimer un profil par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance profil est supprimer / Non supprimer car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
