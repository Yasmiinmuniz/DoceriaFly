package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Estoque findByProdutoId(Long idProduto);
}