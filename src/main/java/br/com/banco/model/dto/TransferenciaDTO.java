package br.com.banco.model.dto;

import br.com.banco.model.entity.Transferencia;
import br.com.banco.utils.DataUtils;
import lombok.*;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import static br.com.banco.utils.DataUtils.formatarDataHora;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TransferenciaDTO implements Serializable {

    private static final long serialVersionUID = -1316072942652510090L;

    @EqualsAndHashCode.Include
    private Long id;
    private String dataTransferencia;
    private Double valor;
    private String tipo;
    private String nomeOperadorTransacao;
    private Long idConta;
    private String nomeResponsavelConta;

    public TransferenciaDTO(Transferencia transferencia) {
        this.id = transferencia.getId();
        this.dataTransferencia = formatarDataHora(transferencia.getDataTransferencia());
        this.valor = transferencia.getValor();
        this.tipo = transferencia.getTipo();
        this.nomeOperadorTransacao = transferencia.getNomeOperadorTransacao();
        this.idConta = transferencia.getConta().getId();
        this.nomeResponsavelConta = transferencia.getConta().getNomeResponsavel();
    }
}
