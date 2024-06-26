package pietra.servicoassinaturasvalidas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pietra.servicoassinaturasvalidas.services.AssinaturaService;

@RestController
@RequestMapping("/servicoassinaturasvalidas")
public class ServicoAssinaturasValidasController {
    private AssinaturaService assinaturaService;

    public ServicoAssinaturasValidasController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @GetMapping("assinvalidas/{codass}")
    public boolean isAssinaturaValida(@PathVariable("codass") Long codass) {
        return assinaturaService.assinaturaIsValid(codass);
    }
}