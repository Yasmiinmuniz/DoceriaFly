package dto;

import entity.FormaPagamento;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {
    private Long idPagamento;
    private FormaPagamento formaPagamento;
    private Double valorPagamento;
}
