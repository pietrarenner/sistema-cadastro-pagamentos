package pietra.servicoassinaturasvalidas.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pietra.servicoassinaturasvalidas.entities.Assinatura;
import pietra.servicoassinaturasvalidas.enums.Status;
import pietra.servicoassinaturasvalidas.proxy.AssinaturaProxy;
import pietra.servicoassinaturasvalidas.repositories.AssinaturaRepository;

@Service
public class AssinaturaService {
    AssinaturaRepository assinaturaRepository;
    AssinaturaProxy assinaturaProxy;
    private static Logger logger = LogManager.getLogger(AssinaturaService.class);

    public AssinaturaService(AssinaturaRepository assinaturaRepository, AssinaturaProxy assinaturaProxy) {
        this.assinaturaRepository = assinaturaRepository;
        this.assinaturaProxy = assinaturaProxy;
    }

    public boolean assinaturaIsValid(Long codass) {
        Optional<Assinatura> searchedAssinaturaOptional = assinaturaRepository.findById(codass);
        if(searchedAssinaturaOptional.isPresent()) {
            logger.info("assinatura já no banco {}.", searchedAssinaturaOptional);
            Assinatura searchedAssinatura = searchedAssinaturaOptional.get();
            if(searchedAssinatura.getStatus() == Status.ATIVA) return true;
            else return false;
        }
        else {
            logger.info("assinatura buscada.");
            Assinatura newAssinatura = assinaturaProxy.getAssinaturaId(codass);
            assinaturaRepository.save(newAssinatura);
            if(newAssinatura.getStatus() == Status.ATIVA) return true;
            else return false;
        }
    }

    public void removeCache(Long codass) {
        Optional<Assinatura> searchedAssinaturaOptional = assinaturaRepository.findById(codass);
        if(searchedAssinaturaOptional != null) {
            assinaturaRepository.deleteById(codass);
            logger.info("assinatura deletada.");
        }
    }

}