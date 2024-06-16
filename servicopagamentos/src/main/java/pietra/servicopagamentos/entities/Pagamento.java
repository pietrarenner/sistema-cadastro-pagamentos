package pietra.servicopagamentos.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    @Column(nullable = false)
    private LocalDateTime dataPagamento;
    @Column(nullable = false)
    private Long codAssinatura;
    @Column(nullable = false)
    private float valorPago;

    public Pagamento(LocalDateTime dataPagamento, Long codAssinatura, float valorPago) {
        this.dataPagamento = dataPagamento;
        this.codAssinatura = codAssinatura;
        this.valorPago = valorPago;
    }
}
