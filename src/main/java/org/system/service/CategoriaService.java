package org.system.service;

import org.springframework.stereotype.Service;
import org.system.entity.Categoria;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CategoriaService {
    public List<String> getCategorias(){
        return Stream.of(Categoria.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
