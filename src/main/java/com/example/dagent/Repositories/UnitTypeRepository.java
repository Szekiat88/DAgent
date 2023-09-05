package com.example.dagent.Repositories;
import com.example.dagent.Entities.UnitTypes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitTypeRepository extends JpaRepository<UnitTypes, Long> {
    Page<UnitTypes> findAllByProjectId(int projectId, Pageable pageable);
}
