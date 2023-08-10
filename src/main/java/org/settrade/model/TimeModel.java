package org.settrade.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.settrade.enumeration.TimeFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document
public class TimeModel {
    @Id
    private String id;
    private int hour;
    private int minute;
    private TimeFormat format;
    private LocalDateTime created;

    public TimeModel(int hour, int minute, TimeFormat format, LocalDateTime created) {
        this.hour = hour;
        this.minute = minute;
        this.format = format;
        this.created = created;
    }
}
