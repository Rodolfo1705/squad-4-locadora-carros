package org.system.model;

import java.math.BigDecimal;

public class ApoliceSeguro {
    private BigDecimal valorFranquia;
    private boolean protecaoTerceiro;
    private boolean protecaoCausasNaturais;
    private boolean protecaoRoubo;

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
