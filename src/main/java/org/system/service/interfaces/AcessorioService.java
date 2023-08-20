package org.system.service.interfaces;

import org.system.entity.Acessorio;
import org.system.entity.Aluguel;

import java.util.List;

public interface AcessorioService {
    public Acessorio save(Acessorio acessorio);
    public List<Acessorio> getAcessorios();
}
