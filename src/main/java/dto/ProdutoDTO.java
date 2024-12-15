package dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String categoria;
    private int quantidade;
    private double preco;
    private Data dataCriacao;
    private Data dataValidade;
}
