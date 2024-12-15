package entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TB_PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private Long idPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "FORMA_PAGAMENTO", nullable = false)
    private FormaPagamento formaPagamento;

    @Column(name = "VALOR_PAGAMENTO", nullable = false)
    private Double valorPagamento;
}
