package pietra.servicopagamentos.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pagamento {
    @Id
    private Long codigo;
    @Column(nullable = false)
    private Date dataPagamento;
    @Column(unique = true, nullable = false)
    private Long codAssinatura;
    @Column(nullable = false)
    private float valorPago;    
}
