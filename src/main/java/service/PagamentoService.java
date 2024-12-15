package service;

import entity.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PagamentoRepository;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento criarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento buscarPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pagamento não encontrado."));
    }

    public Pagamento atualizarPagamento(Long id, Pagamento pagamentoAtualizado) {
        Pagamento pagamento = buscarPagamentoPorId(id);
        pagamento.setFormaPagamento(pagamentoAtualizado.getFormaPagamento());
        pagamento.setValorPagamento(pagamentoAtualizado.getValorPagamento());
        return pagamentoRepository.save(pagamento);
    }

    public void deletarPagamento(Long id) {
        pagamentoRepository.deleteById(id);
    }
}