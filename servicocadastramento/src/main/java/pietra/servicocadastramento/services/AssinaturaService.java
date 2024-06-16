package pietra.servicocadastramento.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import pietra.servicocadastramento.dto.AssinaturaDTO;
import pietra.servicocadastramento.entities.Assinatura;
import pietra.servicocadastramento.enums.Status;
import pietra.servicocadastramento.exceptions.ResourceNotFound;
import pietra.servicocadastramento.repositories.AssinaturaRepository;

@Service
public class AssinaturaService {
    AssinaturaRepository assinaturaRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public Assinatura createAssinatura(AssinaturaDTO assinaturaDTO) {
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fim = inicio.plusDays(7); 

        Assinatura newAssinatura = new Assinatura(assinaturaDTO.getCodApp(), assinaturaDTO.getCodCli(), inicio, fim);

        newAssinatura = assinaturaRepository.save(newAssinatura);

        return newAssinatura;
    }

    // public boolean assinaturaIsValid() {

    // }

    public List<Assinatura> getAssinaturasCliente(Long codcli) {
        return assinaturaRepository.findByCodCli(codcli);
    }

    public List<Assinatura> getAssinaturasTipo(Status tipo) {
        if(tipo == Status.ATIVA || tipo == Status.CANCELADA) return assinaturaRepository.findByStatus(tipo);
        else if(tipo == Status.TODAS) return assinaturaRepository.findAll();
        else throw new ResourceNotFound("Tipo incorreto. Tente ATIVA, CANCELADA ou TODAS.");
    }

    public List<Assinatura> getAssinaturasApp(Long codApp) {
        return assinaturaRepository.findByCodApp(codApp);
    }
    
}
