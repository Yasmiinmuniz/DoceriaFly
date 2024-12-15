package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findByName(String nome);
}
