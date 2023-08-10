package org.settrade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.settrade.enumeration.TimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TimeModelDto {
    private String id;
    private int hour;
    private int minute;
    private TimeFormat format;
    private LocalDateTime created;


}
