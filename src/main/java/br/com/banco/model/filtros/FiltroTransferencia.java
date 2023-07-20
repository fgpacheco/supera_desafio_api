package br.com.banco.model.filtros;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FiltroTransferencia implements Serializable {

    private String dataInicial;
    private String dataFinal;
    private String operador;

}
