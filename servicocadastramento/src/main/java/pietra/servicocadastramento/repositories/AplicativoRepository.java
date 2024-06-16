package pietra.servicocadastramento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pietra.servicocadastramento.entities.Aplicativo;

public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {
    List<Aplicativo> findAll();
}
