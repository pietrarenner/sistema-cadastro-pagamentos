package pietra.servicocadastramento.entities;
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
public class Cliente {
    @Id
    private Long codigo;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
}
