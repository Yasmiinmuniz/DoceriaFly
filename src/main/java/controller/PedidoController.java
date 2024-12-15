package controller;

import dto.PedidoDTO;
import entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.criarPedido(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
        List<PedidoDTO> pedidos = pedidoService.listarPedidos();  // Agora retorna uma lista de PedidoDTO
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPedidoPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);
        PedidoDTO pedidoDTO = pedidoService.mapearPedidoParaPedidoDTO(pedido);  // Aqui você mapeia o Pedido para PedidoDTO
        return new ResponseEntity<>(pedidoDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        Pedido pedidoAtualizadoResult = pedidoService.atualizarPedido(id, pedidoAtualizado);
        PedidoDTO pedidoDTO = pedidoService.mapearPedidoParaPedidoDTO(pedidoAtualizadoResult);
        return new ResponseEntity<>(pedidoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
