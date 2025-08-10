package com.abelov.store.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
@Configuration
public class ElasticConfiguration extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {  // понятно, что это можно в application.yml прописать
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
    }


}
