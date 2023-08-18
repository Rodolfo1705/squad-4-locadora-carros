package org.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "apolices_seguro")
@NoArgsConstructor
public class ApoliceSeguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valorFranquia")
    private BigDecimal valorFranquia;
    @Column(name = "protecaoTerceiro")
    private boolean protecaoTerceiro;
    @Column(name = "protecaoCausasNaturais")
    private boolean protecaoCausasNaturais;
    @Column(name = "protecaoRoubo")
    private boolean protecaoRoubo;

    public ApoliceSeguro(Long id, BigDecimal valorFranquia, boolean protecaoTerceiro, boolean protecaoCausasNaturais, boolean protecaoRoubo) {
        this.id = id;
        this.valorFranquia = valorFranquia;
        this.protecaoTerceiro = protecaoTerceiro;
        this.protecaoCausasNaturais = protecaoCausasNaturais;
        this.protecaoRoubo = protecaoRoubo;
    }

    public BigDecimal getValorFranquia() {
        return valorFranquia;
    }
    public boolean isProtecaoTerceiro() {
        return protecaoTerceiro;
    }

    public boolean isProtecaoCausasNaturais() {
        return protecaoCausasNaturais;
    }

    public boolean isProtecaoRoubo() {
        return protecaoRoubo;
    }
}
