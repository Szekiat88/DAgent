package com.example.dagent.Controllers;

import com.example.dagent.Entities.FacilityDistance;
import com.example.dagent.Entities.UnitTypes;
import com.example.dagent.Enum.FacilityType;
import com.example.dagent.Handler.ResponseHandler;
import com.example.dagent.Services.FacilityDistanceService;
import com.example.dagent.Services.UnitTypesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/c")
public class UnitTypesController {

    @Autowired
    private UnitTypesService unitTypesService;

    @PostMapping("/add")
    public ResponseEntity<Object> addFacilityDistance(@RequestBody @Valid UnitTypes unitTypes){
        try {
            UnitTypes addedUnitTypes = unitTypesService.addUnitTypes(unitTypes);
            return ResponseHandler.handleResponse("Successfully create products", HttpStatus.OK,addedUnitTypes);
        } catch (Exception e){
            System.out.println("Its error" + e);
            return ResponseHandler.handleResponse("Fail to create products", HttpStatus.BAD_REQUEST,e);
        }
    }


    @GetMapping
    public ResponseEntity<Object> findByProjectIdAndFacilityType(@RequestParam(required = false, defaultValue = "0") int page,
                                                       @RequestParam(required = false,defaultValue = "3") int limit,
                                                       @RequestParam(required = false) int id) {
        try {
            Page<UnitTypes> unitTypes = unitTypesService.findUnitTypesByProjectId(page, 3, id);
            return ResponseHandler.handleResponse("Successfully get facility distance", HttpStatus.OK,unitTypes);
        } catch (Exception e) {
            return ResponseHandler.handleResponse("ERROR",HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }



}
