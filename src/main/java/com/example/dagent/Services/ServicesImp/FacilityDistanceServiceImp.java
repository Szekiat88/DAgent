package com.example.dagent.Services.ServicesImp;

import com.example.dagent.Entities.FacilityDistance;
import com.example.dagent.Entities.ProjectDetail;
import com.example.dagent.Enum.FacilityType;
import com.example.dagent.Repositories.FacilityDistanceRepository;
import com.example.dagent.Services.FacilityDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityDistanceServiceImp implements FacilityDistanceService {

    @Autowired
    private FacilityDistanceRepository distanceRepository;

    @Override
    public FacilityDistance addFacilityDistance(FacilityDistance facilityDistance) {
        return distanceRepository.save(facilityDistance);
    }

    @Override
    public FacilityDistance editFacilityDistance(FacilityDistance facilityDistance) {
        boolean exist = distanceRepository.existsById(facilityDistance.getId());
        if (exist){
            return distanceRepository.save(facilityDistance);
        }
        return null;
    }

    @Override
    public void deleteFacilityDistanceById(Long id) {
        distanceRepository.deleteById(id);
    }

    @Override
    public Page<FacilityDistance> getRequestFilters(int page, int limit, String productName, Sort.Direction sortType) {
        return null;
    }

    @Override
    public Page<FacilityDistance> findByProjectIdAndFacilityType(int page, int limit, int id, FacilityType fd) {
        Page<FacilityDistance> productPage = null;
        productPage = findByProjectIdAndFacilityTypeRaw(page, limit, id, fd);
        return productPage;
    }

    @Override
    public Optional<FacilityDistance> getFacilityDistanceById(Long id) {
        return distanceRepository.findById(id);
    }

    public Page<FacilityDistance> findByProjectIdAndFacilityTypeRaw(int page, int limit, int id, FacilityType ft) {
        Pageable pageable = PageRequest.of(page, limit);
        return distanceRepository.findByProjectIdAndAndFacilityType(id,ft,pageable);
    }


    private Page<FacilityDistance> getDistanceFacilityList(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return distanceRepository.findAll(pageable);
    }

}
