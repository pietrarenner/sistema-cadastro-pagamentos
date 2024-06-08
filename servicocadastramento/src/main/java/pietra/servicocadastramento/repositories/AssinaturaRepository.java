package pietra.servicocadastramento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pietra.servicocadastramento.entities.Assinatura;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    
}
