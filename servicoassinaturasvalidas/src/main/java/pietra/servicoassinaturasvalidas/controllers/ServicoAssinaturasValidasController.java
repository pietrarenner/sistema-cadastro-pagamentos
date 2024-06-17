package pietra.servicoassinaturasvalidas.controllers;

import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pietra.servicoassinaturasvalidas.events.PagamentoServicoAssinaturaValidaEvento;
import pietra.servicoassinaturasvalidas.services.AssinaturaService;

@RestController
public class ServicoAssinaturasValidasController {
    private AssinaturaService assinaturaService;

    public ServicoAssinaturasValidasController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @GetMapping("assinvalidas/:codass")
    public boolean isAssinaturaValida(@RequestParam("codass") Long codass) {
        return assinaturaService.assinaturaIsValid(codass);
    }

    @EventListener
    public void handlePagamentoServicoAssinaturaValidaEvento(PagamentoServicoAssinaturaValidaEvento evento) {
        assinaturaService.removeCache(evento.getCodass());
    }
}