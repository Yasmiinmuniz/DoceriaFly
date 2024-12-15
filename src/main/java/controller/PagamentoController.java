package controller;

import entity.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PagamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<Pagamento> criarPagamento(@RequestBody Pagamento pagamento) {
        Pagamento novoPagamento = pagamentoService.criarPagamento(pagamento);
        return new ResponseEntity<>(novoPagamento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> listarPagamentos() {
        List<Pagamento> pagamentos = pagamentoService.listarPagamentos();
        return new ResponseEntity<>(pagamentos, HttpStatus.OK);
    }
}
