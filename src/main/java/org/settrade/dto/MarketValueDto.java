package org.settrade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.settrade.model.TimeModel;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MarketValueDto {
    private String id;
    private double set;
    private double value;
    private int luckyNumber;
    private TimeModel timeModel;
    private LocalDateTime created;
}
