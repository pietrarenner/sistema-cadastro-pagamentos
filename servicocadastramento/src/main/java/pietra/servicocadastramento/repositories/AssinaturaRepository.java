package pietra.servicocadastramento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import pietra.servicocadastramento.entities.Assinatura;
import pietra.servicocadastramento.enums.Status;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    Assinatura save(Assinatura assinatura);
    List<Assinatura> findByStatus(Status status);
    List<Assinatura> findByCodCli(Long codcli);
    List<Assinatura> findByCodApp(Long codapp);
}
