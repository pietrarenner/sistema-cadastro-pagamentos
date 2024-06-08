package pietra.servicocadastramento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pietra.servicocadastramento.entities.Aplicativo;

public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {
    
}
