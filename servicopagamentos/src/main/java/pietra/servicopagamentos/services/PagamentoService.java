package pietra.servicopagamentos.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import pietra.servicopagamentos.entities.Pagamento;
import pietra.servicopagamentos.repositories.PagamentoRepository;

@Service
public class PagamentoService {
    PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento registraPagamento(LocalDateTime data, Long codass, float valorPago) {
        Pagamento newPagamento = new Pagamento(data, codass, valorPago);
    
        return pagamentoRepository.save(newPagamento);
    }

}