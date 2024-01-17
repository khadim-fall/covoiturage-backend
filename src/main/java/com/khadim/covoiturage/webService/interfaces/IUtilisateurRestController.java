package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.UtilisateurDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/utilisateurs")
public interface IUtilisateurRestController {
    @PostMapping(path = Constants.APP_ROOT + "/utilisateurs/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un user", notes = "Cette API permet d'enregistrer un utilisateur", response = UtilisateurDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance User est enregistrée avec succés")
    })
    public UtilisateurDTO save(@RequestBody UtilisateurDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/utilisateurs/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un utilisateur", notes = "Cette API permet de mettre à jour un utilisateur", response = UtilisateurDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Utilisateur est mise à jours")
    })
    public UtilisateurDTO update(@RequestBody UtilisateurDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/utilisateurs/all")
    @ApiOperation(value = "Lister les utilisateurs", notes = "Cette API permet de lister les utiliateurs existants dans la BD", responseContainer = "List<UtilisateurDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des utilisateurs / Liste vide")
    })
    public List<UtilisateurDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/utilisateurs/findById/{id}")
    @ApiOperation(value = "Charger un utilisateur par son ID", notes = "Cette API permet de charger un utilisateur par son ID", response = UtilisateurDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance user existe dans la BD")
    })
    public UtilisateurDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/utilisateurs/delete/{id}")
    @ApiOperation(value = "Supprimer un utiliateur", notes = "Cette API permet de supprimer un utilisateur par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance utilisateur est supprimè / Non supprimer car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
