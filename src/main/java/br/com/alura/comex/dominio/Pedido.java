package br.com.alura.comex.dominio;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data;

    private BigDecimal desconto;
    @Column(name = "tipo_desconto")
    @Enumerated(EnumType.STRING)
    private TipoDeDesconto tipoDoDesconto;

    @ManyToOne
    private Cliente cliente;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public TipoDeDesconto getTipoDoDesconto() {
        return tipoDoDesconto;
    }

    public void setTipoDoDesconto(TipoDeDesconto tipoDoDesconto) {
        this.tipoDoDesconto = tipoDoDesconto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
