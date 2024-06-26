package pietra.servicopagamentos.services;

import java.time.LocalDateTime;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import pietra.servicopagamentos.dtos.Assinatura;
import pietra.servicopagamentos.dtos.PagamentoDTO;
import pietra.servicopagamentos.entities.Pagamento;
import pietra.servicopagamentos.exceptions.ResourceNotFound;
import pietra.servicopagamentos.proxy.AssinaturaProxy;
import pietra.servicopagamentos.repositories.PagamentoRepository;

@Service
public class PagamentoService {
    private PagamentoRepository pagamentoRepository;
    private RabbitTemplate rabbitTemplate;
    private FanoutExchange fanoutExchange;
    private AssinaturaProxy assinaturaProxy;

    public PagamentoService(PagamentoRepository pagamentoRepository,  RabbitTemplate rabbitTemplate, FanoutExchange fanoutExchange, AssinaturaProxy assinaturaProxy) {
        this.pagamentoRepository = pagamentoRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.fanoutExchange = fanoutExchange;
        this.assinaturaProxy= assinaturaProxy;
    }

    public Pagamento registraPagamento(LocalDateTime data, Long codass, float valorPago) {
        Assinatura assinatura = assinaturaProxy.getAssinaturaId(codass);

        if(assinatura != null) {
            Pagamento newPagamento = new Pagamento(data, codass, valorPago);
            Pagamento result = pagamentoRepository.save(newPagamento);
        
            PagamentoDTO dto = new PagamentoDTO(data.getDayOfMonth(), data.getMonthValue(), data.getYear(), codass, valorPago);
            rabbitTemplate.convertAndSend(fanoutExchange.getName(),"",dto);

            return result;
        }

        throw new ResourceNotFound("Assinatura não existe.");
    }
}