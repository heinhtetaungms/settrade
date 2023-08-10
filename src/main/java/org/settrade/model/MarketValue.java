package org.settrade.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document
public class MarketValue {
    @Id
    private String id;
    private double set;
    private double value;
    private int luckyNumber;
    private TimeModel timeModel;
    private LocalDateTime created;

    public MarketValue(double set, double value, int luckyNumber, TimeModel timeModel, LocalDateTime created) {
        this.set = set;
        this.value = value;
        this.luckyNumber = luckyNumber;
        this.timeModel = timeModel;
        this.created = created;
    }
}
