package pietra.servicocadastramento.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PagamentoDTO {
    private int dia;
    private int mes;
    private int ano;
    private Long codass;
    private float valorPago;
}