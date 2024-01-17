package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.TypeTrajetDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/typeTrajets")
public interface ITypeTrajetRestController {
    @PostMapping(path = Constants.APP_ROOT + "/typeTrajets/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un type de Trajet", notes = "Cette API permet d'enregistrer un type de Trajet", response = TypeTrajetDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance TypeTrajet est enregistrée avec succés")
    })
    public TypeTrajetDTO save(@RequestBody TypeTrajetDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/typeTrajets/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un type de Trajet", notes = "Cette API permet de mettre à jour un type de Trajet", response = TypeTrajetDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Trajet est mise à jours")
    })
    public TypeTrajetDTO update(@RequestBody TypeTrajetDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/typeTrajets/all")
    @ApiOperation(value = "Lister les type de Trajets", notes = "Cette API permet de lister les types de Trajets existants dans la BD", responseContainer = "List<TypeTrajetDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des types de Trajets / Liste vide")
    })
    public List<TypeTrajetDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/typeTrajets/findById/{id}")
    @ApiOperation(value = "Charger un type de Trajet par son ID", notes = "Cette API permet de charger un type de Trajet par son ID", response = TypeTrajetDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance TypeTrajet existe dans la BD")
    })
    public TypeTrajetDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/typeTrajets/delete/{id}")
    @ApiOperation(value = "Supprimer un TypeTrajet", notes = "Cette API permet de supprimer un type de Trajet par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance TypeTrajet est supprimè / Non supprimer car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
