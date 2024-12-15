package controller;

import entity.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ItemPedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedido> criarItemPedido(@RequestBody ItemPedido itemPedido) {
        ItemPedido novoItemPedido = itemPedidoService.criarItemPedido(itemPedido);
        return new ResponseEntity<>(novoItemPedido, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemPedido>> listarItensPedido() {
        List<ItemPedido> itensPedido = itemPedidoService.listarItensPedido();
        return new ResponseEntity<>(itensPedido, HttpStatus.OK);
    }
}