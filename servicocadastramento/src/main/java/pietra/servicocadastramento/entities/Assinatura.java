package pietra.servicocadastramento.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pietra.servicocadastramento.enums.Status;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"codCli", "codApp"})})
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    @Column(name = "cod_app", nullable = false)
    private Long codApp;
    @Column(name = "cod_cli", nullable = false)
    private Long codCli;

    @Column(name = "inicio_vigencia", nullable = false)
    private LocalDateTime inicio;
    @Column(name = "fim_vigencia", nullable = false)
    private LocalDateTime fim;
    @Column(nullable = false)
    private Status status;

    public Assinatura(Long codApp, Long codCli, LocalDateTime inicio, LocalDateTime fim) {
        this.codApp = codApp;
        this.codCli = codCli;
        this.inicio = inicio;
        this.fim = fim;
        this.status = Status.ATIVA;
    }
}
