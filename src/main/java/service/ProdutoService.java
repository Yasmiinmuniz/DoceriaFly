package service;

import entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Produto produto = buscarProdutoPorId(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setDataCriacao(produtoAtualizado.getDataCriacao());
        produto.setDataValidade(produtoAtualizado.getDataValidade());
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
