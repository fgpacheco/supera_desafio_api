package br.com.banco.config;

import br.com.banco.exception.BancoException;
import br.com.banco.model.dto.ResponseExceptionDTO;
import br.com.banco.utils.DataUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BancoException.class)
    public ResponseEntity<ResponseExceptionDTO> bancoException(BancoException ex, HttpServletRequest request) {
        ResponseExceptionDTO response = ResponseExceptionDTO.builder()
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .error(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase())
                .timestamp(DataUtils.formatarDataHora(LocalDateTime.now()))
                .path(request.getRequestURI())
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseExceptionDTO> handleException(HttpServletRequest request, Exception ex) {
        ResponseExceptionDTO resposta = ResponseExceptionDTO.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .timestamp(DataUtils.formatarDataHora(LocalDateTime.now()))
                .path(request.getRequestURI())
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(resposta);
    }
}
