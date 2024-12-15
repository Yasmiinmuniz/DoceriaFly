package mapper;

import org.mapstruct.Mapper;
// import dto.EstoqueDTO;
// import entity.Estoque;
// import dto.ItemPedidoDTO;
// import entity.ItemPedido;
// import dto.ProdutoDTO;
// import entity.Produto;
import dto.PagamentoDTO;
import entity.Pagamento;
import dto.PedidoDTO;
import entity.Pedido;


@Mapper(componentModel = "spring")
public interface BaseMapper {

    // EstoqueDTO toEstoqueDTO(Estoque estoque);

    // Estoque toEstoque(EstoqueDTO estoqueDTO);

    PedidoDTO toPedidoDTO(Pedido pedido);

    Pedido toPedido(PedidoDTO pedidoDTO);

    // ItemPedidoDTO toItemPedidoDTO(ItemPedido itemPedido);

    // ItemPedido toItemPedido(ItemPedidoDTO itemPedidoDTO);

    PagamentoDTO toPagamentoDTO(Pagamento pagamento);

    Pagamento toPagamento(PagamentoDTO pagamentoDTO);

//     // Se totalItensPedido existir tanto na entidade quanto no DTO
//     @Mapping(source = "totalItensPedido", target = "totalItensPedido")
//     PedidoDTO toPedidoDTO(Pedido pedido);
    
//     // Caso você precise calcular ou manipular o valor de totalItensPedido
//     @Mapping(expression = "java(pedido.getItensPedido().stream().mapToDouble(ItemPedido::getPrecoTotal).sum())", target = "totalItensPedido")
//     PedidoDTO toPedidoDTO(Pedido pedido);
// }

}
