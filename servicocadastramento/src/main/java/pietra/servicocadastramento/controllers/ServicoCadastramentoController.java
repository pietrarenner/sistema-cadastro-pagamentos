package pietra.servicocadastramento.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.event.EventListener;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import pietra.servicocadastramento.entities.Aplicativo;
import pietra.servicocadastramento.entities.Assinatura;
import pietra.servicocadastramento.entities.Cliente;

public class ServicoCadastramentoController {
    enum Tipo {
        TODAS,
        ATIVAS,
        CANCELADAS,
    }
    
    // @GetMapping("/servcad/clientes") // lista com clientes cadastrados
    // public List<Cliente> getClientes() {}

    // @GetMapping("/servcad/aplicativos")
    // public List<Aplicativo> getAplicativos() {}

    // @PostMapping("/servcad/assinaturas")
    // public Assinatura criarAssinatura(@RequestBody Long codCliente, @RequestBody Long codAplicativo) {}

    // @PatchMapping("/servcad/aplicativos/:idAplicativo")
    // public Aplicativo atualizarCustoAplicativo(@RequestBody float custo) {}
    
    // @GetMatching("/servcad/assinaturas/{tipo}")
    // public List<Assinatura> getAssinaturasTipo(@RequestParam("tipo") Tipo tipo) {}

    // @GetMapping("/servcad/asscli/:codcli")
    // public List<Assinatura> getAssinaturasCiente(@RequestParam("codcli") Long codcli) {} {} 

    // @GetMapping("/servcad/assapp/:codapp")
    // public List<Assinatura> getAssinaturas(@RequestParam("codapp") Long codapp) {}

    // @EventListener
    // public void handlePagamentoServicoCadastramentoEvento(PagamentoServicoCadastramentoEvento evento) {
    //     System.out.println("Recebido evento customizado - Mensagem: " + evento.getMessage());
    // }
}
