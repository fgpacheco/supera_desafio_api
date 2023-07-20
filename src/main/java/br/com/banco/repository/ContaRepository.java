package br.com.banco.repository;

import br.com.banco.model.entity.Conta;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContaRepository extends PagingAndSortingRepository<Conta, Long> {
}


