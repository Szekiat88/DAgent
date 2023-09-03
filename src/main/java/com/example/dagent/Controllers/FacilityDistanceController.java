package com.example.dagent.Controllers;

import com.example.dagent.Entities.FacilityDistance;
import com.example.dagent.Entities.ProjectDetail;
import com.example.dagent.Handler.ResponseHandler;
import com.example.dagent.Services.FacilityDistanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/distance")
public class FacilityDistanceController {

    @Autowired
    private FacilityDistanceService facilityDistanceService;

    @PostMapping("/add")
    public ResponseEntity<Object> addFacilityDistance(@RequestBody @Valid FacilityDistance facilityDistance){
        try {
            FacilityDistance addFacilityDistance = facilityDistanceService.addFacilityDistance(facilityDistance);
            return ResponseHandler.handleResponse("Successfully create products", HttpStatus.OK,addFacilityDistance);
        } catch (Exception e){
            System.out.println("Its error" + e);
            return ResponseHandler.handleResponse("Fail to create products", HttpStatus.BAD_REQUEST,e);
        }
    }

    @PutMapping("/edit")
    public FacilityDistance editFacilityDistance(@RequestBody @Valid FacilityDistance facilityDistance){
        try {
            FacilityDistance editedfacilityDistance = facilityDistanceService.editFacilityDistance(facilityDistance);
            if(editedfacilityDistance!=null){
                System.out.println("Updated");
            } else {
                System.out.println("Nothing+");
            }
            facilityDistance = editedfacilityDistance;
        } catch (Exception e){
            System.out.println("Its error" + e);
        }
        return facilityDistance;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFacilityDistance(@PathVariable Long id){
        facilityDistanceService.deleteFacilityDistanceById(id);
    }

    @GetMapping
    public ResponseEntity<Object> getFacilityDistances(@RequestParam(required = false, defaultValue = "0") int page,
                                              @RequestParam(required = false,defaultValue = "3") int limit,
                                              @RequestParam(required = false) String productName,
                                              @RequestParam(required = false) Sort.Direction sortType) {
        try {
            Page<FacilityDistance> facilityDistance = facilityDistanceService.getRequestFilters(page, 3, productName, sortType);
            return ResponseHandler.handleResponse("Successfully get facility distance", HttpStatus.OK,facilityDistance);
        } catch (Exception e) {
            return ResponseHandler.handleResponse("ERROR",HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

}
