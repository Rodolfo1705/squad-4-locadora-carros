package org.system.model;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Aluguel {
    private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolução;
    private BigDecimal valorTotal;
    private ApoliceSeguro apoliceSeguro;
}
