package com.example.dagent.Repositories;

import com.example.dagent.Entities.StringListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StringListRepository extends JpaRepository<StringListEntity, Long> {
}
