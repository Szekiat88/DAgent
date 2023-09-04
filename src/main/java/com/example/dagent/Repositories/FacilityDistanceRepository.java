package com.example.dagent.Repositories;
import com.example.dagent.Entities.FacilityDistance;
import com.example.dagent.Entities.ProjectDetail;
import com.example.dagent.Enum.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityDistanceRepository extends JpaRepository<FacilityDistance, Long> {
    Page<FacilityDistance> findByProjectIdAndAndFacilityType(int id, FacilityType ft, Pageable pageable);

}
