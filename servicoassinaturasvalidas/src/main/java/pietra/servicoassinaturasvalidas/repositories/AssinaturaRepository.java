package pietra.servicoassinaturasvalidas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pietra.servicoassinaturasvalidas.entities.Assinatura;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    @Query("SELECT CASE WHEN a.fim >= CURRENT_DATE THEN true ELSE false END FROM Assinatura a WHERE a.codigo = :codass")
    boolean isValid(Long codass);
}