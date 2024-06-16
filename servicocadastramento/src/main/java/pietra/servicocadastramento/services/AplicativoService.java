package pietra.servicocadastramento.services;

import java.util.List;

import org.springframework.stereotype.Service;
import pietra.servicocadastramento.entities.Aplicativo;
import pietra.servicocadastramento.exceptions.ResourceNotFound;
import pietra.servicocadastramento.repositories.AplicativoRepository;

@Service
public class AplicativoService {
    AplicativoRepository aplicativoRepository;

    public AplicativoService(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public List<Aplicativo> getAplicativos() {
        return aplicativoRepository.findAll();
    }

    public Aplicativo updateCustoAplicativo(float novoCusto, Long codApp) {
        Aplicativo app = aplicativoRepository.findById(codApp).orElseThrow(() -> new ResourceNotFound("Não existe aplicativo com esse ID."));
        app.setCustoMensal(novoCusto);
        aplicativoRepository.save(app);

        return app;
    }
}

