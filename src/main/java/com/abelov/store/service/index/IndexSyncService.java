package com.abelov.store.service.index;

import com.abelov.store.document.CarDocument;
import com.abelov.store.entity.CarEntity;
import com.abelov.store.mapper.CarMapper;
import com.abelov.store.repository.elasticsearch.CarElasticsearchRepository;
import com.abelov.store.repository.jpa.CarRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexSyncService {
    final private ElasticsearchOperations elasticsearchOperations;
    final private CarRepository carRepository;
    private final CarMapper carMapper;

    @PostConstruct
    public void initIndices(){
        try {
            updateOrCreateIndexIfNotExists(CarDocument.class);
            fillCarIndex();
        }
        catch (Exception e) {
            log.error("Произошла ошибка с индексированием эластика", e);
        }
    }

    private <T> void updateOrCreateIndexIfNotExists(Class<T> clazz) {
        IndexOperations indexOps = elasticsearchOperations.indexOps(clazz);
        if (!indexOps.exists()) {
            indexOps.create();  // создание пустого индекса
            indexOps.putMapping(clazz);  // добавляет схему полей
        }
        else {
            indexOps.putMapping(clazz);  // обновит схему полей
        }
    }

    // Заполнение индекса car
    private void fillCarIndex(){
        List<CarEntity> carsJpa = carRepository.findAll();
        List<CarDocument> carsElastic = carsJpa
                .stream()
                .map(carMapper::toDocument)
                .toList();
        elasticsearchOperations.save(carsElastic);
    }

}
