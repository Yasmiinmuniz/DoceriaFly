package entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Long id;

    @Column(name = "DATA_PEDIDO")
    private String dataPedido;

    @Column(name = "STATUS_PEDIDO")
    private String statusPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido;

    @Column(name = "TOTAL_PEDIDO")
    private Double totalPedido;
}
