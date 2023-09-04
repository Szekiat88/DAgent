package com.example.dagent.Services;

import com.example.dagent.Entities.FacilityDistance;
import com.example.dagent.Enum.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface FacilityDistanceService {
    public FacilityDistance addFacilityDistance(FacilityDistance facilityDistance);

    FacilityDistance editFacilityDistance(FacilityDistance facilityDistance);

    void deleteFacilityDistanceById(Long id);

    Page<FacilityDistance> getRequestFilters(int page, int limit, String productName, Sort.Direction sortType);

    Optional<FacilityDistance> getFacilityDistanceById (Long id);

    Page<FacilityDistance> findByProjectIdAndFacilityType(int page, int limit, int id, FacilityType fd);



    }
