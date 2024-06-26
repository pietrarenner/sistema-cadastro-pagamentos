package pietra.servicocadastramento;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import pietra.servicocadastramento.dto.PagamentoDTO;
import pietra.servicocadastramento.entities.Assinatura;
import pietra.servicocadastramento.services.AssinaturaService;

@Component
public class Receiver {
    public static final String QUEUENAME = "notificacao.pagamento.cadastramento";
    private static Logger logger = LogManager.getLogger(Receiver.class);
    private AssinaturaService assinaturaService;

    public Receiver(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }
    
    @RabbitListener(queues = QUEUENAME)
    public void receive(PagamentoDTO dto) {
        logger.info("Mensagem recebida: {}", dto);
        Assinatura updatedAssinatura = assinaturaService.updateFim(dto.getCodass(), dto.getValorPago());
        logger.info("assinatura atualizada: {}", updatedAssinatura);
    }
}