package pietra.servicopagamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pietra.servicopagamentos.entities.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    
}
