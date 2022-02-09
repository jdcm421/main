package com.retotecnico.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseDTO {
    
    private Object data;
    private String message;
    private String error;

    public ResponseDTO(Object data, String message) {
        this.data = data;
        this.message = message;
    }

    public ResponseDTO(String message, String error) {
        this.message = message;
        this.error = error;
    }
    
    
}
