package pietra.servicoassinaturasvalidas.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pietra.servicoassinaturasvalidas.entities.Assinatura;

@FeignClient(name = "servicocadastramento")
public interface AssinaturaProxy {
    @GetMapping("/servicocadastramento/servcad/assinatura/{id}")
    public Assinatura getAssinaturaId(@PathVariable("id") Long id);
}
