package dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {
    private Long id;
    private Long idProduto;
    private Integer quantidadeProduto;
    private Double totalItensPedido;
}