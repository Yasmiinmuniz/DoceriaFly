package dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueDTO {
    private Long idEstoque;
    private Long idProduto;
    private String status;
}
