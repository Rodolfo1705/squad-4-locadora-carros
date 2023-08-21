package org.system.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AdicionarCarrinhoDTO implements Serializable {
    String email;
    Long id;

    public AdicionarCarrinhoDTO(String email, Long id) {
        this.email = email;
        this.id = id;
    }
}
