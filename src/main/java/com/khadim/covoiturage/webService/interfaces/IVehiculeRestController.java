package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/vehicules")
public interface IVehiculeRestController {
    @PostMapping(path = Constants.APP_ROOT + "/vehicules/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un vehicule", notes = "Cette API permet d'enregistrer un vehicule", response = VehiculeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Vehicule est enregistrée avec succés")
    })
    public VehiculeDTO save(@RequestBody VehiculeDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/vehicules/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un vehicule", notes = "Cette API permet de mettre à jour un vehicule", response = VehiculeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Vehicule est mise à jours")
    })
    public VehiculeDTO update(@RequestBody VehiculeDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/vehicules/all")
    @ApiOperation(value = "Lister les vehicules", notes = "Cette API permet de lister les vehicules existants dans la BD", responseContainer = "List<VehiculeDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des vehicules / Liste vide")
    })
    public List<VehiculeDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/vehicules/findByUserId/{id}")
    @ApiOperation(value = "Lister les vehicules suivant l'ID de l'utilisateur", notes = "Cette API permet de lister les vehicules existants dans la BD suivant l'ID de l'utilisateur", responseContainer = "List<VehiculeDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des vehicules / Liste vide")
    })
    public List<VehiculeDTO> findByUserId(@PathVariable(name = "id") Long id);

    @GetMapping(path = Constants.APP_ROOT + "/vehicules/findById/{id}")
    @ApiOperation(value = "Charger un vehicule par son ID", notes = "Cette API permet de charger un vehicule par son ID", response = VehiculeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance vehicule existe dans la BD")
    })
    public VehiculeDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/vehicules/delete/{id}")
    @ApiOperation(value = "Supprimer un vehicule", notes = "Cette API permet de supprimer un vehicule par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance vehicule est supprimè / Non supprimer car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
