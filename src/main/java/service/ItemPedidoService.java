package service;

import entity.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ItemPedidoRepository;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedido criarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public List<ItemPedido> listarItensPedido() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido buscarItemPedidoPorId(Long id) {
        return itemPedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("ItemPedido não encontrado."));
    }

    public ItemPedido atualizarItemPedido(Long id, ItemPedido itemPedidoAtualizado) {
        ItemPedido itemPedido = buscarItemPedidoPorId(id);
        itemPedido.setIdProduto(itemPedidoAtualizado.getIdProduto()); 
        itemPedido.setQuantidadeProduto(itemPedidoAtualizado.getQuantidadeProduto());
        itemPedido.setTotalItensPedidos(itemPedidoAtualizado.getTotalItensPedidos());
        return itemPedidoRepository.save(itemPedido); 
    }

    public void deletarItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}