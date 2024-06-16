package pietra.servicopagamentos.controllers;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pietra.servicopagamentos.entities.Pagamento;
import pietra.servicopagamentos.services.PagamentoService;

@RestController
public class ServicoPagamentoController {
    private PagamentoService pagamentoService;

    public ServicoPagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/registrarpagamento")
    public Pagamento registrarPagamento(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime data, @RequestParam Long codass, @RequestParam float valorPago) {
        return pagamentoService.registraPagamento(data, codass, valorPago);
    }

    // @EventListener
    // public void handlePagamentoServicoCadastramento(PagamentoServicoCadastramento event) {
    //     //System.out.println("Recebido evento customizado - Mensagem: " + event.getMessage());
    // }

    // @EventListener
    // public void handlePagamentoServicoAssinaturaValida(PagamentoServicoAssinaturaValida event) {
    //     //System.out.println("Recebido evento customizado - Mensagem: " + event.getMessage());
    // }
}