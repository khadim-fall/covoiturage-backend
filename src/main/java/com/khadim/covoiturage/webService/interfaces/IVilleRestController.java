package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.VilleDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/villes")
public interface IVilleRestController {
    @PostMapping(path = Constants.APP_ROOT + "/villes/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Ville", notes = "Cette API permet d'enregistrer un Ville", response = VilleDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Ville est enregistrée avec succés")
    })
    public VilleDTO save(@RequestBody VilleDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/villes/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un Ville", notes = "Cette API permet de mettre à jour un Ville", response = VilleDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Ville est mise à jours")
    })
    public VilleDTO update(@RequestBody VilleDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/villes/all")
    @ApiOperation(value = "Lister les villes", notes = "Cette API permet de lister les villes existants dans la BD", responseContainer = "List<VilleDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des villes / Liste vide")
    })
    public List<VilleDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/villes/findById/{id}")
    @ApiOperation(value = "Charger un Ville par son ID", notes = "Cette API permet de charger un Ville par son ID", response = VilleDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Ville existe dans la BD")
    })
    public VilleDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/villes/delete/{id}")
    @ApiOperation(value = "Supprimer un Ville", notes = "Cette API permet de supprimer un Ville par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Ville est supprimè / Non supprimer car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
