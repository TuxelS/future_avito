package com.abelov.store.controller;

import com.abelov.store.service.index.IndexSyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/index")
@RequiredArgsConstructor
public class IndexController {
    final private IndexSyncService indexSyncService;

    @PostMapping(value = "/fullCars")
    public ResponseEntity<String> indexCars(){
        try{
            indexSyncService.sync();
            return ResponseEntity.ok("Индексация машин прошла успешно");
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError()
                    .body("Ошибка при индексации машин");
        }
    }
}
