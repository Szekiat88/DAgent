package com.example.dagent.Controllers;

import com.example.dagent.Entities.StringListEntity;
import com.example.dagent.Services.StringListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/string-list")
public class StringListController {

    private final StringListService service;

    @Autowired
    public StringListController(StringListService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StringListEntity> createStringList(@RequestBody StringListEntity entity) {
        StringListEntity savedEntity = service.saveStringList(entity);
        return ResponseEntity.ok(savedEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StringListEntity> getStringListById(@PathVariable Long id) {
        StringListEntity entity = service.getStringListById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}