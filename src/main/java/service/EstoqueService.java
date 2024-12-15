package service;

import entity.Estoque;
import entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EstoqueRepository;
import repository.ProdutoRepository;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // Método para criar um novo estoque
    public Estoque criarEstoque(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    // Método para listar todos os estoques
    public List<Estoque> listarEstoques() {
        return estoqueRepository.findAll();
    }

    // Método para buscar um estoque por ID
    public Estoque buscarEstoquePorId(Long id) {
        return estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado."));
    }

    // Método para adicionar produto ao estoque
    public Estoque adicionarProdutoAoEstoque(String nomeProduto, int quantidade) {
        Produto produto = produtoRepository.findByName(nomeProduto);
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado.");
        }

        // Verificar se já existe um estoque para o produto
        Estoque estoqueExistente = estoqueRepository.findByProdutoId(produto.getId());
        if (estoqueExistente != null) {
            // Se o estoque já existir, apenas atualizamos a quantidade
            estoqueExistente.setQuantidade(estoqueExistente.getQuantidade() + quantidade);
            return estoqueRepository.save(estoqueExistente);
        }

        // Se não existir, criamos um novo estoque
        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        estoque.setStatus("Disponível");
        estoque.setQuantidade(quantidade);
        return estoqueRepository.save(estoque);
    }

    // Método para vender produto e atualizar estoque
    public Estoque venderProduto(Long idProduto, int quantidadeVendida) {
        Estoque estoque = estoqueRepository.findByProdutoId(idProduto);
        if (estoque == null) {
            throw new RuntimeException("Estoque não encontrado para o produto.");
        }

        if (estoque.getQuantidade() < quantidadeVendida) {
            throw new RuntimeException("Quantidade em estoque insuficiente.");
        }

        // Subtrair a quantidade
        estoque.setQuantidade(estoque.getQuantidade() - quantidadeVendida);
        return estoqueRepository.save(estoque);
    }

    // Método para deletar um estoque
    public void deletarEstoque(Long id) {
        estoqueRepository.deleteById(id);
    }
}
