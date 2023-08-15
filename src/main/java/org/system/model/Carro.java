package org.system.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carro {
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    private List<Acessorio> acessorios = new ArrayList<>();
}
