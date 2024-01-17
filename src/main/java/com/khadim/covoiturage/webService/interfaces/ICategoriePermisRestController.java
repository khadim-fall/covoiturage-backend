package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.CategoriePermisDTO;
import com.khadim.covoiturage.dto.UtilisateurDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/categoriePermis")
public interface ICategoriePermisRestController {
    @PostMapping(path = Constants.APP_ROOT + "/categoriePermis/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Categorie de Permis", notes = "Cette API permet d'enregistrer un Categorie de Permis", response = CategoriePermisDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance CategoriePermis est enregistrée avec succés")
    })
    public CategoriePermisDTO save(@RequestBody CategoriePermisDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/categoriePermis/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un CategoriePermis", notes = "Cette API permet de mettre à jour un categorie permis", response = CategoriePermisDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance CategoriePermis est mise à jours")
    })
    public CategoriePermisDTO update(@RequestBody CategoriePermisDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/categoriePermis/all")
    @ApiOperation(value = "Lister les différents catégories de permis", notes = "Cette API permet de lister les différents catégories de permis existants dans la BD", responseContainer = "List<CategoriePermisDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des catégories de permis / Liste catégorie permis vide")
    })
    public List<CategoriePermisDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/categoriePermis/findById/{id}")
    @ApiOperation(value = "Charger un catègoriePermis par son ID", notes = "Cette API permet de charger un catègoriePermis par son ID", response = CategoriePermisDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance catègoriePermis existe dans la BD")
    })
    public CategoriePermisDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/categoriePermis/delete/{id}")
    @ApiOperation(value = "Supprimer un catégoriePermis", notes = "Cette API permet de supprimer un catégoriePermis par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance catégoriePermis est supprimèe / Non supprimée car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
