package pietra.servicoassinaturasvalidas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import pietra.servicoassinaturasvalidas.dto.PagamentoDTO;
import pietra.servicoassinaturasvalidas.services.AssinaturaService;

@Component
public class Receiver {
    public static final String QUEUENAME = "notificacao.pagamento.assinaturas-validas";
    private static Logger logger = LogManager.getLogger(Receiver.class);
    private AssinaturaService assinaturaService;

    public Receiver(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }
    
    @RabbitListener(queues = QUEUENAME)
    public void receive(PagamentoDTO dto) {
        logger.info("Mensagem recebida: {}", dto);
        assinaturaService.removeCache(dto.getCodass());
    }
}
