package com.abelov.store.document;

import com.abelov.store.enums.CarTypeEnum;
import com.abelov.store.enums.EngineEnum;
import com.abelov.store.enums.StatusEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;

@Data
@Document(indexName = "car", createIndex = true)
public class CarDocument {
    @Id
    @Field(type = FieldType.Keyword)  // отвечает за точные совпадение
    private UUID uuid;
    @Field(type = FieldType.Text)  //Отвечает за полнотекстовый поиск, разбивает на токены
    private String name;
    @Field(type = FieldType.Text)
    private String description;
    @Field(type = FieldType.Keyword)
    private StatusEnum status;
    @Field(type = FieldType.Keyword)
    private String color;
    @Field(type = FieldType.Keyword)
    private Integer manufactureYear;
    @Field(type = FieldType.Keyword)
    private String brand;
    @Field(type = FieldType.Keyword)
    private String manufactureCountry;
    @Field(type = FieldType.Keyword)
    private CarTypeEnum carType;
    @Field(type = FieldType.Keyword)
    private EngineEnum engineType;
    @Field(type = FieldType.Integer)
    private Integer carMileage;
}
