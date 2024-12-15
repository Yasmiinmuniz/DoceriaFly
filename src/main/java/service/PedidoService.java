package service;

import dto.PedidoDTO;
import entity.Pedido;
import mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PedidoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private BaseMapper mapper;

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);  
    }

    public List<PedidoDTO> listarPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream()
                .map(mapper::toPedidoDTO)  
                .collect(Collectors.toList());
    }

    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado.")); 
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        Pedido pedido = buscarPedidoPorId(id);
        pedido.setDataPedido(pedidoAtualizado.getDataPedido());
        pedido.setStatusPedido(pedidoAtualizado.getStatusPedido());
        pedido.setItensPedido(pedidoAtualizado.getItensPedido());
        pedido.setTotalPedido(pedidoAtualizado.getTotalPedido());
        return pedidoRepository.save(pedido);  
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id); 
    }

    public PedidoDTO mapearPedidoParaPedidoDTO(Pedido pedido) {
        return mapper.toPedidoDTO(pedido);
    }
}
