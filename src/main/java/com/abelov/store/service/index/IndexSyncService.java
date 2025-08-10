package com.abelov.store.service.index;

import com.abelov.store.document.CarDocument;
import com.abelov.store.entity.CarEntity;
import com.abelov.store.mapper.CarMapper;
import com.abelov.store.repository.elasticsearch.CarElasticsearchRepository;
import com.abelov.store.repository.jpa.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexSyncService {
    final private CarElasticsearchRepository carElasticsearchRepository;
    final private CarRepository carRepository;
    private final CarMapper carMapper;

    public void sync(){
        List<CarEntity> cars = carRepository.findAll();
        List<CarDocument> carsElastic = cars
                .stream()
                .map(carMapper::toDocument)
                .toList();
        carElasticsearchRepository.saveAll(carsElastic);
    }


}
