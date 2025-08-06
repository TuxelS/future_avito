package com.abelov.store;

import com.abelov.store.entity.CarEntity;
import com.abelov.store.entity.ItemEntity;
import com.abelov.store.enums.CarTypeEnum;
import com.abelov.store.enums.EngineEnum;
import com.abelov.store.enums.StatusEnum;
import com.abelov.store.repository.CarRepository;
import com.abelov.store.repository.ItemRepository;
import com.abelov.store.repository.TransportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

@DataJpaTest
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

    @Test
    @Transactional
    @Commit
    void saveCar()
    {
        CarEntity carTest1 = new CarEntity(
                "test_owner_1",
                "Toyota Camry",
                StatusEnum.PUBLISHED,
                "2500000",
                "Отличное состояние, один хозяин",
                LocalDateTime.now(),
                LocalDateTime.now(),
                50000,
                "Черный",
                2018,
                "Toyota",
                "Япония",
                EngineEnum.PETROL,
                CarTypeEnum.Sedan);
        try{
            carRepository.save(carTest1);
            log.info("Успешное сохранение");
            //Optional<ItemEntity> foundCar = carRepository.findById(carTest1.getUuid());
            //assertNotNull(foundCar);

        }
        catch (Exception e)
        {
            log.info("Провал..");
        }

    }

}
