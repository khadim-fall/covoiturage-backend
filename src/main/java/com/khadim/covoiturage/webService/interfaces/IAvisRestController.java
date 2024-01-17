package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.AvisDTO;
import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/avis")
public interface IAvisRestController {
    @PostMapping(path = Constants.APP_ROOT + "/avis/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un avis", notes = "Cette API permet d'enregistrer un avis", response = AvisDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance avis est enregistrée avec succés")
    })
    public AvisDTO save(@RequestBody AvisDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/avis/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un Avis", notes = "Cette API permet de mettre à jour un Avis", response = AvisDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Avis est mise à jours")
    })
    public AvisDTO update(@RequestBody AvisDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/avis/all")
    @ApiOperation(value = "Lister les Avis", notes = "Cette API permet de lister les Avis existants dans la BD", responseContainer = "List<AvisDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des Aviss / Liste vide")
    })
    public List<AvisDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/avis/findById/{id}")
    @ApiOperation(value = "Charger un Avis par son ID", notes = "Cette API permet de charger un Avis par son ID", response = AvisDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Avis existe dans la BD")
    })
    public AvisDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/avis/delete/{id}")
    @ApiOperation(value = "Supprimer un Avis", notes = "Cette API permet de supprimer un Avis par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Avis est supprimè / Non supprimer car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
