package com.example.dagent.Services;
import com.example.dagent.Entities.UnitTypes;
import com.example.dagent.Enum.FacilityType;
import org.springframework.data.domain.Page;

public interface UnitTypesService {

    Page<UnitTypes> findUnitTypesByProjectId(int page, int limit, int id);
    UnitTypes addUnitTypes (UnitTypes unitTypes);

    }
