package dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;
    private String dataPedido;
    private String statusPedido;
    private List<ItemPedidoDTO> itensPedido;
    private Double totalPedido;
}
