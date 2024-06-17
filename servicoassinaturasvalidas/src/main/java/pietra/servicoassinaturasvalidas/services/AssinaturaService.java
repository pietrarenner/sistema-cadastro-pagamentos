package pietra.servicoassinaturasvalidas.services;

import org.springframework.stereotype.Service;

import pietra.servicoassinaturasvalidas.entities.Assinatura;
import pietra.servicoassinaturasvalidas.repositories.AssinaturaRepository;

@Service
public class AssinaturaService {
    AssinaturaRepository assinaturaRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public boolean assinaturaIsValid(Long codass) {
        return assinaturaRepository.isValid(codass);   
    }

    public void removeCache(Long codass) {
        // método para remover entrada do cache
    }

}