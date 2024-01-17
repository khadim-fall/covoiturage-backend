package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.TrajetDTO;
import com.khadim.covoiturage.dto.TypeTrajetDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/trajets")
public interface ITrajetRestController {
    @PostMapping(path = Constants.APP_ROOT + "/trajets/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un  de Trajet", notes = "Cette API permet d'enregistrer un  de Trajet", response = TrajetDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Trajet est enregistrée avec succés")
    })
    public TrajetDTO save(@RequestBody TrajetDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/trajets/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un  de Trajet", notes = "Cette API permet de mettre à jour un  de Trajet", response = TrajetDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Trajet est mise à jours")
    })
    public TrajetDTO update(@RequestBody TrajetDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/trajets/all")
    @ApiOperation(value = "Lister les  de trajets", notes = "Cette API permet de lister les s de trajets existants dans la BD", responseContainer = "List<TrajetDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des s de trajets / Liste vide")
    })
    public List<TrajetDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/trajets/findById/{id}")
    @ApiOperation(value = "Charger un  de Trajet par son ID", notes = "Cette API permet de charger un  de Trajet par son ID", response = TrajetDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Trajet existe dans la BD")
    })
    public TrajetDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/trajets/delete/{id}")
    @ApiOperation(value = "Supprimer un Trajet", notes = "Cette API permet de supprimer un  de Trajet par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Trajet est supprimè / Non supprimer car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
