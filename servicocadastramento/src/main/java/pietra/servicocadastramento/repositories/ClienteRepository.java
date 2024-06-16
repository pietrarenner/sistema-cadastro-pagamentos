package pietra.servicocadastramento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pietra.servicocadastramento.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAll(); 
}
