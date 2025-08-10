package com.abelov.store;

import com.abelov.store.entity.CarEntity;
import com.abelov.store.mapper.CarMapper;
import com.abelov.store.mapper.CarMapperImpl;
import com.abelov.store.model.CarDTO;
import com.abelov.store.repository.jpa.CarRepository;
import com.abelov.store.repository.jpa.ItemRepository;
import com.abelov.store.repository.jpa.TransportRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@Import(CarMapperImpl.class)
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportAutoConfiguration(exclude = LiquibaseAutoConfiguration.class) // Отключаем Liquibase
public class RepositoryTests {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private  TransportRepository transportRepository;
    @Autowired
    private CarMapper carMapper;

    @Test
    @Transactional
    void saveCar()
    {
        try{
            Optional<List<CarEntity>> foundCar = carRepository.findByColor("Белый");
            List<CarDTO> carDTOList = new ArrayList<>();
            if (foundCar.isPresent()){
                carDTOList = foundCar.get()
                        .stream()
                        .map(carMapper::toDto)
                        .toList();
            }
            log.info(String.valueOf(carDTOList));

            //assertNotNull(foundCar);

        }
        catch (Exception e)
        {
            log.info("Провал..");
        }



    }

}
