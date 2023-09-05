package com.example.dagent.Services.ServicesImp;

import com.example.dagent.Entities.UnitTypes;
import com.example.dagent.Enum.FacilityType;
import com.example.dagent.Repositories.UnitTypeRepository;
import com.example.dagent.Services.UnitTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UnitTypesServiceImp implements UnitTypesService {

    @Autowired
    UnitTypeRepository unitTypeRepository;

    @Override
    public Page<UnitTypes> findUnitTypesByProjectId(int page, int limit, int id) {
        Page<UnitTypes> productPage = null;
        productPage = findByProjectIdAndFacilityTypeRaw(page, limit, id);
        return productPage;
    }

    @Override
    public UnitTypes addUnitTypes(UnitTypes unitTypes) {
        return unitTypeRepository.save(unitTypes);
    }


    public Page<UnitTypes> findByProjectIdAndFacilityTypeRaw(int page, int limit, int id) {
        Pageable pageable = PageRequest.of(page, limit);
        return unitTypeRepository.findAllByProjectId(id,pageable);
    }
}
