package br.com.banco.model.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseExceptionDTO implements Serializable {

    private static final long serialVersionUID = -1478010134826305114L;

    private int statusCode;
    private String error;
    private String timestamp;
    private String path;
    private String message;

}
