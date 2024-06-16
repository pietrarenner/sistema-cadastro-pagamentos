package pietra.servicocadastramento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import pietra.servicocadastramento.entities.Cliente;
import pietra.servicocadastramento.repositories.ClienteRepository;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }
}
