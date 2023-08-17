package org.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {}
