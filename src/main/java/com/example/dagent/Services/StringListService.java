package com.example.dagent.Services;

import com.example.dagent.Entities.StringListEntity;

import java.util.List;

public interface StringListService {
    public StringListEntity saveStringList(StringListEntity entity);
    public StringListEntity getStringListById(Long id);
}
