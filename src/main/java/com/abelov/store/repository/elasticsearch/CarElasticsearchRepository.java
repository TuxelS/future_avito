package com.abelov.store.repository.elasticsearch;

import com.abelov.store.document.CarDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface CarElasticsearchRepository extends ElasticsearchRepository<CarDocument, UUID> {
}
