package pietra.servicopagamentos.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.context.event.EventListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import pietra.servicopagamentos.entities.Pagamento;


public class ServicoPagamentoController {
    // @PostMapping("/registrapagamento")
    // public Pagamento resgistraPagamento(@RequestParam Date data, @RequestBody Long codass, @RequestBody float valorPago) {}

    // @EventListener
    // public void handlePagamentoServicoCadastramento(PagamentoServicoCadastramento event) {
    //     //System.out.println("Recebido evento customizado - Mensagem: " + event.getMessage());
    // }

    // @EventListener
    // public void handlePagamentoServicoAssinaturaValida(PagamentoServicoAssinaturaValida event) {
    //     //System.out.println("Recebido evento customizado - Mensagem: " + event.getMessage());
    // }
}