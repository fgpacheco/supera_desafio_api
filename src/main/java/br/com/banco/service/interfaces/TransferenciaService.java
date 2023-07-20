package br.com.banco.service.interfaces;

import br.com.banco.model.dto.TransferenciaDTO;
import br.com.banco.model.filtros.FiltroTransferencia;

import java.util.Set;

public interface TransferenciaService {

    Set<TransferenciaDTO> findByConta(Long idConta);

    Set<TransferenciaDTO> findAll();

    Set<TransferenciaDTO> search(FiltroTransferencia filtros);
}
