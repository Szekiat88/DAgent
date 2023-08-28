package com.example.dagent.Services.ServicesImp;

import com.example.dagent.Entities.StringListEntity;
import com.example.dagent.Repositories.StringListRepository;
import com.example.dagent.Services.StringListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StringListServiceImp implements StringListService {

    @Autowired
    private StringListRepository repository;



    public StringListEntity saveStringList(StringListEntity entity) {
        return repository.save(entity);

    }

    public StringListEntity getStringListById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
