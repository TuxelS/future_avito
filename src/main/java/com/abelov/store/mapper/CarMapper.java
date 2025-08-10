package com.abelov.store.mapper;

import com.abelov.store.document.CarDocument;
import com.abelov.store.entity.CarEntity;
import com.abelov.store.model.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description",source = "description")
    @Mapping(target = "status",source = "status")
    @Mapping(target = "color",source = "color")
    @Mapping(target = "manufactureYear",source = "manufactureYear")
    @Mapping(target = "carType",source = "carType")
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "engineType",source = "engineType")
    @Mapping(target = "carMileage",source = "carMileage")
    CarDTO toDto(CarEntity carEntity);

    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description",source = "description")
    @Mapping(target = "status",source = "status")
    @Mapping(target = "color",source = "color")
    @Mapping(target = "manufactureYear",source = "manufactureYear")
    @Mapping(target = "carType",source = "carType")
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "engineType",source = "engineType")
    @Mapping(target = "carMileage",source = "carMileage")
    CarDocument toDocument(CarEntity carEntity);
}
