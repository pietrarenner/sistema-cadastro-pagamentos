package pietra.servicoassinaturasvalidas.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Assinatura {
    @Id
    @Column(nullable = false)
    private Long codigo;
    @Column(nullable = false)
    private Long codApp;
    @Column(nullable = false)
    private Long codCli;
    
    @Column(name = "inicio_vigencia", nullable = false)
    private Date inicio;
    @Column(name = "fim_vigencia", nullable = false)
    private Date fim;
    
}
