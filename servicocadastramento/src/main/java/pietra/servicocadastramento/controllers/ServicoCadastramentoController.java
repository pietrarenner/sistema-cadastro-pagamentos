package pietra.servicocadastramento.controllers;

import java.util.List;

import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pietra.servicocadastramento.services.AplicativoService;
import pietra.servicocadastramento.dto.AssinaturaDTO;
import pietra.servicocadastramento.dto.CustoDTO;
import pietra.servicocadastramento.entities.Aplicativo;
import pietra.servicocadastramento.entities.Assinatura;
import pietra.servicocadastramento.entities.Cliente;
import pietra.servicocadastramento.enums.Status;
import pietra.servicocadastramento.services.AssinaturaService;
import pietra.servicocadastramento.services.ClienteService;

@RestController
@CrossOrigin(origins = "*")
public class ServicoCadastramentoController {
    private AssinaturaService assinaturaService;
    private AplicativoService aplicativoService;
    private ClienteService clienteService;

    public ServicoCadastramentoController(ClienteService clienteService, AssinaturaService assinaturaService, AplicativoService aplicativoService) {
        this.clienteService = clienteService;
        this.assinaturaService = assinaturaService;
        this.aplicativoService = aplicativoService;
    }
    
    @GetMapping("/servcad/clientes") 
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/servcad/aplicativos")
    public List<Aplicativo> getAplicativos() {
        return aplicativoService.getAplicativos();
    }

    @PostMapping("/servcad/assinaturas")
    public Assinatura criarAssinatura(@RequestBody AssinaturaDTO newAssinatura) {
        return assinaturaService.createAssinatura(newAssinatura);
    }

    @PatchMapping("/servcad/aplicativos/{idAplicativo}")
    public Aplicativo atualizarCustoAplicativo(@RequestBody CustoDTO custoDTO, @PathVariable("idAplicativo") Long codApp) {
        return aplicativoService.updateCustoAplicativo(custoDTO.getCusto(), codApp);
    }
    
    @GetMapping("/servcad/assinaturas/{tipo}")
    public List<Assinatura> getAssinaturasTipo(@PathVariable("tipo") Status tipo) {
        return assinaturaService.getAssinaturasTipo(tipo);
    }

    @GetMapping("/servcad/asscli")
    public List<Assinatura> getAssinaturasCliente(@RequestParam("codcli") Long codcli) {
        return assinaturaService.getAssinaturasCliente(codcli);
    }

    @GetMapping("/servcad/assapp")
    public List<Assinatura> getAssinaturas(@RequestParam("codapp") Long codapp) {
        return assinaturaService.getAssinaturasApp(codapp);
    }

    // @EventListener
    // public void handlePagamentoServicoCadastramentoEvento(PagamentoServicoCadastramentoEvento evento) {
    //     System.out.println("Recebido evento customizado - Mensagem: " + evento.getMessage());
    // }
}
