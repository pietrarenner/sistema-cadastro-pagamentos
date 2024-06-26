package pietra.servicoassinaturasvalidas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import pietra.servicoassinaturasvalidas.entities.Assinatura;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
}