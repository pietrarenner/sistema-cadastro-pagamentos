package pietra.servicocadastramento.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import pietra.servicocadastramento.dto.AssinaturaDTO;
import pietra.servicocadastramento.entities.Aplicativo;
import pietra.servicocadastramento.entities.Assinatura;
import pietra.servicocadastramento.enums.Status;
import pietra.servicocadastramento.exceptions.ResourceNotFound;
import pietra.servicocadastramento.repositories.AplicativoRepository;
import pietra.servicocadastramento.repositories.AssinaturaRepository;

@Service
public class AssinaturaService {
    AssinaturaRepository assinaturaRepository;
    AplicativoRepository aplicativoRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository, AplicativoRepository aplicativoRepository) {
        this.assinaturaRepository = assinaturaRepository;
        this.aplicativoRepository = aplicativoRepository;
    }

    public Assinatura createAssinatura(AssinaturaDTO assinaturaDTO) {
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fim = inicio.plusDays(7); 

        Assinatura newAssinatura = new Assinatura(assinaturaDTO.getCodApp(), assinaturaDTO.getCodCli(), inicio, fim);

        newAssinatura = assinaturaRepository.save(newAssinatura);

        return newAssinatura;
    }

    public List<Assinatura> getAssinaturasCliente(Long codcli) {
        return assinaturaRepository.findByCodCli(codcli);
    }

    public List<Assinatura> getAssinaturasTipo(Status tipo) {
        if(tipo == Status.ATIVA || tipo == Status.CANCELADA) return assinaturaRepository.findByStatus(tipo);
        else if(tipo == Status.TODAS) return assinaturaRepository.findAll();
        else throw new ResourceNotFound("Tipo incorreto. Tente ATIVA, CANCELADA ou TODAS.");
    }

    public Assinatura getAssinaturaId(Long id) {
        return assinaturaRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Assinatura com esse id não encontrada."));
    }

    public List<Assinatura> getAssinaturasApp(Long codApp) {
        return assinaturaRepository.findByCodApp(codApp);
    }

    public Assinatura updateFim(Long codass, float valorPago) {
        Optional<Assinatura> optionalPaidAssinatura = assinaturaRepository.findById(codass);
        if(optionalPaidAssinatura.isPresent()) {
            Assinatura paidAssinatura = optionalPaidAssinatura.get();
            Optional<Aplicativo> optionalApp = aplicativoRepository.findById(paidAssinatura.getCodApp());

            if(optionalApp.isPresent()) {
                Aplicativo app = optionalApp.get();

                if(valorPago >= app.getCustoMensal()) {
                    paidAssinatura.setFim(paidAssinatura.getFim().plusMonths(1));
    
                    assinaturaRepository.save(paidAssinatura);
    
                    return paidAssinatura;
                }
            }
        }
        return null;
    }
    
}
