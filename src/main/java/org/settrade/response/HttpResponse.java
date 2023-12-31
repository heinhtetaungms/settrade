package org.settrade.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class HttpResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "Asia/Rangoon")
    private Date timeStamp;
    private int httpResponse;
    private HttpStatus httpStatus;
    private String reason;
    private String message;

    public HttpResponse(int httpResponse, HttpStatus httpStatus, String reason, String message) {
        this.timeStamp = new Date();
        this.httpResponse = httpResponse;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
    }
}
