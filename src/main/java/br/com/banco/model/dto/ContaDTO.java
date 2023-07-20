package br.com.banco.model.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContaDTO implements Serializable {

    private static final long serialVersionUID = -4538739689679696472L;

    @EqualsAndHashCode.Include
    private Long id;
    private String nomeResponsavel;
    private Long idTrasnferencias;
    private String tipo;
}
