package entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TB_ITEM_PEDIDO")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEM_PEDIDO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    private Produto produto;

    @Column(name = "QUANTIDADE_PRODUTO", nullable = false)
    private int quantidadeProduto;

    @Column(name = "TOTAL_ITENS_PEDIDOS", nullable = false)
    private double totalItensPedidos;

    public void setIdProduto(Long idProduto) {
        if (this.produto == null) {
            this.produto = new Produto();
        }
        this.produto.setId(idProduto);
    }

    public Long getIdProduto() {
        return produto != null ? produto.getId() : null;
    }

    public double getTotalItensPedidos() {
        return totalItensPedidos;
    }

    public void setTotalItensPedidos(double totalItensPedidos) {
        this.totalItensPedidos = totalItensPedidos;
    }
}
