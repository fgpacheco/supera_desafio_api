package br.com.banco.repository;

import br.com.banco.model.entity.Transferencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Set;

public interface TransferenciaRepository extends PagingAndSortingRepository<Transferencia, Long> {

    Set<Transferencia> findByContaId(Long idConta);

    @Query(
            " SELECT t FROM Transferencia t WHERE " +
                    " (:nomeOperador IS NULL OR t.nomeOperadorTransacao = :nomeOperador) AND " +
                    " (:dataInicial IS NULL OR t.dataTransferencia >= :dataInicial) AND " +
                    " (:dataFinal IS NULL OR t.dataTransferencia <= :dataFinal) "
    )
    Set<Transferencia> search(
            @Param("nomeOperador") String nomeOperador,
            @Param("dataInicial") LocalDateTime dataInicial,
            @Param("dataFinal") LocalDateTime dataFinal);
}
