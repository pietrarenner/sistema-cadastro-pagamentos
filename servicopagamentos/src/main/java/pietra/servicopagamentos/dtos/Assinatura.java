package pietra.servicopagamentos.dtos;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Assinatura {
    private Long codigo;
    private Long codApp;
    private Long codCli;

    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Assinatura(Long codApp, Long codCli, LocalDateTime inicio, LocalDateTime fim) {
        this.codApp = codApp;
        this.codCli = codCli;
        this.inicio = inicio;
        this.fim = fim;
    }
}
