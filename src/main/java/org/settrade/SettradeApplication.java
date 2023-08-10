package org.settrade;

import org.modelmapper.ModelMapper;
import org.settrade.dto.MarketValueDto;
import org.settrade.mapper.GenericMapper;
import org.settrade.model.MarketValue;
import org.settrade.model.TimeModel;
import org.settrade.service.MarketValueService;
import org.settrade.service.TimeModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;

@SpringBootApplication
public class SettradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SettradeApplication.class, args);
    }
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    CommandLineRunner runner(TimeModelService timeModelService, MarketValueService marketValueService, GenericMapper mapper) {
        return args -> {
            /*TimeModel model1 = new TimeModel(12, 1, TimeFormat.AM, LocalDateTime.now());
            timeModelService.save(model1);

            MarketValue value1 = new MarketValue(100.0, 200.0, 69, model1, LocalDateTime.now());
            marketValueService.save(value1);

            TimeModel model2 = new TimeModel(4, 30, TimeFormat.PM, LocalDateTime.now());
            timeModelService.save(model2);

            MarketValue value2 = new MarketValue(400.0, 560.0, 30, model2, LocalDateTime.now());
            marketValueService.save(value2);


            TimeModel model1 = timeModelService.findById("64d4a6cdc6c052171b030db0");
            TimeModel model2 = timeModelService.findById("64d4a6cdc6c052171b030db2");
            MarketValue value1 = new MarketValue(100.0, 200.0, 69, model1, LocalDateTime.now());
            marketValueService.save(mapper.mapToDTO(value1, MarketValueDto.class));
            MarketValue value2 = new MarketValue(400.0, 560.0, 30, model2, LocalDateTime.now());
            marketValueService.save(mapper.mapToDTO(value2, MarketValueDto.class));
            */

            marketValueService.findMarketValuesByTimeModelId("64d4a6cdc6c052171b030db2")
                    .stream().forEach(System.out::println);


        };
    }
}
