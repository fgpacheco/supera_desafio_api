package br.com.banco.service;

import br.com.banco.exception.BancoException;
import br.com.banco.model.dto.TransferenciaDTO;
import br.com.banco.model.entity.Conta;
import br.com.banco.model.entity.Transferencia;
import br.com.banco.model.filtros.FiltroTransferencia;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.service.interfaces.TransferenciaService;
import br.com.banco.utils.DataUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Objects.isNull;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final ContaRepository contaRepository;

    public TransferenciaServiceImpl(TransferenciaRepository transferenciaRepository, ContaRepository contaRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.contaRepository = contaRepository;
    }

    @Override
    public Set<TransferenciaDTO> findByConta(Long idConta) {
        if (isNull(idConta)) {
            throw new BancoException("idConta invalido: NULL");
        }
        getContaOrThrow(idConta);
        Set<Transferencia> transferencias = transferenciaRepository.findByContaId(idConta);
        Set<TransferenciaDTO> transferenciasDTO = new LinkedHashSet<>();

        transferencias.stream().forEach(t -> transferenciasDTO.add(new TransferenciaDTO(t)));

        return transferenciasDTO;
    }

    @Override
    public Set<TransferenciaDTO> findAll() {
        Iterator<Transferencia> transferencias = transferenciaRepository.findAll().iterator();
        Set<TransferenciaDTO> transferenciasDTO = new LinkedHashSet<>();

        transferencias.forEachRemaining(t -> transferenciasDTO.add(new TransferenciaDTO(t)));
        return transferenciasDTO;
    }

    @Override
    public Set<TransferenciaDTO> search(FiltroTransferencia filtros) {
        if (isNull(filtros)) {
            throw new BancoException("Fitros de pesquisa NULL");
        }
        String nomeOperador = filtros.getOperador();
        LocalDateTime dataInicial = isNull(filtros.getDataInicial()) ? null : DataUtils.obterLocalDateTime(filtros.getDataInicial());
        LocalDateTime dataFinal = isNull(filtros.getDataFinal()) ? null : DataUtils.obterLocalDateTime(filtros.getDataFinal());

        Set<Transferencia> transferencias = transferenciaRepository.search(nomeOperador, dataInicial, dataFinal);
        Set<TransferenciaDTO> transferenciasDTO = new LinkedHashSet<>();

        transferencias.stream().forEach(t -> transferenciasDTO.add(new TransferenciaDTO(t)));
        return transferenciasDTO;
    }

    private Conta getContaOrThrow(Long idConta) {
        return contaRepository
                .findById(idConta)
                .orElseThrow(() -> new BancoException("Conta não encontrada no banco de dados"));
    }


}
