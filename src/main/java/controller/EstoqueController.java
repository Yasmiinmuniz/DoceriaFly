package controller;

import entity.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EstoqueService;

import java.util.List;

@RestController
@RequestMapping("/api/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    // Adicionar produto ao estoque
    @PostMapping("/adicionar")
    public ResponseEntity<Estoque> adicionarProdutoAoEstoque(@RequestParam String nomeProduto, @RequestParam int quantidade) {
        try {
            Estoque estoque = estoqueService.adicionarProdutoAoEstoque(nomeProduto, quantidade);
            return new ResponseEntity<>(estoque, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Vender produto (subtrair quantidade do estoque)
    @PostMapping("/vender")
    public ResponseEntity<Estoque> venderProduto(@RequestParam Long idProduto, @RequestParam int quantidadeVendida) {
        try {
            Estoque estoque = estoqueService.venderProduto(idProduto, quantidadeVendida);
            return new ResponseEntity<>(estoque, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Listar todos os estoques
    @GetMapping
    public ResponseEntity<List<Estoque>> listarEstoques() {
        List<Estoque> estoques = estoqueService.listarEstoques();
        return new ResponseEntity<>(estoques, HttpStatus.OK);
    }
}
