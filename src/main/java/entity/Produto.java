package entity;

import lombok.*;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TB_Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_Produto")
    private Long id;

    @Column(name= "NOME")
    private String nome;

    @Column(name= "CATEGOTIA")
    private String categoria;

    @Column(name= "QUANTIDADE")
    private int quantidade;

    @Column(name= "PRECO")
    private double preco;

    @Column(name= "DATA_CRIACAO")
    private Date dataCriacao;

    @Column(name= "DATA_VALIDADE")
    private Date dataValidade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_PRODUTO_ESTOQUE",
            joinColumns = @JoinColumn(name = "ID_PRODUTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_ESTOQUE")
    )
    private List<Estoque> cast;

}
