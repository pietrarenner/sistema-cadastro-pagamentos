package pietra.servicoassinaturasvalidas.events;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagamentoServicoAssinaturaValidaEvento {
    private Long codass;
    private double valorPago;
    private LocalDate dataPagamento;
}
