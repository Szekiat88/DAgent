package com.example.dagent.Services.ServicesImp;

import com.example.dagent.Entities.FacilityDistance;
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
        Page<FacilityDistance> productPage = null;
        if(productName==null && sortType==null){
            productPage = getDistanceFacilityList(page, limit);
        }
        if(productName!=null && sortType==null){

        }
        return productPage;
    }

    @Override
    public Optional<FacilityDistance> getFacilityDistanceById(Long id) {
        return Optional.empty();
    }

    private Page<FacilityDistance> getDistanceFacilityList(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return distanceRepository.findAll(pageable);
    }

}
